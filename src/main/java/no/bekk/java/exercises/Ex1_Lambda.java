package no.bekk.java.exercises;

import no.bekk.java.model.Player;
import no.bekk.java.model.Team;

import java.util.function.BinaryOperator;

public class Ex1_Lambda {

	static BinaryOperator<Player> youngestPlayerLambda = (x, y) -> {
		if (x.birthDate.isAfter(y.birthDate)) return x;
		else return y;
	};

	static BinaryOperator<Team> highestTeamValueLambda = (x, y) -> {
		if (x.value > y.value) return x;
		else return y;
	};
}
