package no.bekk.java.model;

public class Car {
	public final String brand;
	public final Double price;
	public final Double hp;

	public Car(String brand, Double price, Double hp) {
		this.brand = brand;
		this.price = price;
		this.hp = hp;
	}

	public String getBrand() {
		return brand;
	}

	public Double getPrice() {
		return price;
	}

	public Double getHp() {
		return hp;
	}
}
