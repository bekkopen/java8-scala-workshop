package no.bekk.java.excercises;

import junit.framework.TestCase;
import no.bekk.java.model.Car;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static java.util.Arrays.asList;

public class CompetingTypesTest extends TestCase {

	@Test
	public void testing() {
		Car audi = new Car("Audi", 1_293_999.0, 233.6);
		Car opel = new Car("Opel", 9_122_920.0, 187.8);
		Car bmw = new Car("BMW", 1_322_766.0, 209.2);

		Car winner = CompetingTypes.compete(asList(new CarAdapter(audi), new CarAdapter(opel), new CarAdapter(bmw)));
		assertThat(winner, is(audi));
	}
}
