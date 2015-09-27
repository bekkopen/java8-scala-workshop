package no.bekk.java.exercises;

import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Ex1_Lambda {

	public static Function<Player, String> playerName() {
		return player -> player.getName();
	}

	public static Function<Player, Integer> playerAge() {
		return player -> player.getAge();
	}

	public static Predicate<Player> isOlderThan(Integer age) {
		return p -> p.getAge() > age;
	}

	static BinaryOperator<Player> youngestPlayer() {

		return (x, y) -> {
			if (x.birthDate.isAfter(y.birthDate)) return x;
			else return y;
		};
	}

	static BinaryOperator<Team> highestTeamValue() {
		return (x, y) -> {
			if (x.value > y.value) return x;
			else return y;
		};
	}

	static BinaryOperator<League> longestLeagueName() {
		return (x, y) -> {
			if (x.getName().length() > y.getName().length()) return x;
			else return y;
		};
	}
}
