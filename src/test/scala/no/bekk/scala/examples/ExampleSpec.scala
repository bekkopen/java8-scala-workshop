package no.bekk.scala.examples

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ExampleSpec extends FlatSpec with Matchers {
  "Example.double" should "double all values in a list" in {
    val numbers = 1 :: 2 :: 3 :: Nil
    val doubled = Example.doubleNumbers(numbers)
    doubled shouldBe 2 :: 4 :: 6 :: Nil
  }
}
