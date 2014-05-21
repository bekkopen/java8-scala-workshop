package no.bekk.java.excercises;

import junit.framework.TestCase;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;
import org.junit.Test;

import static no.bekk.java.model.Data.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LambdaTest extends TestCase {

	@Test
	public void testYoungestPlayerLambda() {
		Player youngestPlayer = Lambda.youngestPlayerLambda.apply(franckRibery, arjenRobben);

		assertThat(youngestPlayer, is(arjenRobben));
	}

	@Test
	public void testHighestTeamValueLambda() {
		Team teamWithHighestValue = Lambda.highestTeamValueLambda.apply(manchesterUnited, liverpool);

		assertThat(teamWithHighestValue, is(manchesterUnited));
	}
}
