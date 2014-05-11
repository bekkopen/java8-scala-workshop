package no.bekk.scala.examples

object Streams {
  case class StreamObject(num: Int)

  def objectWithNumber(lst: List[StreamObject], num: Int) = lst.toStream.map{so => println(so); so.num}
  .find(_ == num)

}
