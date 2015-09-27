package no.bekk.scala.exercises

import java.time.LocalDate

import no.bekk.scala.model.Data.{manchesterUnited, wayneRooney, liverpool}
import no.bekk.scala.model.Team
import org.junit.runner.RunWith
import org.scalatest.{Matchers, FlatSpec}
import org.scalatest.junit.JUnitRunner
@RunWith(classOf[JUnitRunner])
class Ex5_OptionalsSpec extends FlatSpec with Matchers {

	"youngestPlayerNameOlderThan" should "be present" in {
		val playerName = Ex5_Optionals.youngestPlayerNameOlderThan(manchesterUnited, LocalDate.of(1986, 1, 1))
		playerName shouldBe Some(wayneRooney.name)
	}

	"youngestPlayerNameOlderThan" should "not be present" in {
		val playerName = Ex5_Optionals.youngestPlayerNameOlderThan(liverpool, LocalDate.of(1900, 1, 1))
		playerName shouldBe None
	}

	"youngestPlayerNameOlderThan" should "not be present when team with no players" in {
		val playerName = Ex5_Optionals.youngestPlayerNameOlderThan(Team("", 0, Nil), LocalDate.of(2000, 1, 1))
		playerName shouldBe None
	}
}
