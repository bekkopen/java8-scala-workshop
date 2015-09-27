package no.bekk.java.exercises;

public class Ex6_Computer {

	static Computer computer1() {
		// A computer with Intel CPU, Asus motherboard, and Corsair memory
		class Computer1Context implements ComputerContext, IntelCpuContext, AsusMotherboardContext, CorsairMemoryContext {}
		return new Computer1Context().getComputer();
	}

	static Computer computer2() {
		// A computer with AMD CPU, MSI motherboard and Kingston memory
		class Computer2Context implements ComputerContext, AmdCpuContext, MsiMotherboardContext, KingstonMemoryContext {}
		return new Computer2Context().getComputer();
	}
}

interface CpuContext {
	Cpu getCpu();
}

interface MemoryContext {
	Memory getMemory();
}

interface MotherboardContext {
	Motherboard getMotherboard();
}

interface ComputerContext extends CpuContext, MemoryContext, MotherboardContext {

	default Computer getComputer() {
		return new Computer(getMotherboard(), getCpu(), getMemory());
	}
}

/**
 * Motherboard contexts
 */

interface AsusMotherboardContext extends MotherboardContext {
	@Override
	default Motherboard getMotherboard() {
		return new Motherboard("Asus");
	}
}

interface MsiMotherboardContext extends MotherboardContext {
	@Override
	default Motherboard getMotherboard() {
		return new Motherboard("MSI");
	}
}

/**
 * CPU contexts
 */

interface IntelCpuContext extends CpuContext {
	@Override
	default Cpu getCpu() {
		return new Cpu("Intel", 3.5);
	}
}

interface AmdCpuContext extends CpuContext {
	@Override
	default Cpu getCpu() {
		return new Cpu("AMD", 2.8);
	}
}

/**
 * Memory contexts
 */

interface CorsairMemoryContext extends MemoryContext {
	@Override
	default Memory getMemory() {
		return new Memory("Corsair", 16);
	}
}

interface KingstonMemoryContext extends MemoryContext {
	@Override
	default Memory getMemory() {
		return new Memory("Kingston", 8);
	}
}

/**
 * Classes
 */

interface ComputerComponent {
	String getManifacturer();
}

class Cpu implements ComputerComponent {
	public final String manifacturer;
	public final Double clockSpeed;

	public Cpu(String manifacturer, Double clockSpeed) {
		this.manifacturer = manifacturer;
		this.clockSpeed = clockSpeed;
	}

	public String getManifacturer() {
		return manifacturer;
	}
}

class Memory implements ComputerComponent {
	public final String manifacturer;
	public final Integer ram;

	public Memory(String manifacturer, Integer ram) {
		this.manifacturer = manifacturer;
		this.ram = ram;
	}

	public String getManifacturer() {
		return manifacturer;
	}
}

class Motherboard implements ComputerComponent {
	public final String manifacturer;

	public Motherboard(String manifacturer) {
		this.manifacturer = manifacturer;
	}

	public String getManifacturer() {
		return manifacturer;
	}
}

class Computer {
	public final Motherboard motherboard;
	public final Cpu cpu;
	public final Memory memory;

	public Computer(Motherboard motherboard, Cpu cpu, Memory memory) {
		this.motherboard = motherboard;
		this.cpu = cpu;
		this.memory = memory;
	}
}