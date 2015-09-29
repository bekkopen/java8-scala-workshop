package no.bekk.java.examples;

import java.util.Optional;

public class OptionalExample {

	static class Java8 {

		public static String getNameOfOwner(House house) {
			return Optional.of(house).map(House::getOwner).map(Person::getName).orElseGet(() -> "Doesn't exist");
		}

	}

	static class Java7 {

		public static String getNameOfOwner(House house) {
			if (house != null && house.owner != null && house.owner.name != null) {
				return house.owner.name;
			} else {
				return "Doesn't exist";
			}
		}
	}

}

class Person {
	public final String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class House {
	public final Person owner;

	public House(Person owner) {
		this.owner = owner;
	}

	public Person getOwner() {
		return owner;
	}
}