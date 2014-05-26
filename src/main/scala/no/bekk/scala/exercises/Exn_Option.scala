package no.bekk.scala.exercises

import java.time.LocalDate
import no.bekk.scala.model.League

class Exn_Option {

	def findAnyPlayerWhosTeamsValueIsMoreThanAndWithBirthdayAfter(leagues: Option[List[League]], minValue: Double, minBirthday: LocalDate) = {

		val v = leagues.map(_.flatMap(_.teams.flatMap(_.players))).flatMap(_.find(_.birthDate.isAfter(minBirthday)))
	}
}
