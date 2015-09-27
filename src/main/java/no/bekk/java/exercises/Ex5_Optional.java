package no.bekk.java.exercises;

import no.bekk.java.model.Player;
import no.bekk.java.model.Team;

import java.time.LocalDate;
import java.util.Optional;

public class Ex5_Optional {

    static Optional<String> youngestPlayerNameOlderThan(Team team, LocalDate minDate) {
        return team.getPlayers().stream()
                .filter(player -> player.birthDate.isBefore(minDate))
                .reduce((x, y) -> {
                    if (x.birthDate.isAfter(y.birthDate)) return x;
                    else return y;
                }).map(Player::getName);
    }
}
