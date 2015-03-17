package de.illilli.opengis.odk.bo.json;

public enum SchulartenKoelnEnum {
	zweiterbildungsweg("2. bildungsweg"), berufskolleg("berufskolleg"), foerderderschule(
			"förderschule"), freiewaldorfschule("freie waldorfschule"), gesamtschule(
			"gesamtschule"), grundschule("grundschule"), gymnasium("gymnasium"), hauptschule(
			"hauptschule"), realschule("realschule");

	private final String schulart;

	SchulartenKoelnEnum(String schulart) {
		this.schulart = schulart;
	}

	public String schulart() {
		return schulart;
	}
}
