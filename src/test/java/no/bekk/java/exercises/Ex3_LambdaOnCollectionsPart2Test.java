package no.bekk.java.exercises;

import no.bekk.java.model.Player;
import no.bekk.java.model.Team;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static no.bekk.java.model.Data.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

public class Ex3_LambdaOnCollectionsPart2Test {

	@Test
	public void testAgeOfOldestPlayer() {
		List<Player> players = asList(wayneRooney, juanMatta, mesutOzil, olivierGiroud);

		Integer expected = Period.between(LocalDate.of(1985, 10, 24), LocalDate.now()).getYears();
		Integer ageOfOldestPlayer = Ex3_LambdaOnCollectionsPart2.ageOfOldestPlayer(players);

		assertThat(ageOfOldestPlayer, is(expected));
	}

	@Test
	public void testPlayersWithNamesStartingWith() {
		List<Player> players = asList(kevinPrinceBoateng, matsHummels, robertLewandowski, marcoReus);

		List<Player> playersWithNameStartingWithM = Ex3_LambdaOnCollectionsPart2.playersWithNamesStartingWith("M", players);

		assertThat(playersWithNameStartingWithM, hasItems(matsHummels, marcoReus));
		assertThat(playersWithNameStartingWithM.size(), is(2));
	}

	@Test
	public void testAverageAgeOfPlayers() {
		List<Player> players = asList(wayneRooney, juanMatta, mesutOzil, olivierGiroud);

		Double expected = (wayneRooney.getAge() + juanMatta.getAge() + mesutOzil.getAge() + olivierGiroud.getAge()) / 4.0;
		Double averageAge = Ex3_LambdaOnCollectionsPart2.averageAgeOfPlayers(players);

		assertThat(averageAge, is(expected));
	}


	@Test
	public void testSumValueOfTeams() {
		Double premierLeagueTeamsValue = Ex3_LambdaOnCollectionsPart2.sumValueOfAllTeams(premierLeague.teams);

		assertThat(premierLeagueTeamsValue, is(4_831_000_000.0));
	}

	@Test
	public void testYoungestPlayer() {
		List<Player> players = asList(franckRibery, arjenRobben, philippLahm);

		Player youngestPlayer = Ex3_LambdaOnCollectionsPart2.youngestPlayer(players);

		assertThat(youngestPlayer, is(arjenRobben));
	}

	@Test
	public void testTeamWithHighestValue() {
		Team teamWithHighersValueInPremierLeague = Ex3_LambdaOnCollectionsPart2.teamWithHighestValue(premierLeague.teams);

		assertThat(teamWithHighersValueInPremierLeague, is(manchesterUnited));
	}

	@Test
	public void testGroupPlayersByBirthYear() {
		List<Player> players = asList(wayneRooney, juanMatta, mesutOzil, olivierGiroud);

		Map<Integer, List<Player>> groupedPlayers = Ex3_LambdaOnCollectionsPart2.groupPlayersByBirthYear(players);

		assertThat(groupedPlayers.get(1988), hasItems(mesutOzil, juanMatta));
		assertThat(groupedPlayers.get(1988).size(), is(2));
		assertThat(groupedPlayers.get(1985), hasItems(wayneRooney));
		assertThat(groupedPlayers.get(1985).size(), is(1));
		assertThat(groupedPlayers.get(1986), hasItems(olivierGiroud));
		assertThat(groupedPlayers.get(1986).size(), is(1));
	}

	@Test
	public void testSumValuesOfEachLeague() {
		List<Double> values = Ex3_LambdaOnCollectionsPart2.sumValuesOfEachLeague(leagues);

		assertThat(4_831_000_000.0, is(values.get(0)));
		assertThat(6_968_000_000.0, is(values.get(1)));
		assertThat(3_030_000_000.0, is(values.get(2)));
	}

	@Test
	public void testPlayersBornBefore() {
		LocalDate minAge = LocalDate.of(1983, 5, 30);
		List<Player> playersOlderThanMinAge = Ex3_LambdaOnCollectionsPart2.playersBornBefore(minAge, leagues);

		assertThat(playersOlderThanMinAge, hasItems(stevenGerrard, danielAlves, davidVilla, franckRibery, timoHildebrand));
		assertThat(playersOlderThanMinAge.size(), is(5));
	}

	@Test
	public void testSortByAgeAndThenName() {
		Player juanMattaClone = new Player(juanMatta.name+"clone", juanMatta.birthDate);
		List<Player> players = asList(wayneRooney, juanMattaClone, danielAlves, juanMatta, diegoCosta);

		List<Player> result = Ex3_LambdaOnCollectionsPart2.sortByAgeAndThenName(players);

		assertThat(result.get(0), is(diegoCosta));
		assertThat(result.get(1), is(juanMatta));
		assertThat(result.get(2), is(juanMattaClone));
		assertThat(result.get(3), is(wayneRooney));
		assertThat(result.get(4), is(danielAlves));
	}

	@Test
	public void testNameOfPlayerClosestToAverageAge() {
		List<Player> players = asList(wayneRooney, juanMatta, olivierGiroud, davidVilla);

		String nameOfPlayerClosestToAverage = Ex3_LambdaOnCollectionsPart2.nameOfPlayerClosestToAverageAge(players);

		assertThat(nameOfPlayerClosestToAverage, is("Wayne Rooney"));
	}

	@Test
	public void testYoungestPlayerOnEachTeamMappedByTeamName() {

		Map<String, Player> result = Ex3_LambdaOnCollectionsPart2.youngestPlayerOnEachTeamMappedByTeamName(asList(manchesterUnited, liverpool, arsenal));

		assertThat(result.get(manchesterUnited.name), is(juanMatta));
		assertThat(result.get(liverpool.name), is(danielSturridge));
		assertThat(result.get(arsenal.name), is(jackWilshere));
	}
}
