package no.bekk.java.excercises;

import junit.framework.TestCase;
import no.bekk.java.model.Data;
import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.*;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LambdaTest extends TestCase {

	final List<League> leagues = Data.getAllLeagues();

	@Test
	public void testYoungestPlayerLambda() {
		Player franck = new Player("Franck Ribéry", LocalDate.of(1983, 4, 7));
		Player arjen = new Player("Arjen Robben", LocalDate.of(1984, 1, 23));

		Player youngestPlayer = Lambda.youngestPlayerLambda.apply(franck, arjen);

		assertThat(youngestPlayer, is(arjen));
	}

	@Test
	public void testHighestTeamValueLambda() {
		Team manchesterUnited = new Team("Manchester United", 2_810_000_000.0, new ArrayList<>());
		Team liverpool = new Team("Liverpool", 691_000_000.0, new ArrayList<>());

		Team teamWithHighestValue = Lambda.highestTeamValueLambda.apply(manchesterUnited, liverpool);

		assertThat(teamWithHighestValue, is(manchesterUnited));
	}

	@Test
	public void testTeamNames() {
		List<Team> teams = asList(
				new Team("Manchester United", 2_810_000_000.0, new ArrayList<>()),
				new Team("Liverpool", 691_000_000.0, new ArrayList<>()),
				new Team("Arsenal", 1_330_000_000.0, new ArrayList<>()));

		List<String> teamNames = Lambda.teamNames(teams);

		assertThat(teamNames, hasItems("Manchester United", "Liverpool", "Arsenal"));
	}

	@Test
	public void testAgeOfOldestPlayer() {
		List<Player> players = asList(
				new Player("Wayne Rooney", LocalDate.of(1985, 10, 24)),
				new Player("Juan Matta", LocalDate.of(1988, 4, 28)),
				new Player("Mesut Özil", LocalDate.of(1988, 10, 15)),
				new Player("Olivier Giroud", LocalDate.of(1986, 9, 30)));

		Integer ageOfOldestPlayer = Lambda.ageOfOldestPlayer(players);

		assertThat(ageOfOldestPlayer, is(28));
	}

	@Test
	public void testNameOfPlayerClosestToAverage() {
		List<Player> players = asList(
				new Player("Wayne Rooney", LocalDate.of(1985, 10, 24)),
				new Player("Juan Matta", LocalDate.of(1988, 4, 28)),
				new Player("Olivier Giroud", LocalDate.of(1986, 9, 30)),
				new Player("David Villa", LocalDate.of(1981, 12, 3)));

		String nameOfPlayerClosestToAverage = Lambda.nameOfPlayerClosestToAverage(players);

		assertThat(nameOfPlayerClosestToAverage, is("Wayne Rooney"));
	}

	@Test
	public void testPlayersWithNamesStartingWith() {
		Player kevin = new Player("Kevin-Prince Boateng", LocalDate.of(1987, 3, 6));
		Player mats = new Player("Mats Hummels", LocalDate.of(1988, 12, 16));
		Player robert = new Player("Robert Lewandowski", LocalDate.of(1988, 8, 21));
		Player marco = new Player("Marco Reus", LocalDate.of(1989, 5, 31));
		List<Player> players = asList(kevin, mats, robert, marco);

		List<Player> playersWithNameStartingWithM = Lambda.playersWithNamesStartingWith("M", players);

		assertThat(playersWithNameStartingWithM, hasItems(mats, marco));
	}

	@Test
	public void testYoungestPlayer() {
		Player franck = new Player("Franck Ribéry", LocalDate.of(1983, 4, 7));
		Player arjen = new Player("Arjen Robben", LocalDate.of(1984, 1, 23));
		Player philipp = new Player("Philipp Lahm", LocalDate.of(1983, 11, 11));
		List<Player> players = asList(franck, arjen, philipp);

		Optional<Player> player = Lambda.youngestPlayer(players);

		assertThat(player.get(), is(arjen));
	}

	@Test
	public void testGroupPlayersByBirthYear() {
		List<Player> players = asList(
				new Player("Wayne Rooney", LocalDate.of(1985, 10, 24)),
				new Player("Juan Matta", LocalDate.of(1988, 4, 28)),
				new Player("Mesut Özil", LocalDate.of(1988, 10, 15)),
				new Player("Olivier Giroud", LocalDate.of(1986, 9, 30)));

		Map<Integer, List<Player>> result = Lambda.groupPlayersByBirthYear(players);

		assertTrue("should contain player", containsPlayer(result.get(1988), "Mesut Özil"));
		assertTrue("should contain player", containsPlayer(result.get(1988), "Juan Matta"));
		assertTrue("should contain player", containsPlayer(result.get(1985), "Wayne Rooney"));
		assertTrue("should contain player", containsPlayer(result.get(1986), "Olivier Giroud"));
	}

	@Test
	public void testSumValueOfTeams() {
		Double result = Lambda.sumValueOfAllTeams(leagues.get(0).teams);

		assertThat(result, is(4_831_000_000.0));
	}

	@Test
	public void testAddValueToEachTeam() {
		List<Team> teams = asList(
				new Team("Manchester United", 2_810_000_000.0, new ArrayList<>()),
				new Team("Liverpool", 691_000_000.0, new ArrayList<>()),
				new Team("Arsenal", 1_330_000_000.0, new ArrayList<>()));

		List<Team> result = Lambda.addValueToEachTeam(0.05, teams);

		assertThat(round(result.get(0).value), is(round(2_950_500_000.0)));
		assertThat(round(result.get(1).value), is(round(725_550_000.0)));
		assertThat(round(result.get(2).value), is(round(1_396_500_000.0)));
	}

	@Test
	public void testSortByAgeAndThenName() {
		List<Player> players = asList(
				new Player("Wayne Rooney", LocalDate.of(1985, 10, 24)),
				new Player("Wayne Rooneylooney", LocalDate.of(1985, 10, 24)),
				new Player("Juan Matta", LocalDate.of(1988, 4, 28)),
				new Player("Robin van Persie", LocalDate.of(1983, 8, 6)));

		Lambda.sortByAgeAndThenName(players);

		assertThat(players.get(0).name, is("Juan Matta"));
		assertThat(players.get(1).name, is("Wayne Rooney"));
		assertThat(players.get(2).name, is("Wayne Rooneylooney"));
		assertThat(players.get(3).name, is("Robin van Persie"));
	}

	@Test
	public void testTeamWithHighestValue() {
		Optional<Team> team = Lambda.teamWithHighestValue(leagues.get(0).teams);
		assertThat("Team with highestValue", team.get().name, is("Manchester United"));
	}

	@Test
	public void testSumValuesOfTeams() {
		List<Double> values = Lambda.sumValuesOfEachTeams(leagues);

		assertThat(4_831_000_000.0, is(values.get(0)));
		assertThat(6_968_000_000.0, is(values.get(1)));
		assertThat(3_030_000_000.0, is(values.get(2)));
	}

	@Test
	public void testPlayersOlderThan() {
		LocalDate minAge = LocalDate.of(1983, 5, 30);
		List<Player> players = Lambda.playersOlderThan(minAge, leagues);
		assertTrue("should contain player", containsPlayer(players, "Steven Gerrard"));
		assertTrue("should contain player", containsPlayer(players, "Daniel Alves"));
		assertTrue("should contain player", containsPlayer(players, "David Villa"));
		assertTrue("should contain player", containsPlayer(players, "Franck Ribéry"));
		assertTrue("should contain player", containsPlayer(players, "Timo Hildebrand"));
	}

	@Test
	public void testTeamsWithValueHigherThan() {
		Team manchesterUnited = new Team("Manchester United", 2_810_000_000.0, new ArrayList<>());
		Team liverpool = new Team("Liverpool", 691_000_000.0, new ArrayList<>());
		Team arsenal = new Team("Arsenal", 1_330_000_000.0, new ArrayList<>());
		Team borussiaDortmund = new Team("Borussia Dortmund", 600_000_000.0, new ArrayList<>());
		Team atleticoMadrid = new Team("Atletico Madrid", 328_000_000.0, new ArrayList<>());
		List<Team> teams = asList(manchesterUnited, liverpool, arsenal, borussiaDortmund, atleticoMadrid);

		long before = System.currentTimeMillis();
		List<Team> teamsWithHigherValueThan1B = Lambda.teamsWithValueHigherThan(1_000_000_000.0, teams);
		long after = System.currentTimeMillis();
		long totalTime = after - before;
		System.out.println(totalTime);

		assertThat(totalTime, is(greaterThan(100L)));
		assertThat(totalTime, is(lessThan(450L)));
		assertThat(teamsWithHigherValueThan1B, hasItems(manchesterUnited, arsenal));
		assertThat(teamsWithHigherValueThan1B, not(hasItems(liverpool, borussiaDortmund, atleticoMadrid)));
	}

	private boolean containsPlayer(List<Player> players, String playerName) {
		return players.stream().anyMatch(player -> player.name.equals(playerName));
	}

	private BigDecimal round(Double d) {
		return new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}
