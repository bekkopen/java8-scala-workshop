package no.bekk.java.excercises;

import junit.framework.TestCase;
import no.bekk.java.model.Data;
import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LambdaTest extends TestCase {

	final List<League> leagues = Data.getAllLeagues();

	@Test
	public void testSumValueOfTeams() {
		Double result = Lambda.sumValueOfTeams(leagues.get(0).teams);

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
		List<Double> values = Lambda.sumValuesOfTeams(leagues);

		assertThat(4_831_000_000.0, is(values.get(0)));
		assertThat(6_968_000_000.0, is(values.get(1)));
		assertThat(3_030_000_000.0, is(values.get(2)));
	}

	@Test
	public void testPlayersOlderThan() {
		LocalDate minAge = LocalDate.of(1983, 5, 30);
		List<Player> players = Lambda.playersOlderThan(minAge, leagues);
		assert (containsOldPlayer(players, "Steven Gerrard"));
		assert (containsOldPlayer(players, "Daniel Alves"));
		assert (containsOldPlayer(players, "David Villa"));
		assert (containsOldPlayer(players, "Franck Ribéry"));
		assert (containsOldPlayer(players, "Timo Hildebrand"));
	}

	private boolean containsOldPlayer(List<Player> players, String playerName) {
		return players.stream().anyMatch(player -> player.name.equals(playerName));
	}

	private BigDecimal round(Double d) {
		return new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}
