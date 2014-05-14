package no.bekk.java.examples;

public class Car {
    private String brand;
    private Double price;

    public Car(String brand, Double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public Double getPrice() {
        return price;
    }
}
