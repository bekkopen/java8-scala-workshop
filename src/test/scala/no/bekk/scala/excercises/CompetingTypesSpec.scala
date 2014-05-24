package no.bekk.scala.excercises

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import no.bekk.scala.model.Car

@RunWith(classOf[JUnitRunner])
class CompetingTypesSpec extends FlatSpec with Matchers {
	"it" should "test" in {
		val audi = Car("Audi", 1293999.0, 233.6)
		val opel = Car("Opel", 9122920.0, 187.8)
		val bmw = Car("BMW", 1322766.0, 209.2)

		val winner = CompetingTypes.compete(audi :: opel :: bmw :: Nil)

		winner shouldBe audi
	}

}