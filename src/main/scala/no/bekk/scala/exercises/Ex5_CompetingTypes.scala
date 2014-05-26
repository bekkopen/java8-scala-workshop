package no.bekk.scala.exercises

import no.bekk.scala.model.Car

object Ex5_CompetingTypes {

	trait Competing[T] {
		def compete(a: T, b: T): T
	}

	object Competing {
		implicit object CompetingCar extends Competing[Car] {
			def compete(a: Car, b: Car) = ???
		}
	}

	def compete[A](competitors: List[A])(implicit ev: Competing[A]): A = ???
}
