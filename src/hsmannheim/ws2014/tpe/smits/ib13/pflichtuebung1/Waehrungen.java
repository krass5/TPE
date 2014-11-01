package hsmannheim.ws2014.tpe.smits.ib13.pflichtuebung1;

/**
 * Klasse zur Verwaltung vorgefertigter <code>Waehrungs</code>-Objekte,
 * einschließlich US-Dollar, Euro, Yen, Rubel und Schweizer Franken.
 * 
 * @author Martin Schröder (1413507), Christian Thiel (1411940), Paul Merkel
 *         (1414329)
 */
public class Waehrungen {

	final static Waehrung DOLLAR = new Waehrung("$", "US-Dollar", 1.0000);
	final static Waehrung EURO = new Waehrung("€", "Euro", 1.2690);
	final static Waehrung YEN = new Waehrung("¥", "Yen", 0.0091);
	final static Waehrung RUBEL = new Waehrung("RUB", "Rubel", 0.0255);
	final static Waehrung CHF = 
							new Waehrung("CHF", "Schweizer Franken", 1.0509);

}
