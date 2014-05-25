package no.bekk.java.exercises;

import no.bekk.java.model.Car;
import no.bekk.java.model.SumoWrestler;

import java.util.List;

import static no.bekk.java.util.Utils.implementThis;

interface Competing<T> {
	T get();
	Competing<T> competeWith(Competing<T> other);
}
public class Ex5_CompetingTypes {
	static public <T> T compete(List<Competing<T>> competitors) {
		return implementThis();
	}
}

class CarAdapter implements Competing<Car> {
	private Car car;

	CarAdapter(Car car) {
		this.car = car;
	}

	public Car get() {
		return implementThis();
	}

	public Competing<Car> competeWith(Competing<Car> other) {
		return implementThis();
	}
}

class SumoWrestlerAdapter implements Competing<SumoWrestler> {
	private SumoWrestler sumoWrestler;

	SumoWrestlerAdapter(SumoWrestler sumoWrestler) {
		this.sumoWrestler = sumoWrestler;
	}

	public SumoWrestler get() {
		return implementThis();
	}

	public Competing<SumoWrestler> competeWith(Competing<SumoWrestler> other) {
		return implementThis();
	}
}