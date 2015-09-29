package no.bekk.scala.exercises

import java.time.LocalDate

import no.bekk.scala.model.{League, Player, Team}

object Ex2_LambdaOnCollectionsPart1 {

	def teamNames(teams: List[Team]): List[String] = ???

	def removeOldPlayers(maxAge: LocalDate, players: List[Player]): List[Player] = ???

	def addValueToEachTeam(percent: Double, teams: List[Team]): List[Team] = ???

	def removeTeamsWithLowValue(teams: List[Team], minValue: Double): List[Team] = ???

	def setLeagueNamesToUpperCase(leagues: List[League]): List[League] = ???
}
