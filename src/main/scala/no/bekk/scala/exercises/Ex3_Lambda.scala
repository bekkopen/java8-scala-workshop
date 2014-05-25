package no.bekk.scala.exercises

import java.time.LocalDate
import no.bekk.scala.model.{Team, Player, League}

object Ex3_Lambda {

	def teamNames(teams: List[Team]): List[String] = ???

	def ageOfOldestPlayer(players: List[Player]): Int = ???

	def averageAgeOfPlayers(players: List[Player]): Double = ???

	def nameOfPlayerClosestToAverage(players: List[Player]): String = ???

	def playersWithNamesStartingWith(start: String, players: List[Player]): List[Player] = ???

	def sumValueOfAllTeams(teams: List[Team]): Double = ???

	def youngestPlayer(players: List[Player]): Player = ???

	def groupPlayersByBirthYear(players: List[Player]): Map[Int, List[Player]] = ???

	def teamWithHighestValue(teams: List[Team]): Team = ???

	def sumValuesOfEachLeague(leagues: List[League]): List[Double] = ???

	def playersBornBefore(date: LocalDate, leagues: List[League]): List[Player] = ???
}


