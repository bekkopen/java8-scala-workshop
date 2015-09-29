package no.bekk.scala.exercises

import java.time.LocalDate
import no.bekk.scala.model.{Team, Player, League}

object Ex3_LambdaOnCollectionsPart2 {

	def ageOfOldestPlayer(players: List[Player]): Int = ???

	def playersWithNamesStartingWith(start: String, players: List[Player]): List[Player] = ???

	def averageAgeOfPlayers(players: List[Player]): Double = ???

	def sumValueOfAllTeams(teams: List[Team]): Double = ???

	def youngestPlayer(players: List[Player]): Player = ???

	def teamWithHighestValue(teams: List[Team]): Team = ???

	def groupPlayersByBirthYear(players: List[Player]): Map[Int, List[Player]] = ???

	def sumValuesOfEachLeague(leagues: List[League]): List[Double] = ???

	def playersBornBefore(date: LocalDate, leagues: List[League]): List[Player] = ???

	def sortByAgeAndThenName(players: List[Player]): List[Player] = ???

	def nameOfPlayerClosestToAverage(players: List[Player]): String = ???

	def youngestPlayerOnEachTeamMappedByTeamName(teams: List[Team]): Map[String, Player] = ???
}


