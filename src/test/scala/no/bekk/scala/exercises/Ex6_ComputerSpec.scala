package no.bekk.scala.exercises


import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Ex6_ComputerSpec extends FlatSpec with Matchers {

	"computer1" should "contain an Asus motherboard, an Intel CPU, and Corsair memory" in {
		Ex6_Computers.computer1 shouldBe Computer(Motherboard("Asus"), Cpu("Intel", 3.5), Memory("Corsair", 16))
	}

	"computer2" should "contain an MSI motherboard, an AMD CPU, and Kingston memory" in {
		Ex6_Computers.computer2 shouldBe Computer(Motherboard("MSI"), Cpu("AMD", 2.8), Memory("Kingston", 8))
	}
}
