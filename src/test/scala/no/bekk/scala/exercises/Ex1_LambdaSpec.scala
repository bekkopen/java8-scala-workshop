package no.bekk.scala.exercises

import no.bekk.scala.model.Data._
import org.scalatest.{Matchers, FlatSpec}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Ex1_LambdaSpec extends FlatSpec with Matchers {

	"youngestPlayerLambda" should "return youngest player" in {
		val youngestPlayer = Ex1_Lambda.youngestPlayerLambda(franckRibery, arjenRobben)

		youngestPlayer shouldBe arjenRobben
	}

	"highestTeamValueLambda" should "return the team with highest value" in {
		val teamWithHighestValue = Ex1_Lambda.highestTeamValueLambda(manchesterUnited, liverpool)

		teamWithHighestValue shouldBe manchesterUnited
	}
}
