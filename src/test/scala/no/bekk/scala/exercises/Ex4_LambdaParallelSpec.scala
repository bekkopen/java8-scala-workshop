package no.bekk.scala.exercises

import org.scalatest.{Matchers, FlatSpec}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import no.bekk.scala.model.Data._

@RunWith(classOf[JUnitRunner])
class Ex4_LambdaParallelSpec extends FlatSpec with Matchers {

	"teamsWithValueHigherThan" should "return teams with value higher than a given value, filtered by a slow predicate" in {
		val teams = manchesterUnited :: liverpool :: arsenal :: borussiaDortmund :: atleticoMadrid :: Nil

		val before = System.currentTimeMillis
		val teamsWithHigherValueThan1B = Ex4_LambdaParallel.teamsWithValueHigherThan(1000000000.0, teams)
		val after = System.currentTimeMillis
		val totalTime = after - before

		totalTime should be > 100L
		totalTime should be < 450L
		teamsWithHigherValueThan1B should contain allOf(manchesterUnited, arsenal)
		teamsWithHigherValueThan1B.length shouldBe 2
	}
}
