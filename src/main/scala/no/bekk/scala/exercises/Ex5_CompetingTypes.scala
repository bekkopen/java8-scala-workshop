package no.bekk.scala.exercises

import no.bekk.scala.model.{Car, SumoWrestler}

object Ex5_CompetingTypes {

	trait Competing[T] {
		def compete(a: T, b: T): T
	}

	object Competing {
		implicit object CompetingSumoWrestler extends Competing[SumoWrestler] {
			def compete(a: SumoWrestler, b: SumoWrestler) = ???
		}

		implicit object CompetingCar extends Competing[Car] {
			def compete(a: Car, b: Car) = ???
		}
	}

	def compete[A](competitors: List[A])(implicit ev: Competing[A]): A = ???
}
