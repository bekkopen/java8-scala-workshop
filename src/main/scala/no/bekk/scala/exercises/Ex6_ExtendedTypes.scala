package no.bekk.scala.exercises

import no.bekk.scala.exercises.Ex6_ExtendedTypes.Competing
import no.bekk.scala.model.Car

object Ex6_ExtendedTypes {

	trait Competing[T] {
		def compete(a: T, b: T): T
	}

	def compete[A](competitors: List[A])(implicit ev: Competing[A]): A =
		competitors.reduce(ev.compete)
}

object CompetingTypes {
	implicit object CompetingCar extends Competing[Car] {
		def compete(a: Car, b: Car): Car =
			if (a.hp > b.hp) a else b
	}
}