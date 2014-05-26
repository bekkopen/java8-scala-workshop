package no.bekk.java.exercises;

import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;

import java.time.LocalDate;
import java.util.*;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toList;
import static no.bekk.java.util.Utils.*;

public class Ex3_LambdaWithStreams {

	static List<String> teamNames(List<Team> teams) {
		return implementThis();
	}

	static Integer ageOfOldestPlayer(List<Player> players) {
		return implementThis();
	}

	static Double averageAgeOfPlayers(List<Player> players) {
		return implementThis();
	}

	static String nameOfPlayerClosestToAverage(List<Player> players) {
		return implementThis();
	}

	static List<Player> playersWithNamesStartingWith(String start, List<Player> players) {
		return implementThis();
	}

	static Double sumValueOfAllTeams(List<Team> teams) {
		return implementThis();
	}

	static Player youngestPlayer(List<Player> players) {
		return implementThis();
	}

	static Map<Integer, List<Player>> groupPlayersByBirthYear(List<Player> players) {
		return implementThis();
	}

	static Team teamWithHighestValue(final List<Team> teams) {
		return implementThis();
	}

	static List<Double> sumValuesOfEachLeague(final List<League> leagues) {
		return implementThis();
	}

	static List<Player> playersBornBefore(final LocalDate minAge, final List<League> leagues) {
		return implementThis();
	}

}
