package no.bekk.java.exercises;

import no.bekk.java.model.Player;
import no.bekk.java.model.Team;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static no.bekk.java.model.Data.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

public class Ex3_LambdaWithStreamsTest {

	@Test
	public void testTeamNames() {
		List<Team> teams = asList(manchesterUnited, liverpool, arsenal);

		List<String> teamNames = Ex3_LambdaWithStreams.teamNames(teams);

		assertThat(teamNames, hasItems("Manchester United", "Liverpool", "Arsenal"));
	}

	@Test
	public void testAgeOfOldestPlayer() {
		List<Player> players = asList(wayneRooney, juanMatta, mesutOzil, olivierGiroud);

		Integer ageOfOldestPlayer = Ex3_LambdaWithStreams.ageOfOldestPlayer(players);

		assertThat(ageOfOldestPlayer, is(28));
	}

	@Test
	public void testAverageAgeOfPlayers() {
		List<Player> players = asList(wayneRooney, juanMatta, mesutOzil, olivierGiroud);

		Double averageAge = Ex3_LambdaWithStreams.averageAgeOfPlayers(players);

		assertThat(averageAge, is(26.5));
	}

	@Test
	public void testNameOfPlayerClosestToAverage() {
		List<Player> players = asList(wayneRooney, juanMatta, olivierGiroud, davidVilla);

		String nameOfPlayerClosestToAverage = Ex3_LambdaWithStreams.nameOfPlayerClosestToAverage(players);

		assertThat(nameOfPlayerClosestToAverage, is("Wayne Rooney"));
	}

	@Test
	public void testPlayersWithNamesStartingWith() {
		List<Player> players = asList(kevinPrinceBoateng, matsHummels, robertLewandowski, marcoReus);

		List<Player> playersWithNameStartingWithM = Ex3_LambdaWithStreams.playersWithNamesStartingWith("M", players);

		assertThat(playersWithNameStartingWithM, hasItems(matsHummels, marcoReus));
		assertThat(playersWithNameStartingWithM.size(), is(2));
	}

	@Test
	public void testSumValueOfTeams() {
		Double premierLeagueTeamsValue = Ex3_LambdaWithStreams.sumValueOfAllTeams(premierLeague.teams);

		assertThat(premierLeagueTeamsValue, is(4_831_000_000.0));
	}

	@Test
	public void testYoungestPlayer() {
		List<Player> players = asList(franckRibery, arjenRobben, philippLahm);

		Player youngestPlayer = Ex3_LambdaWithStreams.youngestPlayer(players);

		assertThat(youngestPlayer, is(arjenRobben));
	}

	@Test
	public void testGroupPlayersByBirthYear() {
		List<Player> players = asList(wayneRooney, juanMatta, mesutOzil, olivierGiroud);

		Map<Integer, List<Player>> groupedPlayers = Ex3_LambdaWithStreams.groupPlayersByBirthYear(players);

		assertThat(groupedPlayers.get(1988), hasItems(mesutOzil, juanMatta));
		assertThat(groupedPlayers.get(1988).size(), is(2));
		assertThat(groupedPlayers.get(1985), hasItems(wayneRooney));
		assertThat(groupedPlayers.get(1985).size(), is(1));
		assertThat(groupedPlayers.get(1986), hasItems(olivierGiroud));
		assertThat(groupedPlayers.get(1986).size(), is(1));
	}

	@Test
	public void testTeamWithHighestValue() {
		Team teamWithHighestValueInPremierLeague = Ex3_LambdaWithStreams.teamWithHighestValue(premierLeague.teams);

		assertThat(teamWithHighestValueInPremierLeague, is(manchesterUnited));
	}

	@Test
	public void testSumValuesOfEachLeague() {
		List<Double> values = Ex3_LambdaWithStreams.sumValuesOfEachLeague(leagues);

		assertThat(4_831_000_000.0, is(values.get(0)));
		assertThat(6_968_000_000.0, is(values.get(1)));
		assertThat(3_030_000_000.0, is(values.get(2)));
	}

	@Test
	public void testPlayersBornBefore() {
		LocalDate minAge = LocalDate.of(1983, 5, 30);
		List<Player> playersOlderThanMinAge = Ex3_LambdaWithStreams.playersBornBefore(minAge, leagues);

		assertThat(playersOlderThanMinAge, hasItems(stevenGerrard, danielAlves, davidVilla, franckRibery, timoHildebrand));
		assertThat(playersOlderThanMinAge.size(), is(5));
	}
}
