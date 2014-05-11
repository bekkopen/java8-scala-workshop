package no.bekk.scala.examples

import org.scalatest._
import Streams.StreamObject

class StreamExampleScalaSpec extends FlatSpec with Matchers {

  "wrg" should "l" in {
    Streams.objectWithNumber(StreamObject(1) :: StreamObject(2) :: StreamObject(3) :: StreamObject(4) :: Nil, 3)
  }

}
