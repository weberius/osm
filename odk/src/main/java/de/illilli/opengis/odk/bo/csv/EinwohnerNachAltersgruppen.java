package de.illilli.opengis.odk.bo.csv;

public class EinwohnerNachAltersgruppen {

	/**
	 * 
	 * <p>
	 * Colors from <a href="http://colorbrewer2.org">ColorBrewer: Color for your
	 * Maps</a>
	 * </p>
	 */
	public enum Head {

		nr("Nr.", "#000000", "#000000"), //
		stadtteil("Stadtteil", "#000000", "#000000"), //
		einwohnerInsgesamt("Einwohner insgesamt", "#ffffff", "#ffffff"), //
		a0_2("0 - 2 Jahre", "#a50026", "#a50026"), //
		a0_5("0 - 5 Jahre", "#a50026", "#a50026"), //
		a3_5("3 - 5 Jahre", "#d73027", "#d73027"), //
		a6_14("6 - 14 Jahre", "#f46d43", "#f46d43"), //
		a15_17("15 - 17 Jahre", "#fdae61", "#fdae61"), //
		a6_17("6 - 17 Jahre", "#fdae61", "#fdae61"), //
		a18_20("18 - 20 Jahre", "#fee08b", "#fee08b"), //
		a18_65("18 - 65 Jahre", "#fee08b", "#fee08b"), //
		a21_34("21 - 34 Jahre", "#ffffbf", "#ffffbf"), //
		a35_59("35 - 59 Jahre", "#d9ef8b", "#d9ef8b"), //
		a60_64("60 - 64 Jahre", "#a6d96a", "#a6d96a"), //
		a65_74("65 - 74 Jahre", "#66bd63", "#66bd63"), //
		a75_79("75 - 79 Jahre", "#1a9850", "#1a9850"), //
		a65undAelter("65 Jahre u. Älter", "#006837", "#006837"), //
		a80undAelter("80 Jahre u. Älter", "#006837", "#006837");

		private final String key;
		private final String color;
		private final String highlight;

		Head(String key, String color, String highlight) {
			this.key = key;
			this.color = color;
			this.highlight = highlight;
		}

		public String key() {
			return key;
		}

		public String color() {
			return color;
		}

		public String highlight() {
			return highlight;
		}
	}

	private int nr;
	private String stadtteil;
	private int einwohnerInsgesamt;
	private int a0_2;
	private int a3_5;
	private int a6_14;
	private int a15_17;
	private int a18_20;
	private int a21_34;
	private int a35_59;
	private int a60_64;
	private int a65_74;
	private int a75_79;
	private int a80undAelter;

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

	public int getEinwohnerInsgesamt() {
		return einwohnerInsgesamt;
	}

	public void setEinwohnerInsgesamt(int einwohnerInsgesamt) {
		this.einwohnerInsgesamt = einwohnerInsgesamt;
	}

	public int getA0_2() {
		return a0_2;
	}

	public void setA0_2(int a0_2) {
		this.a0_2 = a0_2;
	}

	public int getA3_5() {
		return a3_5;
	}

	public void setA3_5(int a3_5) {
		this.a3_5 = a3_5;
	}

	public int getA6_14() {
		return a6_14;
	}

	public void setA6_14(int a6_14) {
		this.a6_14 = a6_14;
	}

	public int getA15_17() {
		return a15_17;
	}

	public void setA15_17(int a15_17) {
		this.a15_17 = a15_17;
	}

	public int getA18_20() {
		return a18_20;
	}

	public void setA18_20(int a18_20) {
		this.a18_20 = a18_20;
	}

	public int getA21_34() {
		return a21_34;
	}

	public void setA21_34(int a21_34) {
		this.a21_34 = a21_34;
	}

	public int getA35_59() {
		return a35_59;
	}

	public void setA35_59(int a35_59) {
		this.a35_59 = a35_59;
	}

	public int getA60_64() {
		return a60_64;
	}

	public void setA60_64(int a60_64) {
		this.a60_64 = a60_64;
	}

	public int getA65_74() {
		return a65_74;
	}

	public void setA65_74(int a65_74) {
		this.a65_74 = a65_74;
	}

	public int getA75_79() {
		return a75_79;
	}

	public void setA75_79(int a75_79) {
		this.a75_79 = a75_79;
	}

	public int getA80undAelter() {
		return a80undAelter;
	}

	public void setA80undAelter(int a80undAelter) {
		this.a80undAelter = a80undAelter;
	}

	@Override
	public String toString() {
		return "EinwohnerNachAltersgruppenInKoeln [nr=" + nr + ", stadtteil="
				+ stadtteil + ", einwohnerInsgesamt=" + einwohnerInsgesamt
				+ ", a0_2=" + a0_2 + ", a3_5=" + a3_5 + ", a6_14=" + a6_14
				+ ", a15_17=" + a15_17 + ", a18_20=" + a18_20 + ", a21_34="
				+ a21_34 + ", a35_59=" + a35_59 + ", a60_64=" + a60_64
				+ ", a65_74=" + a65_74 + ", a75_79=" + a75_79
				+ ", a80undAelter=" + a80undAelter + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a0_2;
		result = prime * result + a15_17;
		result = prime * result + a18_20;
		result = prime * result + a21_34;
		result = prime * result + a35_59;
		result = prime * result + a3_5;
		result = prime * result + a60_64;
		result = prime * result + a65_74;
		result = prime * result + a6_14;
		result = prime * result + a75_79;
		result = prime * result + a80undAelter;
		result = prime * result + einwohnerInsgesamt;
		result = prime * result + nr;
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
		EinwohnerNachAltersgruppen other = (EinwohnerNachAltersgruppen) obj;
		if (a0_2 != other.a0_2)
			return false;
		if (a15_17 != other.a15_17)
			return false;
		if (a18_20 != other.a18_20)
			return false;
		if (a21_34 != other.a21_34)
			return false;
		if (a35_59 != other.a35_59)
			return false;
		if (a3_5 != other.a3_5)
			return false;
		if (a60_64 != other.a60_64)
			return false;
		if (a65_74 != other.a65_74)
			return false;
		if (a6_14 != other.a6_14)
			return false;
		if (a75_79 != other.a75_79)
			return false;
		if (a80undAelter != other.a80undAelter)
			return false;
		if (einwohnerInsgesamt != other.einwohnerInsgesamt)
			return false;
		if (nr != other.nr)
			return false;
		if (stadtteil == null) {
			if (other.stadtteil != null)
				return false;
		} else if (!stadtteil.equals(other.stadtteil))
			return false;
		return true;
	}

}
