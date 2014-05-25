package no.bekk.scala.exercises

import java.time.LocalDate
import no.bekk.scala.model.{Team, Player, League}

object Ex3_Lambda {

	import ListExtensions._

	def teamNames(teams: List[Team]) = teams.map(_.name)

	def ageOfOldestPlayer(players: List[Player]) = players.map(_.age).max

	def averageAgeOfPlayers(players: List[Player]) = players.map(_.age).sum.toDouble / players.length

	def nameOfPlayerClosestToAverage(players: List[Player]) =
		players.minimum((x: Player) => Math.abs(x.age - averageAgeOfPlayers(players))).name

	def playersWithNamesStartingWith(start: String, players: List[Player]) = players.filter(_.name.startsWith(start))

	def sumValueOfAllTeams(teams: List[Team]) = teams.map(_.value).sum

	def youngestPlayer(players: List[Player]) = players.reduce(Ex1_Lambda.youngestPlayerLambda)

	def groupPlayersByBirthYear(players: List[Player]) = players.groupBy(_.birthDate.getYear)

	def teamWithHighestValue(teams: List[Team]) = teams.reduce(Ex1_Lambda.highestTeamValueLambda)

	def sumValuesOfEachLeague(leagues: List[League]) =
		leagues.map(_.teams.map(_.value).sum)

	def playersBornBefore(date: LocalDate, leagues: List[League]): List[Player] =
		leagues.map(_.teams)
				.reduce(_ ::: _)
				.map(_.players)
				.reduce(_ ::: _)
				.filter(_.birthDate isBefore date)

}

object ListExtensions {
	class RichList[A](list: List[A]) {
		def minimum(fn: A => Double): A = {
			list.reduce((x, y) => if (fn(x) < fn(y)) x else y)
		}
	}
	implicit def richList[A](list: List[A]): RichList[A] = new RichList(list)
}

