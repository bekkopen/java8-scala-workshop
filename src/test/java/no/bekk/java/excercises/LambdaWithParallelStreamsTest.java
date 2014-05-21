package no.bekk.java.excercises;

import junit.framework.TestCase;
import no.bekk.java.model.Team;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

public class LambdaWithParallelStreamsTest extends TestCase {
	@Test
	public void testTeamsWithValueHigherThan() {
		Team manchesterUnited = new Team("Manchester United", 2_810_000_000.0, new ArrayList<>());
		Team liverpool = new Team("Liverpool", 691_000_000.0, new ArrayList<>());
		Team arsenal = new Team("Arsenal", 1_330_000_000.0, new ArrayList<>());
		Team borussiaDortmund = new Team("Borussia Dortmund", 600_000_000.0, new ArrayList<>());
		Team atleticoMadrid = new Team("Atletico Madrid", 328_000_000.0, new ArrayList<>());
		List<Team> teams = asList(manchesterUnited, liverpool, arsenal, borussiaDortmund, atleticoMadrid);

		long before = System.currentTimeMillis();
		List<Team> teamsWithHigherValueThan1B = LambdaWithParallelStreams.teamsWithValueHigherThan(1_000_000_000.0, teams);
		long after = System.currentTimeMillis();
		long totalTime = after - before;

		assertThat(totalTime, is(greaterThan(100L)));
		assertThat(totalTime, is(lessThan(450L)));
		assertThat(teamsWithHigherValueThan1B, hasItems(manchesterUnited, arsenal));
		assertThat(teamsWithHigherValueThan1B, not(hasItems(liverpool, borussiaDortmund, atleticoMadrid)));
	}
}
