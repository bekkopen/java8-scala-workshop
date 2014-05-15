package no.bekk.java.excercises;

import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.*;

public class Lambda {

    static List<Player> playersOlderThan(final LocalDate minAge, final List<League> leagues) {
        return leagues.stream()
                .map(League::getTeams)
                .reduce(new ArrayList<>(),(Lambda::combine)).stream()
                .map(Team::getPlayers).reduce(new ArrayList<>(),Lambda::combine).stream()
                .filter(player -> player.birthday.isAfter(minAge)).collect(toList());
    }

    private static <T> List<T> combine(final List<T>a, final List<T> b) {
        List<T> result = a;
        result.addAll(b);
        return result;
    }

}
