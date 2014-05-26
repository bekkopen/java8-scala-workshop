package no.bekk.scala.examples

class ScopeAndClosures {
  var num = 1

  def closure {
    var num = 2
    (() => {
      this.num = 4 // ok
      num = 3 // ok
      println(this.num) // prints 4
      println(num) // prints 3
    })()
  }

  def scope {
    var num = 2
    (() => {
      var num = 3 // shadowing of `num` in parent scope
      println(num) // prints 3
    })()
  }
}
