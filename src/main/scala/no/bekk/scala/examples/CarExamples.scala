package no.bekk.scala.examples

import no.bekk.scala.model.Car

class CarExamples {

	def brandsSortedByPrice(cars: List[Car]) = cars.sortBy(_.price).map(_.brand)

}
