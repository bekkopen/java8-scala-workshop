package no.bekk.java.excercises;

import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;

import java.time.LocalDate;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class Lambda {


	/**
	 * Lambda
	 */

	static BinaryOperator<Player> youngestPlayerLambda = (x, y) -> {
		if (x.birthday.isAfter(y.birthday)) return x;
		else return y;
	};

	static BinaryOperator<Team> highestTeamValueLambda = (x, y) -> {
		if (x.value > y.value) return x;
		else return y;
	};

	/**
	 * Lambda on collections
	 */

	static List<Team> addValueToEachTeam(Double percent, List<Team> teams) {
		List<Team> result = new ArrayList<>(teams.size());
		teams.forEach(team -> {
			result.add(new Team(team.name, team.value * (percent + 1), team.players));
		});
		return result;
	}

	static void sortByAgeAndThenName(final List<Player> players) {
		players.sort(comparing(Player::getBirthday).reversed().thenComparing(Player::getName));
	}

	/**
	 * Lambda using stream
	 */

	static List<String> teamNames(List<Team> teams) {
		return teams.stream().map(Team::getName).collect(toList());
	}

	static Integer ageOfOldestPlayer(List<Player> players) {
		return players.stream().mapToInt(Player::getAge).max().getAsInt();
	}

	static Double averageAgeOfPlayers(List<Player> players) {
		return players.stream().mapToInt(Player::getAge).average().getAsDouble();
	}

	static String nameOfPlayerClosestToAverage(List<Player> players) {
		Double average = averageAgeOfPlayers(players);
		return players.stream().min(comparing(player -> Math.abs(player.getAge() - average))).get().getName();
	}


	static List<Player> playersWithNamesStartingWith(String start, List<Player> players) {
		return players.stream().filter(player -> player.name.startsWith(start)).collect(toList());
	}



	static Double sumValueOfAllTeams(List<Team> teams) {
		return teams.stream().collect(summingDouble(Team::getValue));
	}

	static Optional<Player> youngestPlayer(List<Player> players) {
		return players.stream().reduce(youngestPlayerLambda);
	}

	static Map<Integer, List<Player>> groupPlayersByBirthYear(List<Player> players) {
		return players.stream().collect(groupingBy(player -> player.getBirthday().getYear(), mapping(p -> p, toList())));
	}

	static Optional<Team> teamWithHighestValue(final List<Team> teams) {
		return teams.stream().reduce(highestTeamValueLambda);
	}


	static List<Double> sumValuesOfEachTeams(final List<League> leagues) {
		return leagues.stream().map(league -> league.getTeams())
				.map(teams -> teams.stream()
						.map(Team::getValue)
						.reduce(0.0, (x, y) -> x + y))
				.collect(toList());
	}

	static List<Player> playersOlderThan(final LocalDate minAge, final List<League> leagues) {
		return leagues.stream()
				.map(League::getTeams)
				.reduce(new ArrayList<>(), Lambda::combine).stream()
				.map(Team::getPlayers)
				.reduce(new ArrayList<>(), Lambda::combine).stream()
				.filter(player -> player.birthday.isBefore(minAge))
				.collect(toList());
	}

	/**
	 *
	 * Lambda using parallellStream
	 *
	 */

	static List<Team> teamsWithValueHigherThan(Double value, List<Team> teams) {
		return teams.parallelStream().filter(slowPredicate(team -> team.value > value)).collect(toList());
	}

	/**
	 *
	 * Helper methods
	 */

	private static <T> List<T> combine(final List<T> a, final List<T> b) {
		List<T> result = a;
		result.addAll(b);
		return result;
	}

	private static <T> Predicate<T> slowPredicate(Predicate<T> pred) {
		return x -> {
			try{
			Thread.sleep(100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			return pred.test(x);
		};
	}
}
