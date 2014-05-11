package no.bekk.scala.examples

case class StrigCache() extends Retrievable[String] with Cache[String] {
  def retrieve = ???
}

trait Retrievable[T] {
  def retrieve: T
}

trait Cache[T] {
  self: Retrievable[T] =>

  var value: Option[T] = None

  def getValue: T = value.getOrElse {
    value = Some(retrieve)
    value.get
  }

  def invalidate {
    value = None
  }
}
