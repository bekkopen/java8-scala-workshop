package no.bekk.java.exercises;

import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static no.bekk.java.model.Data.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class Ex2_LambdaOnStreamsPart1Test {

	@Test
	public void testTeamNames() {
		List<Team> teams = asList(manchesterUnited, liverpool, arsenal);

		List<String> teamNames = Ex2_LambdaOnStreamsPart1.teamNames(teams);

		assertThat(teamNames, hasItems("Manchester United", "Liverpool", "Arsenal"));
	}

	@Test
	public void testRemoveOldPlayers() {
		List<Player> result = Ex2_LambdaOnStreamsPart1.removeOldPlayers(LocalDate.of(1984, 1, 1), bayernMunchen.players);
		result.forEach(System.out::println);
		assertThat(result, hasItems(arjenRobben));
		assertThat(result, not(hasItems(philippLahm, franckRibery)));
	}

	@Test
	public void testAddValueToEachTeam() {
		List<Team> teams = asList(manchesterUnited, liverpool, arsenal);

		List<Team> teamsWithFivePercentValueIncrease = Ex2_LambdaOnStreamsPart1.addValueToEachTeam(0.05, teams);

		assertThat(round(teamsWithFivePercentValueIncrease.get(0).value), is(round(2_950_500_000.0)));
		assertThat(round(teamsWithFivePercentValueIncrease.get(1).value), is(round(725_550_000.0)));
		assertThat(round(teamsWithFivePercentValueIncrease.get(2).value), is(round(1_396_500_000.0)));
	}

	@Test
	public void testRemoveTeamsWithLowValue() {
		List<Team> teams = new ArrayList<>(asList(manchesterUnited, liverpool, arsenal, borussiaDortmund, atleticoMadrid));

		List<Team> result = Ex2_LambdaOnStreamsPart1.removeTeamsWithLowValue(teams, 1_330_000_000.0);

		assertThat(result, hasItems(manchesterUnited, arsenal));
		assertThat(result, not(hasItems(liverpool, borussiaDortmund, atleticoMadrid)));
	}

	@Test
	public void testSetLeagueNamesToUpperCase() {
		List<League> result = Ex2_LambdaOnStreamsPart1.setLeagueNamesToUpperCase(leagues);

		assertThat(result.get(0).name, is("PREMIER LEAGUE"));
		assertThat(result.get(1).name, is("LA LIGA"));
		assertThat(result.get(2).name, is("BUNDESLIGA"));
	}

	private BigDecimal round(Double d) {
		return new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}
