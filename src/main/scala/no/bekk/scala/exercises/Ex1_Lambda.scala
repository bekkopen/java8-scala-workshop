package no.bekk.scala.exercises

import no.bekk.scala.model.{League, Team, Player}

object Ex1_Lambda {

	def playerName: Player => String = _.name

	def playerAge: Player => Int = _.age

	def isOlderThan(age: Int): Player => Boolean = _.age > age

	def youngestPlayer: (Player, Player) => Player = (x, y) => if (x.birthDate isAfter y.birthDate) x else y

	def highestTeamValue: (Team, Team) => Team = (x, y) => if (x.value > y.value) x else y

	def longestLeagueName: (League, League) => League = (x, y) => if (x.name.length > y.name.length) x else y
}
