package no.bekk.scala.examples

object OptionExample {

	def getNameOfOwner(house: House) =
		Option(house).map(_.owner).flatMap(Option(_)).map(_.name).flatMap(Option(_)).getOrElse("Doesn't exist")
}

case class Person(name: String)
case class House(owner: Person)