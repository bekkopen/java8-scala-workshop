package no.bekk.java.exercises;

import no.bekk.java.model.Car;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Ex5_CompetingTypesTest {

	@Test
	public void testCompetingCarsUsingAdapter() {
		Car audi = new Car("Audi", 1_293_999.0, 233.6);
		Car opel = new Car("Opel", 9_122_920.0, 187.8);
		Car bmw = new Car("BMW", 1_322_766.0, 209.2);

		Car winner = Ex5_CompetingTypes.compete(asList(new CarAdapter(audi), new CarAdapter(opel), new CarAdapter(bmw)));
		assertThat("The winner should be the car with most hp", winner, is(audi));
	}
}
