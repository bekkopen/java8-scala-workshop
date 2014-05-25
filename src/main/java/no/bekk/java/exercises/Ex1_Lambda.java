package no.bekk.java.exercises;

import no.bekk.java.model.Player;
import no.bekk.java.model.Team;
import static no.bekk.java.util.Utils.*;

import java.util.function.BinaryOperator;

public class Ex1_Lambda {

	static BinaryOperator<Player> youngestPlayerLambda = implementThis();

	static BinaryOperator<Team> highestTeamValueLambda = implementThis();
}
