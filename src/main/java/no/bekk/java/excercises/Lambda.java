package no.bekk.java.excercises;

import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;

import java.time.LocalDate;
import java.util.*;

import static java.util.stream.Collectors.*;

public class Lambda {

	/**
	 * Lambda on collections
	 */

	static void sortByAgeAndThenName(final List<Player> players) {
		players.sort(Comparator.comparing(Player::getBirthday).reversed().thenComparing(Player::getName));
	}

	static List<Team> addValueToEachTeam(Double percent, List<Team> teams) {
		List<Team> result = new ArrayList<>(teams.size());
		teams.forEach(team -> {
			result.add(new Team(team.name, team.value * (percent + 1), team.players));
		});
		return result;
	}

	/**
	 * Lambda using stream
	 */

	/*
	  * <p>For example, to compute the set of last names of people in each city:
     * <pre>{@code
     *     Map<City, Set<String>> namesByCity
     *         = people.stream().collect(groupingBy(Person::getCity,
     *                                              mapping(Person::getLastName, toSet())));
     * }</pre>
     *
     * * <p>For example, given a stream of {@code Person}, to calculate tallest
     * person in each city:
     * <pre>{@code
     *     Comparator<Person> byHeight = Comparator.comparing(Person::getHeight);
     *     Map<City, Person> tallestByCity
     *         = people.stream().collect(groupingBy(Person::getCity, reducing(BinaryOperator.maxBy(byHeight))));
     * }</pre>
	 */

	static Double sumValueOfTeams(List<Team> teams) {
		return teams.stream().collect(summingDouble(Team::getValue));
	}

	static Optional<Team> teamWithHighestValue(final List<Team> teams) {
		return teams.stream().reduce((x, y) -> {
			if (x.value > y.value) return x;
			else return y;
		});
	}

	static List<Double> sumValuesOfTeams(final List<League> leagues) {
		return leagues.stream().map(league -> league.getTeams())
				.map(teams -> teams.stream()
						.map(Team::getValue)
						.reduce(0.0, (x, y) -> x + y))
				.collect(toList());
	}

	static List<Player> playersOlderThan(final LocalDate minAge, final List<League> leagues) {
		return leagues.stream()
				.map(League::getTeams)
				.reduce(new ArrayList<>(), (Lambda::combine)).stream()
				.map(Team::getPlayers).reduce(new ArrayList<>(), Lambda::combine).stream()
				.filter(player -> player.birthday.isBefore(minAge))
				.collect(toList());
	}

	private static <T> List<T> combine(final List<T> a, final List<T> b) {
		List<T> result = a;
		result.addAll(b);
		return result;
	}

	/**
	 *
	 * Lambda using parallellStream
	 *
	 */

}
