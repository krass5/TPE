package hsmannheim.ws2014.tpe.smits.ib13.pflichtuebung1;

import static org.junit.Assert.*;
import org.junit.Test;

public class KontoTest {

	@Test
	public void testGetter() {

		Konto a = new Konto("Peter Lustig", Waehrungen.CHF);
		Konto b = new Konto("Max Mustermann", Waehrungen.YEN);

		assertEquals("Peter Lustig", a.getInhaber());
		assertEquals("Max Mustermann", b.getInhaber());
		assertEquals(Waehrungen.CHF, a.getWaehrung());
		assertEquals(Waehrungen.YEN, b.getWaehrung());

	}

	@Test
	public void testBuchen() {

		Konto a = new Konto("Peter Lustig", Waehrungen.EURO);
		Betrag b1 = new Betrag(140015, Waehrungen.EURO);
		Betrag b2 = new Betrag(1000, Waehrungen.DOLLAR);

		a.buchen(b1);
		a.buchen(b2);

		assertTrue(new Betrag(788, Waehrungen.EURO)
				.equals(a.getKontohistorie()[1]));
		assertTrue(b1.equals(a.getKontohistorie()[0]));

	}

	@Test
	public void testSaldo() {

		Konto a = new Konto("Peter Lustig", Waehrungen.EURO);
		Betrag b1 = new Betrag(140015, Waehrungen.EURO);
		Betrag b2 = new Betrag(1000, Waehrungen.DOLLAR);
		Betrag b3 = new Betrag(-2000, Waehrungen.EURO);

		a.buchen(b3);
		a.buchen(b2);
		a.buchen(b1);

		assertEquals(new Betrag(138803, Waehrungen.EURO), a.saldo());
	}

	@Test
	public void testGebuehren() {

		Konto k1 = new Konto("Peter Lustig", Waehrungen.EURO);
		Konto k2 = new Konto("Max Mustermann", Waehrungen.EURO);
		Betrag b1 = new Betrag(9000, Waehrungen.EURO);
		Betrag b2 = new Betrag(-9000, Waehrungen.EURO);

		k1.buchen(b1);
		k2.buchen(b2);

		k1.gebuehren(10);
		k2.gebuehren(10);

		assertEquals(new Betrag(8910, Waehrungen.EURO), k1.saldo());
		assertEquals(new Betrag(-9090, Waehrungen.EURO), k2.saldo());
		assertEquals(new Betrag(-90, Waehrungen.EURO), k1.getKontohistorie()[1]);
		assertEquals(new Betrag(-90, Waehrungen.EURO), k2.getKontohistorie()[1]);

	}

	@Test
	public void testToString() {

		Konto k1 = new Konto("Peter Lustig", Waehrungen.EURO);
		Betrag b1 = new Betrag(9000, Waehrungen.EURO);
		Betrag b2 = new Betrag(-6000, Waehrungen.EURO);
		Betrag b3 = new Betrag(1000, Waehrungen.DOLLAR);
		Betrag b4 = new Betrag(-24.37, Waehrungen.EURO);

		k1.buchen(b1);
		k1.buchen(b2);
		k1.buchen(b3);
		k1.buchen(b4);
		k1.gebuehren(10);

		System.out.println(k1.toString());

	}

}
