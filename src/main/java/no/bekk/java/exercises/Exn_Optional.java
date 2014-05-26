package no.bekk.java.exercises;

import no.bekk.java.model.League;
import no.bekk.java.model.Player;
import no.bekk.java.model.Team;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Exn_Optional {

	Optional<Player> findAnyPlayerInLeaguesWithBirthdayAfter(List<League> leagues, String leagueName, LocalDate birthday) {
		return leagues.stream()
				.flatMap(l -> l.getTeams().stream())
				.flatMap(t -> t.getPlayers().stream())
				.filter(p -> p.birthDate.isAfter(birthday))
				.findAny();
	}

	Optional<Player> findAnyPlayerWhosTeamsValueIsMoreThanAndWithBirthdayAfter(List<League> leagues, Double minValue, LocalDate minBirthday) {
		return leagues.stream()
				.flatMap(l -> l.getTeams().stream())
				.filter(t -> t.value > minValue)
				.flatMap(t -> t.getPlayers().stream())
				.filter(p -> p.birthDate.isAfter(minBirthday))
				.findAny();
	}

	Optional<Player> findAnyPlayerWhosTeamsValueIsMoreThanAndWithBirthdayAfter(Optional<List<League>> leagues, Double minValue, LocalDate minBirthday) {
		// leagues.map(_.flatMap(_.teams.flatMap(_.players))).flatMap(_.find(_.birthDate.isAfter(minBirthday)))

//		Optional<List<Player>> v = leagues.map(ll -> ll.stream().flatMap(l -> l.getTeams().stream().flatMap(t -> t.getPlayers().stream())));

		return null;
	}
}
