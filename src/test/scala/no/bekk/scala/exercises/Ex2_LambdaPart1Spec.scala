package no.bekk.scala.exercises

import java.time.LocalDate

import no.bekk.scala.model.Data._
import org.junit.runner.RunWith
import org.scalatest.{Matchers, FlatSpec}
import org.scalatest.junit.JUnitRunner

import scala.math.BigDecimal.RoundingMode

@RunWith(classOf[JUnitRunner])
class Ex2_LambdaPart1Spec extends FlatSpec with Matchers {

	"teamNames" should "result in a list of the names of the teams" in {
		val teams = manchesterUnited :: liverpool :: arsenal :: Nil

		val teamNames = Ex2_LambdaPart1.teamNames(teams)

		teamNames shouldBe "Manchester United" :: "Liverpool" :: "Arsenal" :: Nil
	}

	"removeOldPlayers" should "remove players older than a given date" in {
		val result = Ex2_LambdaPart1.removeOldPlayers(LocalDate.of(1984, 1, 1), bayernMunchen.players)

		result should contain only arjenRobben
		result should not contain allOf(philippLahm, franckRibery)
	}

	"addValueToEachTeam" should "add value in percentage to each team" in {
		val teams = manchesterUnited :: liverpool :: arsenal :: Nil

		val teamsWithFivePercentValueIncrease = Ex2_LambdaPart1.addValueToEachTeam(0.05, teams)

		round(teamsWithFivePercentValueIncrease(0).value) shouldBe round(2950500000.0)
		round(teamsWithFivePercentValueIncrease(1).value) shouldBe round(725550000.0)
		round(teamsWithFivePercentValueIncrease(2).value) shouldBe round(1396500000.0)
	}

	"removeTeamsWithLowValue" should "remove teams with value lower than limit" in {
		val teams = manchesterUnited :: liverpool :: arsenal :: borussiaDortmund :: atleticoMadrid :: Nil

		val result = Ex2_LambdaPart1.removeTeamsWithLowValue(teams, 1330000000.0)

		result should contain allOf(manchesterUnited, arsenal)
		result should not contain allOf(liverpool, borussiaDortmund, atleticoMadrid)
	}

	"setLeagueNamesToUpperCase" should "uppercase league names" in {
		val result = Ex2_LambdaPart1.setLeagueNamesToUpperCase(leagues)

		result(0).name shouldBe "PREMIER LEAGUE"
		result(1).name shouldBe "LA LIGA"
		result(2).name shouldBe "BUNDESLIGA"
	}

	private def round(d: Double) = BigDecimal(d).setScale(2, RoundingMode.HALF_UP)

}
