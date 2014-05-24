package no.bekk.java.excercises;

import no.bekk.java.model.Player;
import no.bekk.java.model.Team;
import org.junit.Test;

import static no.bekk.java.model.Data.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Ex1_LambdaTest {

	@Test
	public void testYoungestPlayerLambda() {
		Player youngestPlayer = Ex1_Lambda.youngestPlayerLambda.apply(franckRibery, arjenRobben);

		assertThat(youngestPlayer, is(arjenRobben));
	}

	@Test
	public void testHighestTeamValueLambda() {
		Team teamWithHighestValue = Ex1_Lambda.highestTeamValueLambda.apply(manchesterUnited, liverpool);

		assertThat(teamWithHighestValue, is(manchesterUnited));
	}
}
