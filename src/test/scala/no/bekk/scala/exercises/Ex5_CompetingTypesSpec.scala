package no.bekk.scala.exercises

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import no.bekk.scala.model.Car

@RunWith(classOf[JUnitRunner])
class Ex5_CompetingTypesSpec extends FlatSpec with Matchers {
	"Cars" should "be able to compete, and the car with most hp should win" in {
		val audi = Car("Audi", 1293999.0, 233.6)
		val opel = Car("Opel", 9122920.0, 187.8)
		val bmw = Car("BMW", 1322766.0, 209.2)

		val winner = Ex5_CompetingTypes.compete(audi :: opel :: bmw :: Nil)

		winner shouldBe audi
	}
}