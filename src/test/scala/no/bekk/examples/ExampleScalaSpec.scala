package no.bekk.examples

import org.scalatest._

class ExampleScalaSpec extends FlatSpec with Matchers {
  "Example.double" should "double all values in a list" in {
    val numbers = 1 :: 2 :: 3 :: Nil
    val doubled = ExampleScala.doubleNumbers(numbers)
    doubled shouldBe 2 :: 4 :: 6 :: Nil
  }

  "blabal" should "hi" in {
    val numbers = 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: Nil
    val res = ExampleScala.filterTest(numbers)
    res shouldBe 4
  }
}
