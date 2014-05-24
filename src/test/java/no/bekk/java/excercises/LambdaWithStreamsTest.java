package no.bekk.java.excercises;

import no.bekk.java.model.Player;
import no.bekk.java.model.Team;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Arrays.asList;
import static no.bekk.java.model.Data.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

public class LambdaWithStreamsTest {

	@Test
	public void testTeamNames() {
		List<Team> teams = asList(manchesterUnited, liverpool, arsenal);

		List<String> teamNames = LambdaWithStreams.teamNames(teams);

		assertThat(teamNames, hasItems("Manchester United", "Liverpool", "Arsenal"));
	}

	@Test
	public void testAgeOfOldestPlayer() {
		List<Player> players = asList( wayneRooney, juanMatta, mesutOzil, olivierGiroud);

		Integer ageOfOldestPlayer = LambdaWithStreams.ageOfOldestPlayer(players);

		assertThat(ageOfOldestPlayer, is(28));
	}

	@Test
	public void testNameOfPlayerClosestToAverage() {
		List<Player> players = asList( wayneRooney, juanMatta, olivierGiroud, davidVilla);

		String nameOfPlayerClosestToAverage = LambdaWithStreams.nameOfPlayerClosestToAverage(players);

		assertThat(nameOfPlayerClosestToAverage, is("Wayne Rooney"));
	}

	@Test
	public void testPlayersWithNamesStartingWith() {
		List<Player> players = asList(kevinPrinceBoateng, matsHummels, robertLewandowski, marcoReus);

		List<Player> playersWithNameStartingWithM = LambdaWithStreams.playersWithNamesStartingWith("M", players);

		assertThat(playersWithNameStartingWithM, hasItems(matsHummels, marcoReus));
	}

	@Test
	public void testYoungestPlayer() {
		List<Player> players = asList(franckRibery, arjenRobben, philippLahm);

		Optional<Player> youngestPlayer = LambdaWithStreams.youngestPlayer(players);

		assertThat(youngestPlayer.get(), is(arjenRobben));
	}

	@Test
	public void testGroupPlayersByBirthYear() {
		List<Player> players = asList( wayneRooney, juanMatta, mesutOzil, olivierGiroud);

		Map<Integer, List<Player>> groupedPlayers = LambdaWithStreams.groupPlayersByBirthYear(players);

		assertThat(groupedPlayers.get(1988), hasItems(mesutOzil, juanMatta));
		assertThat(groupedPlayers.get(1985), hasItems(wayneRooney));
		assertThat(groupedPlayers.get(1986), hasItems(olivierGiroud));
	}

	@Test
	public void testSumValueOfTeams() {
		Double premierLeagueTeamsValue = LambdaWithStreams.sumValueOfAllTeams(premierLeague.teams);

		assertThat(premierLeagueTeamsValue, is(4_831_000_000.0));
	}



	@Test
	public void testTeamWithHighestValue() {
		Optional<Team> teamWithHighersValueInPremierLeague = LambdaWithStreams.teamWithHighestValue(premierLeague.teams);

		assertThat(teamWithHighersValueInPremierLeague.get(), is(manchesterUnited));
	}

	@Test
	public void testSumValuesOfEachLeague() {
		List<Double> values = LambdaWithStreams.sumValuesOfEachLeague(leagues);

		assertThat(4_831_000_000.0, is(values.get(0)));
		assertThat(6_968_000_000.0, is(values.get(1)));
		assertThat(3_030_000_000.0, is(values.get(2)));
	}

	@Test
	public void testPlayersOlderThan() {
		LocalDate minAge = LocalDate.of(1983, 5, 30);
		List<Player> playersOlderThanMinAge = LambdaWithStreams.playersOlderThan(minAge, leagues);

		assertThat(playersOlderThanMinAge, hasItems(stevenGerrard, danielAlves, davidVilla, franckRibery, timoHildebrand));
		assertThat(playersOlderThanMinAge.size(), is(5));
	}
}
