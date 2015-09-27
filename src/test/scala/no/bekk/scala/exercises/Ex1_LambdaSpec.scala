package no.bekk.scala.exercises

import no.bekk.scala.model.Data._
import org.scalatest.{Matchers, FlatSpec}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Ex1_LambdaSpec extends FlatSpec with Matchers {

	"playerName" should "return player name" in {
		val expected = List(wayneRooney.name, juanMatta.name, robinVanPersie.name)
		val names = List(Ex1_Lambda.playerName(wayneRooney),
			Ex1_Lambda.playerName(juanMatta),
			Ex1_Lambda.playerName(robinVanPersie))
		names shouldBe expected
	}


	"playerAge" should "return player age" in {
		val expected = List(franckRibery.age, arjenRobben.age, philippLahm.age)
		val ages = List(Ex1_Lambda.playerAge(franckRibery),
			Ex1_Lambda.playerAge(arjenRobben),
			Ex1_Lambda.playerAge(philippLahm))
		ages shouldBe expected
	}


	"isOlderThan" should "return whether a player is older than an age limit" in {
		val AGE_LIMIT = luisSuarez.age
		Ex1_Lambda.isOlderThan(AGE_LIMIT)(stevenGerrard) should be(true)
		Ex1_Lambda.isOlderThan(AGE_LIMIT)(luisSuarez) should be(false)
		Ex1_Lambda.isOlderThan(AGE_LIMIT)(danielSturridge) should be(false)
	}


	"youngestPlayer" should "return youngest player" in {
		val youngestPlayer = Ex1_Lambda.youngestPlayer(franckRibery, arjenRobben)

		youngestPlayer shouldBe arjenRobben
	}


	"highestTeamValue" should "return the team with highest value" in {
		val teamWithHighestValue = Ex1_Lambda.highestTeamValue(manchesterUnited, liverpool)

		teamWithHighestValue shouldBe manchesterUnited
	}


	"longestLeagueName" should "return the league with the longest name" in {
		val leagueWithLongestName = Ex1_Lambda.longestLeagueName(laLiga, premierLeague);

		leagueWithLongestName shouldBe premierLeague
	}
}
