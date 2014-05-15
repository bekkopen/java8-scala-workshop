package no.bekk.java.excercises;

import junit.framework.TestCase;
import no.bekk.java.model.Data;
import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LambdaTest extends TestCase {

    final List<League> leagues = Data.getAllLeagues();


    @Test
    public void testDoubleNumbers() {
        LocalDate minAge = LocalDate.of(1980, 5, 30);
        List<Player> players = Lambda.playersOlderThan(minAge, leagues);
        // TODO
    }
}
