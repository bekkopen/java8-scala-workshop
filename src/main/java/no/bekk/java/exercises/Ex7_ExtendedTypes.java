package no.bekk.java.exercises;

import no.bekk.java.model.Car;

import java.util.List;

interface Competing<T> {
	T get();
	Competing<T> competeWith(Competing<T> other);
}
public class Ex7_ExtendedTypes {
	static public <T> T compete(List<Competing<T>> competitors) {
		return competitors.stream().reduce((x, y) -> x.competeWith(y)).get().get(); // TODO: Remove for excercise
	}
}

// TODO: Remove for excercise
class CarAdapter implements Competing<Car> {
	private Car car;

	CarAdapter(Car car) {
		this.car = car;
	}

	public Car get() {return car;}

	public Competing<Car> competeWith(Competing<Car> other) {
		return car.hp > other.get().hp ? this : other;
	}
}