package no.bekk.java.model;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class Team {

    public final String name;
    public final Long value;
    public final List<Player> players;

    public Team(String name, Long value, List<Player> players) {
        this.name = name;
        this.value = value;
        this.players = players;
    }

    @Override
    public String toString() {
        return name + ": [" + players.stream().map(Player::toString).collect(joining(", ")) + "]";
    }
}
