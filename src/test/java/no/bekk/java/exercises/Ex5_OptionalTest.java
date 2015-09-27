package no.bekk.java.exercises;

import no.bekk.java.model.Team;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static no.bekk.java.exercises.Ex5_Optional.youngestPlayerNameOlderThan;
import static no.bekk.java.model.Data.liverpool;
import static no.bekk.java.model.Data.manchesterUnited;
import static no.bekk.java.model.Data.wayneRooney;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class Ex5_OptionalTest {

	@Test
	public void testYoungestPlayerNameOlderThanWhenPresent() {
		Optional<String> playerName = youngestPlayerNameOlderThan(manchesterUnited, LocalDate.of(1986, 1, 1));
		assertTrue(playerName.isPresent());
		assertThat(playerName.get(), is(wayneRooney.name));
	}

	@Test
	public void testYoungestPlayerNameOlderThanWhenNotPresent() {
		Optional<String> playerName = youngestPlayerNameOlderThan(liverpool, LocalDate.of(1900, 1, 1));
		assertFalse(playerName.isPresent());
	}

	@Test
	public void testYoungestPlayerNameOlderThanWhenEmtpyList() {
		Team teamWithNoPlayers = new Team("", 0.0, new ArrayList<>());
		Optional<String> playerName = youngestPlayerNameOlderThan(teamWithNoPlayers, LocalDate.of(1900, 1, 1));
		assertFalse(playerName.isPresent());
	}

}
