package no.bekk.java.model;

public class SumoWrestler {
	public final String name;
	public final Double weight;

	public SumoWrestler(String name, Double weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public Double getWeight() {
		return weight;
	}
}
