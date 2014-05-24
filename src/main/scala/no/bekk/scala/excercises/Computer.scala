package no.bekk.scala.excercises

object Computer {


	trait ComputerComponent {
		val manufacturer: String
	}

	case class Motherboard(manufacturer: String) extends ComputerComponent
	case class Cpu(manufacturer: String, clockSpeed: Double) extends ComputerComponent
	case class Memory(manufacturer: String, ram: Int) extends ComputerComponent
	case class Computer(motherboard: Motherboard, cpu: Cpu, memory: Memory)

	trait MotherboardContext {
		val motherboard: Motherboard
	}

	trait CpuContext {
		val cpu: Cpu
	}

	trait MemoryContext {
		val memory: Memory
	}

	trait ComputerContext {
		self: MotherboardContext with CpuContext with MemoryContext =>
		val computer = Computer(motherboard, cpu, memory)
	}

	/**
	 * Motherboards
	 */

	trait AsusMotherboardContext extends MotherboardContext {
		lazy val motherboard = Motherboard("Asus")
	}

	trait MsiMotherboardContext extends MotherboardContext {
		lazy val motherboard = Motherboard("MSI")
	}

	/**
	 * CPU's
	 */

	trait IntelCpuContext extends CpuContext {
		lazy val cpu = Cpu("Intel", 3.5)
	}

	trait AmdCpuContext extends CpuContext {
		lazy val cpu = Cpu("AMD", 2.8)
	}

	/**
	 * Memory
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

	//val newComputer: ComputerContext = ??? //new ComputerContext with ...
	val newComputer: ComputerContext = new ComputerContext with IntelCpuContext with AsusMotherboardContext with CorsairMemoryContext



	def main(args: Array[String]) {
		println(newComputer.computer)
	}


}
