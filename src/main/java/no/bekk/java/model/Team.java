package no.bekk.java.model;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class Team {

    public final String name;
    public final Double value;
    public final List<Player> players;

    public Team(String name, Double value, List<Player> players) {
        this.name = name;
        this.value = value;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return name + ": [" + players.stream().map(Player::toString).collect(joining(", ")) + "]";
    }
}
