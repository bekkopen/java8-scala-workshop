package no.bekk.java.excercises;

import no.bekk.java.model.Player;
import no.bekk.java.model.Team;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static no.bekk.java.model.Data.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class LambdaOnListsTest {

	@Test
	public void testRemoveCheapTeams() {
		ArrayList<Team> teams =
				asArrayList(manchesterUnited, liverpool, arsenal, borussiaDortmund, atleticoMadrid);

		LambdaOnLists.removeCheapTeams(teams, 1_330_000_000.0);

		assertThat(teams, hasItems(manchesterUnited, arsenal));
		assertThat(teams, not(hasItems(liverpool, borussiaDortmund, atleticoMadrid)));
	}

	@Test
	public void testAddValueToEachTeam() {
		List<Team> teams = asList(manchesterUnited, liverpool, arsenal);

		List<Team> teamsWithFivePercentValueIncrease = LambdaOnLists.addValueToEachTeam(0.05, teams);

		assertThat(round(teamsWithFivePercentValueIncrease.get(0).value), is(round(2_950_500_000.0)));
		assertThat(round(teamsWithFivePercentValueIncrease.get(1).value), is(round(725_550_000.0)));
		assertThat(round(teamsWithFivePercentValueIncrease.get(2).value), is(round(1_396_500_000.0)));
	}

	@Test
	public void testSortByAgeAndThenName() {
		Player juanMattaClone = new Player(juanMatta.name+"clone", juanMatta.birthday);
		List<Player> players = asList(wayneRooney, juanMattaClone, danielAlves, juanMatta, diegoCosta);

		LambdaOnLists.sortByAgeAndThenName(players);

		assertThat(players.get(0), is(diegoCosta));
		assertThat(players.get(1), is(juanMatta));
		assertThat(players.get(2), is(juanMattaClone));
		assertThat(players.get(3), is(wayneRooney));
		assertThat(players.get(4), is(danielAlves));
	}

	private <T> ArrayList<T> asArrayList(T... elements) {
		ArrayList<T> list = new ArrayList<>(elements.length);
		for(T element: elements) {
			list.add(element);
		}
		return list;
	}

	private BigDecimal round(Double d) {
		return new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}
