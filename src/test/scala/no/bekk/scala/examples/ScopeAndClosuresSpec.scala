package no.bekk.scala.examples

import org.scalatest.{Matchers, FlatSpec}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

//@RunWith(classOf[JUnitRunner])
class ScopeAndClosuresSpec extends FlatSpec with Matchers {
  "Scope and closures" should "test" in {
    val scopeExample = new ScopeAndClosures

    scopeExample.closure
    scopeExample.scope
  }

}
