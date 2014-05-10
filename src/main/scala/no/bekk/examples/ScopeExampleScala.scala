package no.bekk.examples

class ScopeExampleScala {
  var num = 1

  def closure {
    var num = 2
    (() => {
      println(num) // prints 2
      println(this.num) // prints 1
      num = 3 // ok
      this.num = 4 // ok
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
