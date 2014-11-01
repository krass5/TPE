package hsmannheim.ws2014.tpe.smits.ib13.pflichtuebung1;

/**
 * Klasse zur Verwaltung eines Währungsobjekts.
 * 
 * @author Martin Schröder (1413507), Paul Merkel (1414329), Christien Thiel
 *         (1411940)
 * 
 */

public class Waehrung {

	private String kuerzel;
	private String name;
	private double kurs;

	/**
	 * Konstruktor zur Erstellung eines <code>Waehrung</code>-Objekts, übergeben
	 * wird der Name der Währung, das Kürzel und der Wechsel-Kurs zum US-Dollar.
	 * 
	 * @param kuerzel
	 *            Kürzel der Währung.
	 * @param name
	 *            Name der Währung.
	 * @param kurs
	 *            Wechselkurs zum US-Dollar.
	 */
	public Waehrung(String kuerzel, String name, double kurs) {

		setKuerzel(kuerzel);
		setName(name);
		setKurs(kurs);
	}

	/**
	 * Gibt das <code>kuerzel</code> der <code>Waehrung</code> zurück.
	 * 
	 * @return das <code>kuerzel</code> der <code>Waehrung</code>
	 */
	public String getKuerzel() {
		return kuerzel;
	}

	/**
	 * Setzt das <code>kuerzel</code> des <code>Waehrung</code>-Objekts auf den
	 * übergebenen String
	 * 
	 * @param kuerzel
	 *            das übergebene Kürzel
	 */
	private void setKuerzel(String kuerzel) {
		this.kuerzel = kuerzel;
	}

	/**
	 * Gibt den <code>namen</code> der <code>Waehrung</code> zurück.
	 * 
	 * @return der <code>name</code> der <code>Waehrung</code>
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setzt den <code>namen</code> des <code>Waehrung</code>-Objekts auf den
	 * übergebenen String
	 * 
	 * @param name
	 *            der übergebene Name
	 */
	private void setName(String name) {
		this.name = name;
	}

	/**
	 * Gibt den Dollar-Wechsel<code>kurs</code> der <code>Waehrung</code>
	 * zurück.
	 * 
	 * @return der Dollar-Wechsel<code>kurs</code> der <code>Waehrung</code>
	 */
	public double getKurs() {
		return kurs;
	}

	/**
	 * Setzt den Dollar-Wechsel<code>kurs</code> des <code>Waehrung</code>
	 * -Objekts auf den übergebenen <code>double</code> -Wert.
	 * 
	 * @param kurs
	 *            der übergebene Wechselkurs.
	 */
	private void setKurs(double kurs) {
		this.kurs = kurs;
	}

	/**
	 * Methode, die einen übergebenen Betrag in die übergebene Fremdwährung
	 * umrechnet.
	 * 
	 * @param betrag
	 *            der Betrag der umgerechnet werden soll.
	 * @param zielwaehrung
	 *            Waehrung in die er umgerechnet wird.
	 * @return gibt den umgerechneten Wert als <code>long</code>-Wert zurück.
	 */
	public long umrechnen(long betrag, Waehrung zielwaehrung) {

		double wert = betrag * this.getKurs();

		wert = wert * (1 / zielwaehrung.getKurs());

		// Math.round() gibt long zurück -> Kein Cast

		return Math.round(wert);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kuerzel == null) ? 0 : kuerzel.hashCode());
		long temp;
		temp = Double.doubleToLongBits(kurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Waehrung other = (Waehrung) obj;
		if (kuerzel == null) {
			if (other.kuerzel != null)
				return false;
		} else if (!kuerzel.equals(other.kuerzel))
			return false;
		if (Double.doubleToLongBits(kurs) != Double
				.doubleToLongBits(other.kurs))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "" + name + " [" + kuerzel + "] 1 $ = " + kurs + " " + kuerzel;
	}

}
