package no.bekk.java.exercises;

import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.AbstractMap.SimpleEntry;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class Ex3_LambdaOnStreamsPart2 {

	static Integer ageOfOldestPlayer(List<Player> players) {
		return players.stream().mapToInt(player -> player.getAge()).max().getAsInt();
	}

	static List<Player> playersWithNamesStartingWith(String start, List<Player> players) {
		return players.stream().filter(player -> player.name.startsWith(start)).collect(toList());
	}

	static Double averageAgeOfPlayers(List<Player> players) {
		return players.stream().mapToInt(player -> player.getAge()).average().getAsDouble();
	}

	static Double sumValueOfAllTeams(List<Team> teams) {
		return teams.stream().collect(summingDouble(team -> team.getValue()));
	}

	static Player youngestPlayer(List<Player> players) {
		return players.stream().reduce(Ex1_Lambda.youngestPlayer()).get();
	}

	static Team teamWithHighestValue(final List<Team> teams) {
		return teams.stream().reduce(Ex1_Lambda.highestTeamValue()).get();
	}

	static Map<Integer, List<Player>> groupPlayersByBirthYear(List<Player> players) {
		return players.stream().collect(groupingBy(player -> player.getBirthDate().getYear()));
	}

	static List<Double> sumValuesOfEachLeague(final List<League> leagues) {
		return leagues.stream()
				.map(league -> league.getTeams().stream()
						.collect(summingDouble(team -> team.getValue())))
				.collect(toList());
	}

	static List<Player> playersBornBefore(final LocalDate minAge, final List<League> leagues) {
		return leagues.stream()
				.flatMap(league -> league.getTeams().stream())
				.flatMap(team -> team.getPlayers().stream())
				.filter(player -> player.birthDate.isBefore(minAge))
				.collect(toList());
	}

	static List<Player> sortByAgeAndThenName(final List<Player> players) {
		return players.stream().sorted(
				comparing((Player player) -> player.getBirthDate())
						.reversed()
						.thenComparing(player -> player.getName())).collect(toList());
	}

	static String nameOfPlayerClosestToAverageAge(List<Player> players) {
		Double average = averageAgeOfPlayers(players);
		return players.stream().min(comparing(player -> Math.abs(player.getAge() - average))).get().getName();
	}

	static Map<String, Player> youngestPlayerOnEachTeamMappedByTeamName(final List<Team> teams) {
		return teams.stream()
				.map(team -> new SimpleEntry<>(team.getName(), getYoungestPlayer(team)))
				.collect(toMap());
	}

	private static Player getYoungestPlayer(Team team) {
		return team.getPlayers().stream().reduce(Ex1_Lambda.youngestPlayer()).get();
	}

	private static <K, V> Collector<Map.Entry<K, V>, ?, Map<K, V>> toMap() {
		return Collectors.toMap(x -> x.getKey(), x -> x.getValue());
	}

}
