package no.bekk.scala.exercises

import no.bekk.scala.exercises.Ex7_ExtendedTypes.Competing
import no.bekk.scala.model.Car

object Ex7_ExtendedTypes {

	trait Competing[T] {
		def compete(a: T, b: T): T
	}

	def compete[A](competitors: List[A])(implicit ev: Competing[A]): A = ???
}

object CompetingTypes {
	implicit object CompetingCar extends Competing[Car] {
		def compete(a: Car, b: Car): Car = ???
	}
}