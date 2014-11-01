package hsmannheim.ws2014.tpe.smits.ib13.pflichtuebung1;

/**
 * 
 * Die <code>Betrag</code> Klasse ermöglicht den Umgang mit Geldbeträgen.
 * 
 * @author Paul Merkel (), Martin Schröder (14135079), Christian Thiel
 *         (1411940).
 * @version alpha.
 * 
 */
public class Betrag {

	private long wert;
	private Waehrung waehrung;

	/**
	 * Kontruktor der <code>Betrag</code>Klasse mit einem übergebenen <code>
	 * long</code>-Wert.
	 * 
	 * @param wert
	 *            Der Geldbetrag als <code>long</code> übergeben den das
	 *            erzeugte <code>Betrag</code>-Objekt haben soll.
	 * @param waehrung
	 *            Die Waehrung die dem erzeugten <code>Betrag</code> -Objekt
	 *            zugewiesen werden soll.
	 */
	public Betrag(long wert, Waehrung waehrung) {

		setWert(wert);
		setWaehrung(waehrung);

	}

	/**
	 * Konstruktor der <code>Betrag</code>Klasse mit einem übergebenen <code>
	 * double</code>-Wert.
	 * 
	 * @param wert
	 *            Der Geldbetrag als <code>double</code> übergeben den das
	 *            erzeugte <code>Betrag</code>-Objekt haben soll.
	 * @param waehrung
	 *            Die Waehrung die dem erzeugten <code>Betrag</code> -Objekt
	 *            zugewiesen werden soll.
	 */
	public Betrag(double wert, Waehrung waehrung) {

		this(Math.round(wert * 100), waehrung);

	}

	/**
	 * Gibt den Wert eines <code>Betrag</code>-Objektes zurück.
	 * 
	 * @return Der <code>wert</code> des <code>Betrag</code>-Objektes.
	 */
	public long getWert() {
		return wert;
	}

	/**
	 * Setzt den Wert eines <code>Betrag</code>-Objektes auf einen übergebenen
	 * <code>wert</code>.
	 * 
	 * @param wert
	 *            Der neue <code>wert</code>, den das <code>Betrag</code><
	 *            -Objekt haben soll.
	 */
	private void setWert(long wert) {
		this.wert = wert;
	}

	/**
	 * Gibt die <code>Waehrung</code> eines <code>Betrag</code>-Objektes zurück.
	 * 
	 * @return Die <code>Waehrung</code> des Objektes.
	 */
	public Waehrung getWaehrung() {
		return waehrung;
	}

	/**
	 * Setzt die <code>Waehrung</code> eines <code>Betrag</code>-Objektes auf
	 * eine übergebene <code>Waehrung</code>.
	 * 
	 * @param waehrung
	 *            Die neue <code>Waehrung</code>, die das Objekt haben soll.
	 */
	private void setWaehrung(Waehrung waehrung) {
		this.waehrung = waehrung;
	}

	/**
	 * Gibt eine <code>1</code> zurück bei positivem <code>wert</code> des
	 * Objektes und eine <code>-1</code> bei negativem <code>wert</code>.
	 * 
	 * @return <code>1</code> bei postivem Vorzeichen und <code>-1</code> bei
	 *         negativem <code>wert</code>.
	 */
	public int getVorzeichen() {

		if (wert >= 0) {
			return 1;

		} else {
			return -1;
		}
	}

	/**
	 * Addiert einen übergebenen <code>Betrag</code> auf den aktuellen
	 * <code>Betrag</code> und gibt ein neues daraus resultierendes
	 * <code>Betrag</code>-Objekt zurück.
	 * 
	 * @param andererBetrag
	 *            <code>Betrag</code> der auf den akuellen <code>Betrag</code>
	 *            addiert wird.
	 * @return Der aus der Addition resultierende <code>Betrag</code>.
	 */
	public Betrag addiere(Betrag andererBetrag) {

		Betrag ergebnis = new Betrag(this.getWert() + andererBetrag.getWert(),
				this.getWaehrung());

		return ergebnis;
	}

	/**
	 * Subtrahiert einen übergebenen <code>Betrag</code> von dem aktuellen
	 * <code>Betrag</code> und gibt ein neues daraus resultierendes
	 * <code>Betrag</code>-Objekt zurück.
	 * 
	 * @param andererBetrag
	 *            <code>Betrag</code> der von dem aktuellen <code>Betrag</code>
	 *            subtrahiert wird.
	 * @return Der aus der Subtraktion resultierende <code>Betrag</code>.
	 */
	public Betrag subtrahiere(Betrag andererBetrag) {

		Betrag ergebnis = new Betrag(this.getWert() - andererBetrag.getWert(),
				this.getWaehrung());

		return ergebnis;
	}

	/**
	 * Multipliziert einen übergebenen <code>Betrag</code> mit einem
	 * <code>double</code> <code>wert</code> mit dem aktuellen
	 * <code>Betrag</code> und gibt einen neuen daraus resultierenden
	 * <code>Betrag</code> zurück.
	 * 
	 * @param faktor
	 *            <code>Betrag</code> mit dem der aktuelle <code>Betrag</code>
	 *            multipliziert werden soll
	 * @return Der aus der Multiplikation resultierende <code>Betrag</code>
	 */
	public Betrag multipliziere(double faktor) {

		Betrag ergebnis = new Betrag((this.getWert() * faktor) / 100,
				this.getWaehrung());

		return ergebnis;
	}

	/**
	 * Multipliziert einen übergebenen <code>Betrag</code> mit einem
	 * <code>int</code> <code>wert</code> mit dem aktuellen <code>Betrag</code>
	 * und gibt einen neuen daraus resultierenden <code>Betrag</code> zurück.
	 * 
	 * @param faktor
	 *            <code>Betrag</code> mit dem der aktuelle <code>Betrag</code>
	 *            multipliziert werden soll.
	 * @return Der aus der Multiplikation resultierende <code>Betrag</code>.
	 */
	public Betrag multipliziere(int faktor) {

		return multipliziere((double) faktor);
	}

	/**
	 * Errechnet einen übergebenen Prozentwert und gibt einen
	 * <code>Betrag</code> zurück. Errechnet wird das neue <code>Betrag</code>
	 * -Objekt n dem der Parameter <code>prozent</code> durch <code>100.0</code>
	 * geteilt wird und mit der daraus resultierenden Zahl die
	 * <code>multipliziere</code>-Methode aufgerufen wird.
	 * 
	 * @param prozent
	 *            Der Prozentsatz der errechnet werden soll.
	 * @return Der aus der Multiplikation resultierende <code>Betrag</code>.
	 */
	public Betrag prozent(int prozent) {

		return multipliziere(prozent / 100.0);
	}

	/**
	 * Errechnet einen übergebenen Promillewert und gibt einen
	 * <code>Betrag</code> zurück. Errechnet wird das neue <code>Betrag</code>
	 * -Objekt in dem der Parameter <code>promille</code> durch
	 * <code>1000.0</code> geteilt wird und mit der daraus resultierenden Zahl
	 * die Methode <code>multipliziere</code> aufgerufen wird.
	 * 
	 * @param promille
	 *            Der Promillewert der errechnet werden soll.
	 * @return Der aus der Multiplikation resultierende <code>Betrag</code>.
	 */
	public Betrag promille(int promille) {

		return multipliziere(promille / 1000.0);
	}

	/**
	 * Gibt die Vorkommastellen des <code>wert</code>-Attributs des
	 * <code>Betrag</code>-Objektes (ohne Vorzeichen) zurück. Erreicht wird dies
	 * indem der <code>wert</code> des <code>Betrag</code>-Objektes durch
	 * <code>100</code> geteilt wird und anschließend mit <code>Math.abs</code>
	 * der Betrag zurückgegeben wird.
	 * 
	 * @return Die Vorkommastellen des <code>wert</code>-Attributs des
	 *         <code>Betrag</code>-Objektes.
	 */
	public long getVorkomma() {

		return Math.abs(this.getWert() / 100);
	}

	/**
	 * Gibt alle Nachkommastellen des <code>wert</code>-Attributs des
	 * <code>Betrag</code>-Objektes zurück. Erreicht wird dies in dem der
	 * <code>wert</code> des <code>Betrag</code>-Objektes modulo
	 * <code>100</code> gerechnet wird und anschließend mit
	 * <code>Math.abs</code> der Betrag zurückgegeben wird.
	 * 
	 * @return Die Nachkommastellen des <code>wert</code>-Attributs des
	 *         <code>Betrag</code>-Objektes.
	 */
	public long getNachkomma() {

		return Math.abs(this.getWert() % 100);
	}

	/**
	 * Erzeugt ein <code>String</code>-Objekt aus einem <code>Betrag</code>
	 * -Objekt. Der <code>ergebnis</code>-<code>String</code> wird mit Hilfe der
	 * Methoden <code>getVorzeichen</code>, <code>getVorkomma</code> und
	 * <code>getNachkomma</code> zusammengesetzt.
	 */
	public String toString() {

		String ergebnis = "";

		// Prüfung auf negatives Vorzeichen. Wenn die Vorzeichen-Methode -1
		// zurückgibt wird eim "-" in den ergebnis-String gesetzt.
		if (this.getVorzeichen() == -1) {
			ergebnis = "-";
		}
		// Ein Zwischenergebnis des ergebnis-Strings bis zum Komma wird
		// festgehalten da bei den Nachkommastellen Sonderfälle abgefangen
		// werden müssen.
		ergebnis = ergebnis + this.getVorkomma() + ",";

		// Sonderfall bei 1-stelliger Nachkommazahl
		if (this.getNachkomma() < 10) {

			// Eine zusätzliche "0" wird eingefügt um ein falsches Ergebnis zu
			// verhindern
			ergebnis = ergebnis + "0";

		}

		// Der ergebnis-String wird normal zurückgegeben.
		return (ergebnis + this.getNachkomma() + " " + this.waehrung
				.getKuerzel());

	}

	/**
	 * Gibt den <code>wert</code> eines <code>Betrag</code> als
	 * <code>double</code>-Zahl zurück. Der <code>wert</code> wird durch
	 * <code>100.0</code> geteilt.
	 * 
	 * @return Das <code>wert</code>-Attribut als <code>double</code>
	 */
	public double getAsDouble() {

		return this.getWert() / 100.0;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)

			return true;

		if (obj == null)

			return false;

		if (getClass() != obj.getClass())

			return false;

		Betrag other = (Betrag) obj;

		if (waehrung == null) {

			if (other.waehrung != null)

				return false;

		} else if (!waehrung.equals(other.waehrung))

			return false;

		if (wert != other.wert)

			return false;

		return true;
	}
}
