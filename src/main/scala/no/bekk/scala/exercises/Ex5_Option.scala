package no.bekk.scala.exercises

import java.time.LocalDate
import no.bekk.scala.model.Team

object Ex5_Option {
	
	def youngestPlayerNameOlderThan(team: Team, minDate: LocalDate): Option[String] =
		team.players.filter(_.birthDate.isBefore(minDate))
			.reduceOption((x, y) => if (x.birthDate.isAfter(y.birthDate)) x else y).map(_.name)
}
