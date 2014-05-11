package no.bekk.java.examples;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExampleTest extends TestCase {

    class Car {
        private String brand;
        private int year;

        public Car(String brand, int year) {
            this.brand = brand;
            this.year = year;
        }

        @Override
        public String toString() {
            return String.format("Car(%s, %s)", brand, year);
        }
    }

    @Test
    public void testDoubleNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        MyList<Car> cars = new MyArrayList<Car>();
        cars.add(new Car("Audi", 2000));
        cars.add(new Car("BMW", 2009));
        System.out.println(cars.toString());
        System.out.println(cars.lenghts());
        System.out.println((new Car("Audi", 2000)));
        List<Integer> doubled = Example.doubleNumbers(numbers);
        assertThat("Should double all values in a list", doubled, is(Arrays.asList(2, 4, 6)));
    }
}
