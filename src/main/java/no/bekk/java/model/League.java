package no.bekk.java.model;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class League {

    public final String name;
    public final List<Team> teams;

    public League(String name, List<Team> teams) {
        this.name = name;
        this.teams = teams;
    }

    @Override
    public String toString() {
        return name + ": [" + teams.stream().map(Team::toString).collect(joining(", ")) + "]";
    }
}
