package no.bekk.examples

import org.scalatest._

class ScopeExampleScalaSpec extends FlatSpec with Matchers {
  "Scope example" should "test" in {
    val scopeExample = new ScopeExampleScala

    scopeExample.closure
    scopeExample.scope
  }

}
