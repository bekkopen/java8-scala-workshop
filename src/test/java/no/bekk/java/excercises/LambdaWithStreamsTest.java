package no.bekk.java.excercises;

import junit.framework.TestCase;
import no.bekk.java.model.Data;
import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

public class LambdaWithStreamsTest extends TestCase {

	static final List<League> leagues = Data.getAllLeagues();

	@Test
	public void testTeamNames() {
		List<Team> teams = asList(
				new Team("Manchester United", 2_810_000_000.0, new ArrayList<>()),
				new Team("Liverpool", 691_000_000.0, new ArrayList<>()),
				new Team("Arsenal", 1_330_000_000.0, new ArrayList<>()));

		List<String> teamNames = LambdaWithStreams.teamNames(teams);

		assertThat(teamNames, hasItems("Manchester United", "Liverpool", "Arsenal"));
	}

	@Test
	public void testAgeOfOldestPlayer() {
		List<Player> players = asList(
				new Player("Wayne Rooney", LocalDate.of(1985, 10, 24)),
				new Player("Juan Matta", LocalDate.of(1988, 4, 28)),
				new Player("Mesut Özil", LocalDate.of(1988, 10, 15)),
				new Player("Olivier Giroud", LocalDate.of(1986, 9, 30)));

		Integer ageOfOldestPlayer = LambdaWithStreams.ageOfOldestPlayer(players);

		assertThat(ageOfOldestPlayer, is(28));
	}

	@Test
	public void testNameOfPlayerClosestToAverage() {
		List<Player> players = asList(
				new Player("Wayne Rooney", LocalDate.of(1985, 10, 24)),
				new Player("Juan Matta", LocalDate.of(1988, 4, 28)),
				new Player("Olivier Giroud", LocalDate.of(1986, 9, 30)),
				new Player("David Villa", LocalDate.of(1981, 12, 3)));

		String nameOfPlayerClosestToAverage = LambdaWithStreams.nameOfPlayerClosestToAverage(players);

		assertThat(nameOfPlayerClosestToAverage, is("Wayne Rooney"));
	}

	@Test
	public void testPlayersWithNamesStartingWith() {
		Player kevin = new Player("Kevin-Prince Boateng", LocalDate.of(1987, 3, 6));
		Player mats = new Player("Mats Hummels", LocalDate.of(1988, 12, 16));
		Player robert = new Player("Robert Lewandowski", LocalDate.of(1988, 8, 21));
		Player marco = new Player("Marco Reus", LocalDate.of(1989, 5, 31));
		List<Player> players = asList(kevin, mats, robert, marco);

		List<Player> playersWithNameStartingWithM = LambdaWithStreams.playersWithNamesStartingWith("M", players);

		assertThat(playersWithNameStartingWithM, hasItems(mats, marco));
	}

	@Test
	public void testYoungestPlayer() {
		Player franck = new Player("Franck Ribéry", LocalDate.of(1983, 4, 7));
		Player arjen = new Player("Arjen Robben", LocalDate.of(1984, 1, 23));
		Player philipp = new Player("Philipp Lahm", LocalDate.of(1983, 11, 11));
		List<Player> players = asList(franck, arjen, philipp);

		Optional<Player> player = LambdaWithStreams.youngestPlayer(players);

		assertThat(player.get(), is(arjen));
	}

	@Test
	public void testGroupPlayersByBirthYear() {
		List<Player> players = asList(
				new Player("Wayne Rooney", LocalDate.of(1985, 10, 24)),
				new Player("Juan Matta", LocalDate.of(1988, 4, 28)),
				new Player("Mesut Özil", LocalDate.of(1988, 10, 15)),
				new Player("Olivier Giroud", LocalDate.of(1986, 9, 30)));

		Map<Integer, List<Player>> result = LambdaWithStreams.groupPlayersByBirthYear(players);

		assertTrue("should contain player", containsPlayer(result.get(1988), "Mesut Özil"));
		assertTrue("should contain player", containsPlayer(result.get(1988), "Juan Matta"));
		assertTrue("should contain player", containsPlayer(result.get(1985), "Wayne Rooney"));
		assertTrue("should contain player", containsPlayer(result.get(1986), "Olivier Giroud"));
	}

	@Test
	public void testSumValueOfTeams() {
		Double result = LambdaWithStreams.sumValueOfAllTeams(leagues.get(0).teams);

		assertThat(result, is(4_831_000_000.0));
	}



	@Test
	public void testTeamWithHighestValue() {
		Optional<Team> team = LambdaWithStreams.teamWithHighestValue(leagues.get(0).teams);
		assertThat("Team with highestValue", team.get().name, is("Manchester United"));
	}

	@Test
	public void testSumValuesOfTeams() {
		List<Double> values = LambdaWithStreams.sumValuesOfEachTeams(leagues);

		assertThat(4_831_000_000.0, is(values.get(0)));
		assertThat(6_968_000_000.0, is(values.get(1)));
		assertThat(3_030_000_000.0, is(values.get(2)));
	}

	@Test
	public void testPlayersOlderThan() {
		LocalDate minAge = LocalDate.of(1983, 5, 30);
		List<Player> players = LambdaWithStreams.playersOlderThan(minAge, leagues);
		assertTrue("should contain player", containsPlayer(players, "Steven Gerrard"));
		assertTrue("should contain player", containsPlayer(players, "Daniel Alves"));
		assertTrue("should contain player", containsPlayer(players, "David Villa"));
		assertTrue("should contain player", containsPlayer(players, "Franck Ribéry"));
		assertTrue("should contain player", containsPlayer(players, "Timo Hildebrand"));
	}

	private boolean containsPlayer(List<Player> players, String playerName) {
		return players.stream().anyMatch(player -> player.name.equals(playerName));
	}
}
