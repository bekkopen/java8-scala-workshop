package no.bekk.scala.exercises

import org.scalatest.{Matchers, FlatSpec}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import no.bekk.scala.model.Data._
import java.time.{Period, LocalDate}

@RunWith(classOf[JUnitRunner])
class Ex3_LambdaOnCollectionsPart2Spec extends FlatSpec with Matchers {

	"ageOfOldestPlayer" should "return oldest player" in {
		val players = wayneRooney :: juanMatta :: mesutOzil :: olivierGiroud :: Nil

		val expected = Period.between(LocalDate.of(1985, 10, 24), LocalDate.now).getYears
		val ageOfOldestPlayer = Ex3_LambdaOnCollectionsPart2.ageOfOldestPlayer(players)

		ageOfOldestPlayer shouldBe expected
	}

	"playersWithNamesStartingWith" should "return players with name starting with a given start string" in {
		val players = kevinPrinceBoateng :: matsHummels :: robertLewandowski :: marcoReus :: Nil

		val playersWithNameStartingWithM = Ex3_LambdaOnCollectionsPart2.playersWithNamesStartingWith("M", players)

		playersWithNameStartingWithM shouldBe matsHummels :: marcoReus :: Nil
	}

	"averageAgeOfPlayers" should "return average age of players" in {
		val players = wayneRooney :: juanMatta :: mesutOzil :: olivierGiroud :: Nil

		val expected = (wayneRooney.age + juanMatta.age + mesutOzil.age + olivierGiroud.age) / 4.0
		val averageAge = Ex3_LambdaOnCollectionsPart2.averageAgeOfPlayers(players)

		averageAge shouldBe expected
	}

	"sumValueOfAllTeams" should "return the sum of the values of all teams" in {
		val premierLeagueTeamsValue = Ex3_LambdaOnCollectionsPart2.sumValueOfAllTeams(premierLeague.teams)

		premierLeagueTeamsValue shouldBe 4831000000.0
	}


	"youngestPlayer" should "return the youngest player" in {
		val players = franckRibery :: arjenRobben :: philippLahm :: Nil

		val youngestPlayer = Ex3_LambdaOnCollectionsPart2.youngestPlayer(players)

		youngestPlayer shouldBe arjenRobben
	}

	"teamWithHighestValue" should "return the team with highest value" in {
		val teamWithHighersValueInPremierLeague = Ex3_LambdaOnCollectionsPart2.teamWithHighestValue(premierLeague.teams)

		teamWithHighersValueInPremierLeague shouldBe manchesterUnited
	}

	"groupPlayersByBirthYear" should "return a map where the key is players birth year and the values are list of players" in {
		val players = wayneRooney :: juanMatta :: mesutOzil :: olivierGiroud :: Nil

		val groupedPlayers = Ex3_LambdaOnCollectionsPart2.groupPlayersByBirthYear(players)

		groupedPlayers.get(1988).get should contain allOf(mesutOzil, juanMatta)
		groupedPlayers.get(1988).get.length shouldBe 2

		groupedPlayers.get(1985).get shouldBe wayneRooney :: Nil

		groupedPlayers.get(1986).get shouldBe olivierGiroud :: Nil
	}

	"sumValuesOfEachLeague" should "return a list containing the sum of all teams in each league" in {
		val premierLeagueSum :: laLigaSum :: bundesligaSum :: Nil = Ex3_LambdaOnCollectionsPart2.sumValuesOfEachLeague(leagues)

		premierLeagueSum shouldBe 4831000000.0
		laLigaSum shouldBe 6968000000.0
		bundesligaSum shouldBe 3030000000.0
	}

	"playersBornBefore" should "return a list of players that born before a given date" in {
		val minAge = LocalDate.of(1983, 5, 30)
		val playersOlderThanMinAge = Ex3_LambdaOnCollectionsPart2.playersBornBefore(minAge, leagues)

		playersOlderThanMinAge should contain allOf(stevenGerrard, danielAlves, davidVilla, franckRibery, timoHildebrand)
		playersOlderThanMinAge.length shouldBe 5
	}

	"sortByAgeAndThenName" should "sort players by age and then name" in {
		val juanMattaClone = juanMatta.copy(name = juanMatta.name + "clone")
		val players = wayneRooney :: juanMattaClone :: danielAlves :: juanMatta :: diegoCosta :: Nil

		val result = Ex3_LambdaOnCollectionsPart2.sortByAgeAndThenName(players)

		result(0) shouldBe diegoCosta
		result(1) shouldBe juanMatta
		result(2) shouldBe juanMattaClone
		result(3) shouldBe wayneRooney
		result(4) shouldBe danielAlves
	}

	"nameOfPlayerClosestToAverage" should "return the player with age closest to average" in {
		val players = wayneRooney :: juanMatta :: olivierGiroud :: davidVilla :: Nil

		val nameOfPlayerClosestToAverage = Ex3_LambdaOnCollectionsPart2.nameOfPlayerClosestToAverage(players)

		nameOfPlayerClosestToAverage shouldBe "Wayne Rooney"
	}

	"youngestPlayerOnEachTeamMappedByTeamName" should "give a map from team name to youngest player on team" in {
		val result = Ex3_LambdaOnCollectionsPart2.youngestPlayerOnEachTeamMappedByTeamName(manchesterUnited :: liverpool :: arsenal :: Nil)

		result(manchesterUnited.name) shouldBe juanMatta
		result(liverpool.name) shouldBe danielSturridge
		result(arsenal.name) shouldBe jackWilshere
	}
}
