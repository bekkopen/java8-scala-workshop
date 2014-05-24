package no.bekk.scala.excercises

import no.bekk.scala.model.{Car, SumoWrestler}

object Ex5_CompetingTypes {

	trait Competing[T] {
		def compete(a: T, b: T): T
	}

	object Competing {
		implicit object CompetingSumoWrestler extends Competing[SumoWrestler] {
			def compete(a: SumoWrestler, b: SumoWrestler) =
				if (a.weight > b.weight) a else b
		}

		implicit object CompetingCar extends Competing[Car] {
			def compete(a: Car, b: Car) =
				if (a.hp > b.hp) a else b
		}
	}

	def compete[A](competitors: List[A])(implicit ev: Competing[A]) =
		competitors.reduce(ev.compete)
}
