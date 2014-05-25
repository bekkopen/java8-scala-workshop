package no.bekk.scala.exercises

import org.scalatest.{Matchers, FlatSpec}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import no.bekk.scala.model.Data._
import java.time.LocalDate

@RunWith(classOf[JUnitRunner])
class Ex3_LambdaSpec extends FlatSpec with Matchers {

	"teamNames" should "result in a list of the names of the teams" in {
		val teams = manchesterUnited :: liverpool :: arsenal :: Nil

		val teamNames = Ex3_Lambda.teamNames(teams)

		teamNames shouldBe "Manchester United" :: "Liverpool" :: "Arsenal" :: Nil

	}

	"ageOfOldestPlayer" should "return oldest player" in {
		val players = wayneRooney :: juanMatta :: mesutOzil :: olivierGiroud :: Nil

		val ageOfOldestPlayer = Ex3_Lambda.ageOfOldestPlayer(players)

		ageOfOldestPlayer shouldBe 28
	}

	"averageAgeOfPlayers" should "return average age of players" in {
		val players = wayneRooney :: juanMatta :: mesutOzil :: olivierGiroud :: Nil

		val averageAge = Ex3_Lambda.averageAgeOfPlayers(players)

		averageAge shouldBe 26.5
	}

	"nameOfPlayerClosestToAverage" should "return the player with age closest to average" in {
		val players = wayneRooney :: juanMatta :: olivierGiroud :: davidVilla :: Nil

		val nameOfPlayerClosestToAverage = Ex3_Lambda.nameOfPlayerClosestToAverage(players)

		nameOfPlayerClosestToAverage shouldBe "Wayne Rooney"
	}

	"playersWithNamesStartingWith" should "return players with name starting with a given start string" in {
		val players = kevinPrinceBoateng :: matsHummels :: robertLewandowski :: marcoReus :: Nil

		val playersWithNameStartingWithM = Ex3_Lambda.playersWithNamesStartingWith("M", players)

		playersWithNameStartingWithM shouldBe matsHummels :: marcoReus :: Nil
	}

	"sumValueOfAllTeams" should "return the sum of the values of all teams" in {
		val premierLeagueTeamsValue = Ex3_Lambda.sumValueOfAllTeams(premierLeague.teams)

		premierLeagueTeamsValue shouldBe 4831000000.0
	}

	"youngestPlayer" should "return the youngest player" in {
		val players = franckRibery :: arjenRobben :: philippLahm :: Nil

		val youngestPlayer = Ex3_Lambda.youngestPlayer(players)

		youngestPlayer shouldBe arjenRobben
	}

	"groupPlayersByBirthYear" should "return a map where the key is players birth year and the values are list of players" in {
		val players = wayneRooney :: juanMatta :: mesutOzil :: olivierGiroud :: Nil

		val groupedPlayers = Ex3_Lambda.groupPlayersByBirthYear(players)

		groupedPlayers.get(1988).get should contain allOf(mesutOzil, juanMatta)
		groupedPlayers.get(1988).get.length shouldBe 2

		groupedPlayers.get(1985).get shouldBe wayneRooney :: Nil

		groupedPlayers.get(1986).get shouldBe olivierGiroud :: Nil
	}

	"teamWithHighestValue" should "return the team with highest value" in {
		val teamWithHighestValueInPremierLeague= Ex3_Lambda.teamWithHighestValue(premierLeague.teams)

		teamWithHighestValueInPremierLeague shouldBe manchesterUnited
	}

	"sumValuesOfEachLeague" should "return a list containing the sum of all teams in each league" in {
		val premierLeagueSum :: laLigaSum :: bundesligaSum :: Nil = Ex3_Lambda.sumValuesOfEachLeague(leagues)

		premierLeagueSum shouldBe 4831000000.0
		laLigaSum shouldBe 6968000000.0
		bundesligaSum shouldBe 3030000000.0
	}

	"playersBornBefore" should "return a list of players that born before a given date" in {
		val minAge = LocalDate.of(1983, 5, 30)
		val playersOlderThanMinAge = Ex3_Lambda.playersBornBefore(minAge, leagues)

		playersOlderThanMinAge should contain allOf(stevenGerrard, danielAlves, davidVilla, franckRibery, timoHildebrand)
		playersOlderThanMinAge.length shouldBe 5
	}
}
