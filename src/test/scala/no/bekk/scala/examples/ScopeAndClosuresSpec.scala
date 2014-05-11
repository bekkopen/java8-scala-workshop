package no.bekk.scala.examples

import org.scalatest._

class ScopeAndClosuresSpec extends FlatSpec with Matchers {
  "Scope and closures" should "test" in {
    val scopeExample = new ScopeAndClosures

    scopeExample.closure
    scopeExample.scope
  }

}
