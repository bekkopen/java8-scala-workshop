package no.bekk.java.exercises;

import org.junit.Test;

import static no.bekk.java.exercises.Ex7_Computer.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Ex7_ComputerTest {

	@Test
	public void testComputer1WithAsusMotherboardIntelCpuCorsairMemory() {
		Computer computer = computer1();
		assertThat(computer.motherboard.manifacturer, is("Asus"));
		assertThat(computer.cpu.manifacturer, is("Intel"));
		assertThat(computer.cpu.clockSpeed, is(3.5));
		assertThat(computer.memory.manifacturer, is("Corsair"));
		assertThat(computer.memory.ram, is(16));
	}

	@Test
	public void testComputer1WithMsiMotherboardAmdCpuKingstonMemory() {
		Computer computer = computer2();
		assertThat(computer.motherboard.manifacturer, is("MSI"));
		assertThat(computer.cpu.manifacturer, is("AMD"));
		assertThat(computer.cpu.clockSpeed, is(2.8));
		assertThat(computer.memory.manifacturer, is("Kingston"));
		assertThat(computer.memory.ram, is(8));
	}
}
