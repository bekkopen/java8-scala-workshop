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

	static BinaryOperator<Player> youngestPlayerLambda = (x, y) -> {
		if (x.birthday.isAfter(y.birthday)) return x;
		else return y;
	};

	static BinaryOperator<Team> highestTeamValueLambda = (x, y) -> {
		if (x.value > y.value) return x;
		else return y;
	};
}
