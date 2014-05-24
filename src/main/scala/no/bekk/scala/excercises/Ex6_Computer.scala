package no.bekk.scala.excercises

trait ComputerComponent {
	val manufacturer: String
}
case class Cpu(manufacturer: String, clockSpeed: Double) extends ComputerComponent
case class Memory(manufacturer: String, ram: Int) extends ComputerComponent
case class Motherboard(manufacturer: String) extends ComputerComponent

case class Computer(motherboard: Motherboard, cpu: Cpu, memory: Memory)

trait CpuContext {
	val cpu: Cpu
}

trait MemoryContext {
	val memory: Memory
}

trait MotherboardContext {
	val motherboard: Motherboard
}

trait ComputerContext {
	self: MotherboardContext with CpuContext with MemoryContext =>
	val computer = Computer(motherboard, cpu, memory)
}

/**
 * Motherboard contexts
 */

trait AsusMotherboardContext extends MotherboardContext {
	lazy val motherboard = Motherboard("Asus")
}

trait MsiMotherboardContext extends MotherboardContext {
	lazy val motherboard = Motherboard("MSI")
}

/**
 * CPU contexts
 */

trait IntelCpuContext extends CpuContext {
	lazy val cpu = Cpu("Intel", 3.5)
}

trait AmdCpuContext extends CpuContext {
	lazy val cpu = Cpu("AMD", 2.8)
}

/**
 * Memory contexts
 */

trait CorsairMemoryContext extends MemoryContext {
	lazy val memory = Memory("Corsair", 16)
}

trait KingstonMemoryContext extends MemoryContext {
	lazy val memory = Memory("Kingston", 8)
}

/**
 * Computers
 */
object Computers {

	//val computer1: ComputerContext = ??? //new ComputerContext with ...
	val computer1: ComputerContext = new ComputerContext with IntelCpuContext with AsusMotherboardContext with CorsairMemoryContext
	val computer2: ComputerContext = new ComputerContext with AmdCpuContext with AsusMotherboardContext with KingstonMemoryContext
}
