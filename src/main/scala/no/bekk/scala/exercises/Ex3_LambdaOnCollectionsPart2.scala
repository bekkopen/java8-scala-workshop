package no.bekk.scala.exercises

import java.time.LocalDate
import no.bekk.scala.model.{Team, Player, League}

object Ex3_LambdaOnCollectionsPart2 {

	import ListExtensions._

	def ageOfOldestPlayer(players: List[Player]): Int = players.map(_.age).max

	def playersWithNamesStartingWith(start: String, players: List[Player]): List[Player] =
		players.filter(_.name.startsWith(start))

	def averageAgeOfPlayers(players: List[Player]): Double = players.map(_.age).sum.toDouble / players.length

	def sumValueOfAllTeams(teams: List[Team]): Double = teams.map(_.value).sum

	def youngestPlayer(players: List[Player]): Player = players.reduce(Ex1_Lambda.youngestPlayer)

	def teamWithHighestValue(teams: List[Team]): Team = teams.reduce(Ex1_Lambda.highestTeamValue)

	def groupPlayersByBirthYear(players: List[Player]): Map[Int, List[Player]] = players.groupBy(_.birthDate.getYear)

	def sumValuesOfEachLeague(leagues: List[League]): List[Double] =
		leagues.map(_.teams.map(_.value).sum)

	def playersBornBefore(date: LocalDate, leagues: List[League]): List[Player] =
		leagues.flatMap(_.teams.flatMap(_.players.filter(_.birthDate isBefore date)))

	def sortByAgeAndThenName(players: List[Player]): List[Player] =
		players.sortWith((x, y) => if (x.age == y.age) x.name < y.name else x.age < y.age)

	def nameOfPlayerClosestToAverage(players: List[Player]): String =
		players.minimum((x: Player) => Math.abs(x.age - averageAgeOfPlayers(players))).name

	def youngestPlayerOnEachTeamMappedByTeamName(teams: List[Team]): Map[String, Player] =
		teams.map(team => team.name -> team.players.reduce(Ex1_Lambda.youngestPlayer)).toMap

}

object ListExtensions {
	class RichList[A](list: List[A]) {
		def minimum(fn: A => Double): A = {
			list.reduce((x, y) => if (fn(x) < fn(y)) x else y)
		}
	}
	implicit def richList[A](list: List[A]): RichList[A] = new RichList(list)
}

