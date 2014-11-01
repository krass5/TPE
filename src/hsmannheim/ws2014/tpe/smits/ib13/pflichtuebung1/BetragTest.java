package hsmannheim.ws2014.tpe.smits.ib13.pflichtuebung1;

import static org.junit.Assert.*;
import org.junit.Test;

public class BetragTest {

	@Test
	public void testGetter() {

		Betrag a = new Betrag(12, Waehrungen.EURO);
		Betrag b = new Betrag(-21314, Waehrungen.CHF);

		assertEquals(12, a.getWert());
		assertEquals(-21314, b.getWert());
		assertEquals(Waehrungen.EURO, a.getWaehrung());
		assertEquals(Waehrungen.CHF, b.getWaehrung());

	}

	@Test
	public void testAddition() {

		Betrag a = new Betrag(10, Waehrungen.EURO);
		Betrag b = new Betrag(.10, Waehrungen.EURO);
		Betrag c = new Betrag(102, Waehrungen.EURO);

		assertEquals(new Betrag(20, Waehrungen.EURO), a.addiere(b));
		assertEquals(new Betrag(112, Waehrungen.EURO), a.addiere(c));

	}

	@Test
	public void testSubtraktion() {

		Betrag a = new Betrag(10, Waehrungen.EURO);
		Betrag b = new Betrag(.10, Waehrungen.EURO);
		Betrag c = new Betrag(102, Waehrungen.EURO);

		assertEquals(new Betrag(0, Waehrungen.EURO), a.subtrahiere(b));
		assertEquals(new Betrag(-92, Waehrungen.EURO), a.subtrahiere(c));

	}

	@Test
	public void testVorzeichen() {

		Betrag a = new Betrag(-12, Waehrungen.RUBEL);
		Betrag b = new Betrag(0, Waehrungen.DOLLAR);

		assertEquals(-1, a.getVorzeichen());
		assertEquals(1, b.getVorzeichen());
	}

	@Test
	public void testMultipliziere() {

		Betrag a = new Betrag(1200, Waehrungen.YEN);
		Betrag b = new Betrag(8000, Waehrungen.CHF);
		Betrag c = new Betrag(23.12, Waehrungen.EURO);

		assertEquals(a.multipliziere(10.00), a.multipliziere(10));
		assertEquals(new Betrag(-4000, Waehrungen.CHF), b.multipliziere(-0.5));
		assertEquals(new Betrag(0, Waehrungen.EURO), c.multipliziere(0.0));
	}

	@Test
	public void testProzent() {

		Betrag a = new Betrag(1200, Waehrungen.YEN);
		Betrag b = new Betrag(-1320, Waehrungen.CHF);

		assertEquals(new Betrag(600, Waehrungen.YEN), a.prozent(50));
		assertEquals(new Betrag(132, Waehrungen.CHF), b.prozent(-10));
	}

	@Test
	public void testPromille() {

		Betrag a = new Betrag(7800, Waehrungen.YEN);
		Betrag b = new Betrag(-1200, Waehrungen.CHF);

		assertEquals(new Betrag(78, Waehrungen.YEN), a.promille(10));
		assertEquals(new Betrag(-36, Waehrungen.CHF), b.promille(30));
	}

	@Test
	public void testVorkomma() {

		Betrag a = new Betrag(1254.59, Waehrungen.DOLLAR);
		Betrag b = new Betrag(0, Waehrungen.DOLLAR);

		assertEquals(1254, a.getVorkomma());
		assertEquals(0, b.getVorkomma());

	}

	@Test
	public void testNachkomma() {

		Betrag a = new Betrag(1254.59, Waehrungen.DOLLAR);
		Betrag b = new Betrag(0, Waehrungen.DOLLAR);

		assertEquals(59, a.getNachkomma());
		assertEquals(0, b.getNachkomma());

	}

	@Test
	public void testToString() {

		Betrag a = new Betrag(7800, Waehrungen.CHF);
		Betrag b = new Betrag(-12, Waehrungen.DOLLAR);
		Betrag c = new Betrag(0.94, Waehrungen.EURO);

		assertEquals("78,00 CHF", a.toString());
		assertEquals("-0,12 $", b.toString());
		assertEquals("0,94 €", c.toString());

	}

	@Test
	public void testGetAsDouble() {

		double epsilon = 0.00005;
		Betrag a = new Betrag(7483, Waehrungen.EURO);
		Betrag b = new Betrag(-78, Waehrungen.DOLLAR);

		assertTrue(Math.abs(74.83 - a.getAsDouble()) < epsilon);
		assertTrue(Math.abs(-0.78 - b.getAsDouble()) < epsilon);
	}

	@Test
	public void testEquals() {

		Betrag a = new Betrag(754, Waehrungen.EURO);
		Betrag b = new Betrag(754, Waehrungen.EURO);
		Betrag c = new Betrag(754, Waehrungen.CHF);

		assertTrue(a.equals(b));
		assertFalse(a.equals(c));

	}
}
