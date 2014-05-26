package no.bekk.java.exercises;

import no.bekk.java.model.Player;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static no.bekk.java.exercises.Ex5_Optional.youngestPlayerOlderThan;
import static no.bekk.java.model.Data.liverpool;
import static no.bekk.java.model.Data.manchesterUnited;
import static no.bekk.java.model.Data.wayneRooney;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class Ex5_OptionalTest {

    @Test
    public void testYoungestPlayerOlderThanWhenPresent() {
        Optional<Player> player = youngestPlayerOlderThan(manchesterUnited, LocalDate.of(1986, 1, 1));
        assertTrue(player.isPresent());
        assertThat(player.get(), is(wayneRooney));
    }

    @Test
    public void testYoungestPlayerOlderThanWhenNotPresent() {
        Optional<Player> player = youngestPlayerOlderThan(liverpool, LocalDate.of(1900, 1, 1));
        assertFalse(player.isPresent());
    }

}
