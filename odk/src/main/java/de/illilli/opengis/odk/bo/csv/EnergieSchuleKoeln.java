package de.illilli.opengis.odk.bo.csv;

/**
 * <ul>
 * <li>WE</li>
 * <li>Objektbezeichnung</li>
 * <li>Adresse</li>
 * <li>Netto Grundfläche 2012 [m²]</li>
 * <li>Heizung: Energieträger</li>
 * <li>Heizung: EKW 2012 [kWh/m²a]</li>
 * <li>Heizung: EKW Differenz zum Vorjahr in Prozent</li>
 * <li>Heizung: Differenz zum Vergleichswert in Prozent</li>
 * <li>Strom: EKW 2012 [kWh/m²a]</li>
 * <li>Strom: Differenz zum Vorjahr in Prozent</li>
 * <li>Strom: Differenz zum Vergleichswert in Prozent</li>
 * <li>Wasser: EKW 2012 [l/m²]</li>
 * <li>Wasser: EKW Wasser Differenz Vorjahr in Prozent</li>
 * <li>Wasser: Differenz zum Vergleichswert in Prozent</li>
 * <li>Bemerkung</li>
 * </ul>
 * 
 * @author wolfram
 *
 */
public class EnergieSchuleKoeln {

	public enum Head {

		we("WE"), //
		objektbezeichnung("Objektbezeichnung"), //
		adresse("Adresse"), //
		grundflaeche("Netto Grundfläche 2012 [m²]"), //
		heizung_energietraeger("Heizung: Energieträger"), //
		heizung_ekw("Heizung: EKW 2012 [kWh/m²a]"), //
		heizung_ekw_differenz_vorjahr(
				"Heizung: EKW Differenz zum Vorjahr in Prozent"), //
		heizung_ekw_differenz_vergleichswert(
				"Heizung: Differenz zum Vergleichswert in Prozent"), //
		strom_ekw("Strom: EKW 2012 [kWh/m²a]"), //
		strom_differenz_vorjahr("Strom: Differenz zum Vorjahr in Prozent"), //
		strom_differenz_vergleichswert(
				"Strom: Differenz zum Vergleichswert in Prozent"), //
		wasser_ekw("Wasser: EKW 2012 [l/m²]"), //
		wasser_ekw_differenz_vorjahr(
				"Wasser: EKW Wasser Differenz Vorjahr in Prozent"), //
		wasser_differenz_vergleichswert(
				"Wasser: Differenz zum Vergleichswert in Prozent"), //
		bemerkung("Bemerkung");

		private final String key;

		Head(String key) {
			this.key = key;
		}

		public String key() {
			return key;
		}
	}

	private int we;
	private String objektbezeichnung;
	private String adresse;
	private double grundflaeche;
	private String heizung_energietraeger;
	private double heizung_ekw;
	private double heizung_ekw_differenz_vorjahr;
	private double heizung_ekw_differenz_vergleichswert;
	private double strom_ekw;
	private double strom_differenz_vorjahr;
	private double strom_differenz_vergleichswert;
	private double wasser_ekw;
	private double wasser_ekw_differenz_vorjahr;
	private double wasser_differenz_vergleichswert;
	private String bemerkung;

	public int getWe() {
		return we;
	}

	public void setWe(int we) {
		this.we = we;
	}

	public String getObjektbezeichnung() {
		return objektbezeichnung;
	}

	public void setObjektbezeichnung(String objektbezeichnung) {
		this.objektbezeichnung = objektbezeichnung;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getGrundflaeche() {
		return grundflaeche;
	}

	public void setGrundflaeche(double grundflaeche) {
		this.grundflaeche = grundflaeche;
	}

	public String getHeizung_energietraeger() {
		return heizung_energietraeger;
	}

	public void setHeizung_energietraeger(String heizung_energietraeger) {
		this.heizung_energietraeger = heizung_energietraeger;
	}

	public double getHeizung_ekw() {
		return heizung_ekw;
	}

	public void setHeizung_ekw(double heizung_ekw) {
		this.heizung_ekw = heizung_ekw;
	}

	public double getHeizung_ekw_differenz_vorjahr() {
		return heizung_ekw_differenz_vorjahr;
	}

	public void setHeizung_ekw_differenz_vorjahr(
			double heizung_ekw_differenz_vorjahr) {
		this.heizung_ekw_differenz_vorjahr = heizung_ekw_differenz_vorjahr;
	}

	public double getHeizung_ekw_differenz_vergleichswert() {
		return heizung_ekw_differenz_vergleichswert;
	}

	public void setHeizung_ekw_differenz_vergleichswert(
			double heizung_ekw_differenz_vergleichswert) {
		this.heizung_ekw_differenz_vergleichswert = heizung_ekw_differenz_vergleichswert;
	}

	public double getStrom_ekw() {
		return strom_ekw;
	}

	public void setStrom_ekw(double strom_ekw) {
		this.strom_ekw = strom_ekw;
	}

	public double getStrom_differenz_vorjahr() {
		return strom_differenz_vorjahr;
	}

	public void setStrom_differenz_vorjahr(double strom_differenz_vorjahr) {
		this.strom_differenz_vorjahr = strom_differenz_vorjahr;
	}

	public double getStrom_differenz_vergleichswert() {
		return strom_differenz_vergleichswert;
	}

	public void setStrom_differenz_vergleichswert(
			double strom_differenz_vergleichswert) {
		this.strom_differenz_vergleichswert = strom_differenz_vergleichswert;
	}

	public double getWasser_ekw() {
		return wasser_ekw;
	}

	public void setWasser_ekw(double wasser_ekw) {
		this.wasser_ekw = wasser_ekw;
	}

	public double getWasser_ekw_differenz_vorjahr() {
		return wasser_ekw_differenz_vorjahr;
	}

	public void setWasser_ekw_differenz_vorjahr(
			double wasser_ekw_differenz_vorjahr) {
		this.wasser_ekw_differenz_vorjahr = wasser_ekw_differenz_vorjahr;
	}

	public double getWasser_differenz_vergleichswert() {
		return wasser_differenz_vergleichswert;
	}

	public void setWasser_differenz_vergleichswert(
			double wasser_differenz_vergleichswert) {
		this.wasser_differenz_vergleichswert = wasser_differenz_vergleichswert;
	}

	public String getBemerkung() {
		return bemerkung;
	}

	public void setBemerkung(String bemerkung) {
		this.bemerkung = bemerkung;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result
				+ ((bemerkung == null) ? 0 : bemerkung.hashCode());
		long temp;
		temp = Double.doubleToLongBits(grundflaeche);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(heizung_ekw);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(heizung_ekw_differenz_vergleichswert);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(heizung_ekw_differenz_vorjahr);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime
				* result
				+ ((heizung_energietraeger == null) ? 0
						: heizung_energietraeger.hashCode());
		result = prime
				* result
				+ ((objektbezeichnung == null) ? 0 : objektbezeichnung
						.hashCode());
		temp = Double.doubleToLongBits(strom_differenz_vergleichswert);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(strom_differenz_vorjahr);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(strom_ekw);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(wasser_differenz_vergleichswert);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(wasser_ekw);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(wasser_ekw_differenz_vorjahr);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + we;
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
		EnergieSchuleKoeln other = (EnergieSchuleKoeln) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (bemerkung == null) {
			if (other.bemerkung != null)
				return false;
		} else if (!bemerkung.equals(other.bemerkung))
			return false;
		if (Double.doubleToLongBits(grundflaeche) != Double
				.doubleToLongBits(other.grundflaeche))
			return false;
		if (Double.doubleToLongBits(heizung_ekw) != Double
				.doubleToLongBits(other.heizung_ekw))
			return false;
		if (Double.doubleToLongBits(heizung_ekw_differenz_vergleichswert) != Double
				.doubleToLongBits(other.heizung_ekw_differenz_vergleichswert))
			return false;
		if (Double.doubleToLongBits(heizung_ekw_differenz_vorjahr) != Double
				.doubleToLongBits(other.heizung_ekw_differenz_vorjahr))
			return false;
		if (heizung_energietraeger == null) {
			if (other.heizung_energietraeger != null)
				return false;
		} else if (!heizung_energietraeger.equals(other.heizung_energietraeger))
			return false;
		if (objektbezeichnung == null) {
			if (other.objektbezeichnung != null)
				return false;
		} else if (!objektbezeichnung.equals(other.objektbezeichnung))
			return false;
		if (Double.doubleToLongBits(strom_differenz_vergleichswert) != Double
				.doubleToLongBits(other.strom_differenz_vergleichswert))
			return false;
		if (Double.doubleToLongBits(strom_differenz_vorjahr) != Double
				.doubleToLongBits(other.strom_differenz_vorjahr))
			return false;
		if (Double.doubleToLongBits(strom_ekw) != Double
				.doubleToLongBits(other.strom_ekw))
			return false;
		if (Double.doubleToLongBits(wasser_differenz_vergleichswert) != Double
				.doubleToLongBits(other.wasser_differenz_vergleichswert))
			return false;
		if (Double.doubleToLongBits(wasser_ekw) != Double
				.doubleToLongBits(other.wasser_ekw))
			return false;
		if (Double.doubleToLongBits(wasser_ekw_differenz_vorjahr) != Double
				.doubleToLongBits(other.wasser_ekw_differenz_vorjahr))
			return false;
		if (we != other.we)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EnergieSchulenKoeln [we=" + we + ", objektbezeichnung="
				+ objektbezeichnung + ", adresse=" + adresse
				+ ", grundflaeche=" + grundflaeche
				+ ", heizung_energietraeger=" + heizung_energietraeger
				+ ", heizung_ekw=" + heizung_ekw
				+ ", heizung_ekw_differenz_vorjahr="
				+ heizung_ekw_differenz_vorjahr
				+ ", heizung_ekw_differenz_vergleichswert="
				+ heizung_ekw_differenz_vergleichswert + ", strom_ekw="
				+ strom_ekw + ", strom_differenz_vorjahr="
				+ strom_differenz_vorjahr + ", strom_differenz_vergleichswert="
				+ strom_differenz_vergleichswert + ", wasser_ekw=" + wasser_ekw
				+ ", wasser_ekw_differenz_vorjahr="
				+ wasser_ekw_differenz_vorjahr
				+ ", wasser_differenz_vergleichswert="
				+ wasser_differenz_vergleichswert + ", bemerkung=" + bemerkung
				+ "]";
	}

}
