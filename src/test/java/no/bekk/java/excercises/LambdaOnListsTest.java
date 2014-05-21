package no.bekk.java.excercises;

import junit.framework.TestCase;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class LambdaOnListsTest extends TestCase {

	@Test
	public void testRemoveCheapTeams() {
		Team manchesterUnited = new Team("Manchester United", 2_810_000_000.0, new ArrayList<>());
		Team liverpool = new Team("Liverpool", 691_000_000.0, new ArrayList<>());
		Team arsenal = new Team("Arsenal", 1_330_000_000.0, new ArrayList<>());
		Team borussiaDortmund = new Team("Borussia Dortmund", 600_000_000.0, new ArrayList<>());
		Team atleticoMadrid = new Team("Atletico Madrid", 328_000_000.0, new ArrayList<>());
		ArrayList<Team> teams = new ArrayList<>();
		teams.add(manchesterUnited); teams.add(liverpool); teams.add(arsenal); teams.add(borussiaDortmund); teams.add(atleticoMadrid);

		LambdaOnLists.removeCheapTeams(teams, 1_330_000_000.0);

		assertThat(teams, hasItems(manchesterUnited, arsenal));
		assertThat(teams, not(hasItems(liverpool, borussiaDortmund, atleticoMadrid)));
	}

	@Test
	public void testAddValueToEachTeam() {
		List<Team> teams = asList(
				new Team("Manchester United", 2_810_000_000.0, new ArrayList<>()),
				new Team("Liverpool", 691_000_000.0, new ArrayList<>()),
				new Team("Arsenal", 1_330_000_000.0, new ArrayList<>()));

		List<Team> result = LambdaOnLists.addValueToEachTeam(0.05, teams);

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

		LambdaOnLists.sortByAgeAndThenName(players);

		assertThat(players.get(0).name, is("Juan Matta"));
		assertThat(players.get(1).name, is("Wayne Rooney"));
		assertThat(players.get(2).name, is("Wayne Rooneylooney"));
		assertThat(players.get(3).name, is("Robin van Persie"));
	}

	private BigDecimal round(Double d) {
		return new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}
