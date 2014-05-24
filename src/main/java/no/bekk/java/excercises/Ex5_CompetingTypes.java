package no.bekk.java.excercises;

import no.bekk.java.model.Car;
import no.bekk.java.model.SumoWrestler;

import java.util.List;

interface Competing<T> {
	T get();
	Competing<T> competeWith(Competing<T> other);
}
public class Ex5_CompetingTypes {
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

// TODO: Remove for excercise, necessary with this example? Almost identical to CarAdapter...
class SumoWrestlerAdapter implements Competing<SumoWrestler> {
	private SumoWrestler sumoWrestler;

	SumoWrestlerAdapter(SumoWrestler sumoWrestler) {
		this.sumoWrestler = sumoWrestler;
	}

	public SumoWrestler get() {return sumoWrestler;}

	public Competing<SumoWrestler> competeWith(Competing<SumoWrestler> other) {
		return sumoWrestler.weight > other.get().weight ? this : other;
	}
}