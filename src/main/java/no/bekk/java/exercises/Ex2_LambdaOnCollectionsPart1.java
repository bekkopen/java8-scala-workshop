package no.bekk.java.exercises;

import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.*;
import static no.bekk.java.util.Utils.implementThis;

public class Ex2_LambdaOnCollectionsPart1 {

	static List<String> teamNames(List<Team> teams) {
		return implementThis();
	}

	static List<Player> removeOldPlayers(LocalDate maxAge, List<Player> players) {
		return implementThis();
	}

	static List<Team> addValueToEachTeam(Double percent, List<Team> teams) {
		return implementThis();
	}

	static List<Team> removeTeamsWithLowValue(List<Team> teams, Double minValue) {
		return implementThis();
	}

	static List<League> setLeagueNamesToUpperCase(List<League> leagues) {
		return implementThis();
	}
}
