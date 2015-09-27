package no.bekk.java.exercises;

import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static no.bekk.java.model.Data.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Ex1_LambdaTest {

	@Test
	public void testPlayerName() {
		List<String> expected = asList(wayneRooney.getName(), juanMatta.getName(), robinVanPersie.getName());
		List<String> names = asList(Ex1_Lambda.playerName().apply(wayneRooney),
				Ex1_Lambda.playerName().apply(juanMatta),
				Ex1_Lambda.playerName().apply(robinVanPersie));
		assertThat(names, is(expected));
	}

	@Test
	public void testPlayerAge() {
		List<Integer> expected = asList(franckRibery.getAge(), arjenRobben.getAge(), philippLahm.getAge());
		List<Integer> ages = asList(Ex1_Lambda.playerAge().apply(franckRibery),
				Ex1_Lambda.playerAge().apply(arjenRobben),
				Ex1_Lambda.playerAge().apply(philippLahm));
		assertThat(ages, is(expected));
	}

	@Test
	public void testIsOlderThan() {
		final int AGE_LIMIT = luisSuarez.getAge();
		assertThat(Ex1_Lambda.isOlderThan(AGE_LIMIT).test(stevenGerrard), is(true));
		assertThat(Ex1_Lambda.isOlderThan(AGE_LIMIT).test(luisSuarez), is(false));
		assertThat(Ex1_Lambda.isOlderThan(AGE_LIMIT).test(danielSturridge), is(false));
	}

	@Test
	public void testYoungestPlayer() {
		Player youngestPlayer = Ex1_Lambda.youngestPlayer().apply(franckRibery, arjenRobben);

		assertThat(youngestPlayer, is(arjenRobben));
	}

	@Test
	public void testHighestTeamValue() {
		Team teamWithHighestValue = Ex1_Lambda.highestTeamValue().apply(manchesterUnited, liverpool);

		assertThat(teamWithHighestValue, is(manchesterUnited));
	}

	@Test
	public void testLongestLeagueName() {
		League leagueWithLongestName = Ex1_Lambda.longestLeagueName().apply(laLiga, premierLeague);

		assertThat(leagueWithLongestName, is(premierLeague));
	}
}
