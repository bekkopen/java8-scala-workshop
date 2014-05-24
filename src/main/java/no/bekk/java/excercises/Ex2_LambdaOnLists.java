package no.bekk.java.excercises;

import no.bekk.java.model.Player;
import no.bekk.java.model.Team;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class Ex2_LambdaOnLists {

	static void removeCheapTeams(List<Team> teams, Double minValue) {
		teams.removeIf(team -> team.value < minValue);
	}

	static void sortByAgeAndThenName(final List<Player> players) {
		players.sort(comparing(Player::getBirthDate).reversed().thenComparing(Player::getName));
	}

	static List<Team> addValueToEachTeam(Double percent, List<Team> teams) {
		List<Team> result = new ArrayList<>(teams.size());
		teams.forEach(team -> result.add(new Team(team.name, team.value * (percent + 1), team.players)));
		return result;
	}
}
