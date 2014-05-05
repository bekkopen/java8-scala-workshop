package no.bekk.examples

object ExampleScala {
  def doubleNumbers(numbers: List[Int]) = numbers.map(_ * 2)

  def filterTest(numbers: List[Int]) = numbers.filter(n => {println(s"number: $n");n > 3}).head
}
