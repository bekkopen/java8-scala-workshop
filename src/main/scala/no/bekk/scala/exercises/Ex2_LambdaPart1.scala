package no.bekk.scala.exercises

import java.time.LocalDate

import no.bekk.scala.model.{League, Player, Team}

object Ex2_LambdaPart1 {

	def teamNames(teams: List[Team]) = teams.map(_.name)

	def removeOldPlayers(maxAge: LocalDate, players: List[Player]) = players.filter(_.birthDate.isAfter(maxAge))

	def addValueToEachTeam(percent: Double, teams: List[Team]) =
		teams.map(team => team.copy(value = team.value * (percent + 1)))

	def removeTeamsWithLowValue(teams: List[Team], minValue: Double) = teams.filter(_.value >= minValue)

	def setLeagueNamesToUpperCase(leagues: List[League]) =
		leagues.map(league => league.copy(name = league.name.toUpperCase))
}
