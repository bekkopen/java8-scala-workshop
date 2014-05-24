package no.bekk.java.excercises;

import no.bekk.java.model.Team;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static no.bekk.java.model.Data.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class Ex4_LambdaWithParallelStreamsTest {

	@Test
	public void testTeamsWithValueHigherThan() {
		List<Team> teams = asList(manchesterUnited, liverpool, arsenal, borussiaDortmund, atleticoMadrid);

		long before = System.currentTimeMillis();
		List<Team> teamsWithHigherValueThan1B = Ex4_LambdaWithParallelStreams.teamsWithValueHigherThan(1_000_000_000.0, teams);
		long after = System.currentTimeMillis();
		long totalTime = after - before;

		assertThat(totalTime, is(greaterThan(100L)));
		assertThat(totalTime, is(lessThan(450L)));
		assertThat(teamsWithHigherValueThan1B, hasItems(manchesterUnited, arsenal));
		assertThat(teamsWithHigherValueThan1B.size(), is(2));
	}
}
