package hsmannheim.ws2014.tpe.smits.ib13.pflichtuebung1;

import static org.junit.Assert.*;

import org.junit.Test;

public class WaehrungTest {

	@Test
	public void TestUmrechnen() {

		Waehrung a = new Waehrung("€", "Euro", 1.2690);
		Waehrung b = new Waehrung("$", "US-Doller", 1.0000);
		Waehrung c = new Waehrung("¥", "Yen", 0.0091);
		Waehrung d = new Waehrung("CHF", "Schweizer Franken", 1.0509);

		assertEquals((12690), a.umrechnen(10000, b));
		assertEquals((1098901), b.umrechnen(10000, c));
		assertEquals((87), c.umrechnen(10000, d));
		assertEquals((8281), d.umrechnen(10000, a));

	}

}
