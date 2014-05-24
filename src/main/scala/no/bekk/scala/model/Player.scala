package no.bekk.scala.model

import java.time.{Period, LocalDate}

case class Player(name: String, birthDate: LocalDate) {
	def age = Period.between(birthDate, LocalDate.now).getYears
}