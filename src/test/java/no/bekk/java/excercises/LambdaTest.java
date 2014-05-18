package no.bekk.java.excercises;

import junit.framework.TestCase;
import no.bekk.java.model.Data;
import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LambdaTest extends TestCase {

	final List<League> leagues = Data.getAllLeagues();

	@Test
	public void testTeamWithHighestValue() {
		Optional<Team> team = Lambda.teamWithHighestValue(leagues.get(0).teams);
		assertThat("Team with highestValue", team.get().name, is("Manchester United"));
	}

	@Test
	public void testPlayersOlderThan() {
		LocalDate minAge = LocalDate.of(1983, 5, 30);
		List<Player> players = Lambda.playersOlderThan(minAge, leagues);
		assert (containsOldPlayer(players, "Steven Gerrard"));
		assert (containsOldPlayer(players, "Daniel Alves"));
		assert (containsOldPlayer(players, "David Villa"));
		assert (containsOldPlayer(players, "Franck Ribéry"));
		assert (containsOldPlayer(players, "Timo Hildebrand"));
	}

	private boolean containsOldPlayer(List<Player> players, String playerName) {
		return players.stream().anyMatch(player -> player.name.equals(playerName));
	}
}
