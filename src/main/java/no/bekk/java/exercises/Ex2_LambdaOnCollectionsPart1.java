package no.bekk.java.exercises;

import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.*;

public class Ex2_LambdaOnCollectionsPart1 {

	static List<String> teamNames(List<Team> teams) {
		return teams.stream().map(Team::getName).collect(toList());
	}

	static List<Player> removeOldPlayers(LocalDate maxAge, List<Player> players) {
		return players.stream().filter(player -> player.birthDate.isAfter(maxAge)).collect(toList());
	}

	static List<Team> addValueToEachTeam(Double percent, List<Team> teams) {
		return teams.stream().map(team -> new Team(team.name, team.value * (percent + 1), team.players)).collect(toList());
	}

	static List<Team> removeTeamsWithLowValue(List<Team> teams, Double minValue) {
		return teams.stream().filter(team -> team.value >= minValue).collect(toList());
	}

	static List<League> setLeagueNamesToUpperCase(List<League> leagues) {
		return leagues.stream().map(league -> new League(league.name.toUpperCase(), league.teams)).collect(toList());
	}
}
