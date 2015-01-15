package de.illilli.opengis.odk.bo.csv;

/**
 * <ul>
 * <li>Nr.</li>
 * <li>Stadtteil</li>
 * <li>Schüler/-innen an allgemeinbildenden Schulen</li>
 * <li>darunter Grundschule</li>
 * <li>darunter Hauptschule</li>
 * <li>darunter Realschule</li>
 * <li>darunter Gymnasium</li>
 * <li>darunter Gesamtschule</li>
 * <li>darunter Förderschule</li>
 * </ul>
 * 
 * @author wolfram
 *
 */
public class SchuelerImStadtteil {

	public enum Head {

		nr("Nr."), //
		stadtteil("Stadtteil"), //
		allgemeinbildende_schulen("Allgemeinbildende Schulen"), //
		grundschule("Grundschule"), //
		hauptschule("Hauptschule"), //
		realschule("Realschule"), //
		gymnasium("Gymnasium"), //
		gesamtschule("Gesamtschule"), //
		foerderschule("Förderschule");

		private final String key;

		Head(String key) {
			this.key = key;
		}

		public String key() {
			return key;
		}
	}

	private int nr;
	private String stadtteil;
	private int allgemeinbildende_schulen;
	private int grundschule;
	private int hauptschule;
	private int realschule;
	private int gymnasium;
	private int gesamtschule;
	private int foerderschule;

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getStadtteil() {
		return stadtteil;
	}

	public void setStadtteil(String stadtteil) {
		this.stadtteil = stadtteil;
	}

	public int getAllgemeinbildende_schulen() {
		return allgemeinbildende_schulen;
	}

	public void setAllgemeinbildende_schulen(int allgemeinbildende_schulen) {
		this.allgemeinbildende_schulen = allgemeinbildende_schulen;
	}

	public int getGrundschule() {
		return grundschule;
	}

	public void setGrundschule(int grundschule) {
		this.grundschule = grundschule;
	}

	public int getHauptschule() {
		return hauptschule;
	}

	public void setHauptschule(int hauptschule) {
		this.hauptschule = hauptschule;
	}

	public int getRealschule() {
		return realschule;
	}

	public void setRealschule(int realschule) {
		this.realschule = realschule;
	}

	public int getGymnasium() {
		return gymnasium;
	}

	public void setGymnasium(int gymnasium) {
		this.gymnasium = gymnasium;
	}

	public int getGesamtschule() {
		return gesamtschule;
	}

	public void setGesamtschule(int gesamtschule) {
		this.gesamtschule = gesamtschule;
	}

	public int getFoerderschule() {
		return foerderschule;
	}

	public void setFoerderschule(int foerderschule) {
		this.foerderschule = foerderschule;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + allgemeinbildende_schulen;
		result = prime * result + foerderschule;
		result = prime * result + gesamtschule;
		result = prime * result + grundschule;
		result = prime * result + gymnasium;
		result = prime * result + hauptschule;
		result = prime * result + nr;
		result = prime * result + realschule;
		result = prime * result
				+ ((stadtteil == null) ? 0 : stadtteil.hashCode());
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
		SchuelerImStadtteil other = (SchuelerImStadtteil) obj;
		if (allgemeinbildende_schulen != other.allgemeinbildende_schulen)
			return false;
		if (foerderschule != other.foerderschule)
			return false;
		if (gesamtschule != other.gesamtschule)
			return false;
		if (grundschule != other.grundschule)
			return false;
		if (gymnasium != other.gymnasium)
			return false;
		if (hauptschule != other.hauptschule)
			return false;
		if (nr != other.nr)
			return false;
		if (realschule != other.realschule)
			return false;
		if (stadtteil == null) {
			if (other.stadtteil != null)
				return false;
		} else if (!stadtteil.equals(other.stadtteil))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SchuelerImStadtteil [nr=" + nr + ", stadtteil=" + stadtteil
				+ ", allgemeinbildende_schulen=" + allgemeinbildende_schulen
				+ ", grundschule=" + grundschule + ", hauptschule="
				+ hauptschule + ", realschule=" + realschule + ", gymnasium="
				+ gymnasium + ", gesamtschule=" + gesamtschule
				+ ", foerderschule=" + foerderschule + "]";
	}

}
