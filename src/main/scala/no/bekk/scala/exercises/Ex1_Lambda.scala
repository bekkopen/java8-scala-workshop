package no.bekk.scala.exercises

import no.bekk.scala.model.{League, Team, Player}

object Ex1_Lambda {

	def playerName: Player => String = ???

	def playerAge: Player => Int = ???

	def isOlderThan(age: Int): Player => Boolean = ???

	def youngestPlayer: (Player, Player) => Player = ???

	def highestTeamValue: (Team, Team) => Team = ???

	def longestLeagueName: (League, League) => League = ???
}
