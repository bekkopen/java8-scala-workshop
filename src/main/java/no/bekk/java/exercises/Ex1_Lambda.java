package no.bekk.java.exercises;

import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;

import static no.bekk.java.util.Utils.*;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Ex1_Lambda {

	public static Function<Player, String> playerName() {
		return implementThis();
	}

	public static Function<Player, Integer> playerAge() {
		return implementThis();
	}

	public static Predicate<Player> isOlderThan(Integer age) {
		return implementThis();
	}

	static BinaryOperator<Player> youngestPlayer() {
		return implementThis();
	}

	static BinaryOperator<Team> highestTeamValue() {
		return implementThis();
	}

	static BinaryOperator<League> longestLeagueName() {
		return implementThis();
	}
}
