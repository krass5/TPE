package hsmannheim.ws2014.tpe.smits.ib13.pflichtuebung1;

/**
 * Die <code>Konto</code>-Klasse zur Verwaltung eines Bankkontos.
 * 
 * @author Paul Merkel (1414329), Martin Schröder (1413507), Christian Thiel
 *         (1411940).
 * 
 */
public class Konto {

	private Waehrung waehrung;
	private String inhaber;
	private Betrag[] kontohistorie = new Betrag[100];

	/**
	 * Kontruktor der <code>Konto</code>-Klasse mit übergebenem
	 * <code>Inhaber</code> und einer dazugehörigen <code>Waehrung</code>.
	 * 
	 * @param inhaber
	 *            Name des Kontoinhabers.
	 * @param waehrung
	 *            Die Währung des Kontos.
	 */
	public Konto(String inhaber, Waehrung waehrung) {

		this.setInhaber(inhaber);
		this.setWaehrung(waehrung);

	}

	/**
	 * Gibt die <code>Waehrung</code> des <code>Konto</code>-Objektes zurück.
	 * 
	 * @return Die <code>Waehrung</code> des <code>Konto</code>-Objektes.
	 */
	public Waehrung getWaehrung() {
		return waehrung;
	}

	/**
	 * Setzt die <code>Waehrung</code> des <code>Konto</code> auf eine
	 * übergebene <code>Waehrung</code>.
	 * 
	 * @param waehrung
	 *            Die <code>Waehrung</code> die das <code>Konto</code> bekommen
	 *            soll.
	 */
	private void setWaehrung(Waehrung waehrung) {
		this.waehrung = waehrung;
	}

	/**
	 * Gibt den <code>Inhaber</code> des <code>Konto</code>-Objektes zurück.
	 * 
	 * @return Den <code>Inhaber</code> des <code>Konto</code>.
	 */
	public String getInhaber() {
		return inhaber;
	}

	/**
	 * Ändert den <code>Inhaber</code> eines <code>Konto</code>s auf einen
	 * übergebenen <code>Inhaber</code>
	 * 
	 * @param inhaber
	 */
	private void setInhaber(String inhaber) {
		this.inhaber = inhaber;
	}

	/**
	 * Gibt ein <code>Betrag</code>-<code>Array</code> zurück in dem alle
	 * Buchungen gespeichert werden. Das <code>Array</code> hat eine Reichweite
	 * von <code>1000</code>.
	 * 
	 * @return <code>Betrag</code>-<code>Array</code> mit einer Richweite von
	 *         <code>1000</code>.
	 */
	public Betrag[] getKontohistorie() {
		return kontohistorie;
	}

	/**
	 * Bucht das übergebene <code>Betrag</code>-Objekt auf das Konto. Falls die
	 * Kontohistorie voll ist, wird nichts getan.
	 * 
	 * @param buchung
	 *            <code>Betrag</code>, der gebucht werden soll.
	 */
	public void buchen(Betrag buchung) {

		int buchungsPosten = 0;

		// Sonderfall, falls der übergebene Betrag in einer fremden Währung
		// gebucht wird
		if (!buchung.getWaehrung().equals(this.getWaehrung())) {

			// Umrechnung des Fremdwährungsbetrags in Eigenwährung
			buchung = new Betrag(buchung.getWaehrung().umrechnen(
					buchung.getWert(), this.getWaehrung()), this.getWaehrung());
		}

		// Nächste freie Stelle in der Kontohistorie wird gesucht
		while ((this.getKontohistorie()[buchungsPosten] != null)
				&& (buchungsPosten < this.getKontohistorie().length)) {

			buchungsPosten++;
		}

		// Falls das Array nicht voll ist
		if (buchungsPosten != this.getKontohistorie().length) {

			this.getKontohistorie()[buchungsPosten] = buchung;
		}
	}

	/**
	 * Errechnet das Saldo des <code>Kontos</code> und gibt es als neues
	 * <code>Betrags</code>-Objekt zurück.
	 * 
	 * @return das Saldo des Kontos als <code>Betrags</code>-Objekt
	 */
	public Betrag saldo() {

		long saldo = 0;

		// Durchlaufen des Kontohistorie-Arrays
		for (int i = 0; i < this.getKontohistorie().length; i++) {

			if (this.getKontohistorie()[i] != null) {

				// Aufsummierung aller Beträge des Kontos
				saldo = saldo + this.getKontohistorie()[i].getWert();
			}
		}

		// Rückgabe des neuen Betrag-Objekt, der als Wert das Saldo des Kontos
		// hat
		return new Betrag(saldo, this.getWaehrung());
	}

	/**
	 * Berechnet einen Promillewert des Saldos und bucht diesen als Gebühr
	 * beziehungsweise Schuldzins auf das <code>Konto</code>.
	 * 
	 * @param promille
	 *            Promillesatz, der als Gebühr gebucht werden soll.
	 */
	public void gebuehren(int promille) {

		// Betragsobjekt mit dem gewünschten Promillesatz des Saldos als Wert
		Betrag gebuehren = this.saldo().promille(promille);

		// Falls der Promillesatz positiv ist:
		if (gebuehren.getVorzeichen() == 1) {

			// Umwandlung in einen negativen Betrag
			gebuehren = gebuehren.multipliziere(-1);

		}

		// Buchen der Gebühren (bzw. des Zinses)
		this.buchen(gebuehren);
	}

	/**
	 * Erzeugt einen Kontoauszug der Buchungshistorie als String, der den
	 * Kontoinhaber, die Kontowährung, die einzelnen Buchungsposten und das
	 * Saldo beinhaltet.
	 * 
	 * @return Kontoauszug als String
	 */
	public String toString() {

		String ergebnis = "Kontoinhaber: " + this.getInhaber() + "\n"
				+ "Währung: " + this.getWaehrung().getName() + "\n"
				+ "--------- \n";

		for (int i = 0; i < this.getKontohistorie().length; i++) {

			if (this.getKontohistorie()[i] != null) {

				ergebnis += this.getKontohistorie()[i].toString() + "\n";

			}
		}

		ergebnis = ergebnis + "--------- \n" + "Saldo: "
				+ this.saldo().toString();

		return ergebnis;
	}
}
