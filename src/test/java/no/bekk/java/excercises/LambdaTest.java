package no.bekk.java.excercises;

import junit.framework.TestCase;
import no.bekk.java.model.Data;
import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.*;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LambdaTest extends TestCase {

	static final List<League> leagues = Data.getAllLeagues();

	@Test
	public void testYoungestPlayerLambda() {
		Player franck = new Player("Franck Ribéry", LocalDate.of(1983, 4, 7));
		Player arjen = new Player("Arjen Robben", LocalDate.of(1984, 1, 23));

		Player youngestPlayer = Lambda.youngestPlayerLambda.apply(franck, arjen);

		assertThat(youngestPlayer, is(arjen));
	}

	@Test
	public void testHighestTeamValueLambda() {
		Team manchesterUnited = new Team("Manchester United", 2_810_000_000.0, new ArrayList<>());
		Team liverpool = new Team("Liverpool", 691_000_000.0, new ArrayList<>());

		Team teamWithHighestValue = Lambda.highestTeamValueLambda.apply(manchesterUnited, liverpool);

		assertThat(teamWithHighestValue, is(manchesterUnited));
	}
}
