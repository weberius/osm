package de.illilli.opengis.odk.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import de.illilli.opengis.odk.bo.json.Feature;
import de.illilli.opengis.odk.bo.json.SchulenInKoeln;

/**
 * Diese Klasse ermöglicht es auf Basis der Offenen Daten Köln die Anzahl der
 * Schulen je Stadtteil gewichtet nach der Schulart zu liefern.
 *
 */
public class SchulenImStadtteil {

	public enum Head {

		grundschule("Grundschule"), //
		hauptschule("Hauptschule"), //
		realschule("Realschule"), //
		gymnasium("Gymnasium"), //
		gesamtschule("Gesamtschule"), //
		berufskolleg("Berufskolleg"), //
		zweiterBildungsweg("2. Bildungsweg"), //
		freieWaldorfschule("Freie Waldorfschule"), //
		foerderschule("Förderschule");

		private final String key;

		Head(String key) {
			this.key = key;
		}

		public String key() {
			return key;
		}
	}

	private static final Logger logger = Logger
			.getLogger(SchulenImStadtteil.class);
	private Map<String, List<Feature>> map = new HashMap<String, List<Feature>>();
	private List<String> schulartList = new ArrayList<String>();

	public SchulenImStadtteil(SchulenInKoeln schulen) {
		List<Feature> featureList = schulen.getFeatures();

		for (Feature feature : featureList) {
			// sortiere die Features nach Stadtteil
			String key = feature.getAttributes().getNrStadtteil();
			List<Feature> value = new ArrayList<Feature>();
			if (map.get(key) == null) {
				value.add(feature);
				map.put(key, value);
			} else {
				value = map.get(key);
				value.add(feature);
				map.put(key, value);
			}
			// schularten sammeln
			String schulart = feature.getAttributes().getSchulart();
			if (!schulartList.contains(schulart)) {
				schulartList.add(schulart);
			}
		}
	}

	public List<String> getSchulartList() {
		return schulartList;
	}

	public Integer getAnzahlSchulenJeStadtteil(int stadtteilNr) {
		String key = Integer.toString(stadtteilNr);
		List<Feature> value = map.get(key);
		int anzahlSchulenJeStadtteil = 0;
		if (value != null) {
			anzahlSchulenJeStadtteil = value.size();
		}
		return anzahlSchulenJeStadtteil;
	}

	public int getAnzahlSchulartJeStadtteil(int stadtteilNr, String schulart) {
		int counter = 0;
		int anzahlArtJeStadtteil = 0;
		String key = Integer.toString(stadtteilNr);
		List<Feature> value = map.get(key);
		if (value != null) {
			for (int i = 0; i < value.size(); i++) {
				if (value.get(i).getAttributes().getSchulart()
						.equalsIgnoreCase(schulart)) {
					counter++;
				}
			}
			anzahlArtJeStadtteil = counter;
			logger.debug("\nAnzahl Schulen in " + stadtteilNr + ": \t"
					+ value.size() + "; \nAnzahl " + schulart + ": \t"
					+ anzahlArtJeStadtteil);
		}
		return anzahlArtJeStadtteil;
	}

	public Double getAnteilSchulartJeStadtteil(int stadtteilNr, String schulart) {
		int counter = 0;
		Double anteilArtJeStadtteil = 0.0d;
		String key = Integer.toString(stadtteilNr);
		List<Feature> value = map.get(key);
		if (value != null) {
			for (int i = 0; i < value.size(); i++) {
				if (value.get(i).getAttributes().getSchulart()
						.equalsIgnoreCase(schulart)) {
					counter++;
				}
			}
			anteilArtJeStadtteil = new Double(counter)
					/ new Double(value.size());
			logger.debug("\nAnzahl Schulen in " + stadtteilNr + ": \t"
					+ value.size() + "; \nAnzahl " + schulart + ": \t"
					+ counter + "; \nAnteil: \t\t" + anteilArtJeStadtteil);
		}
		return anteilArtJeStadtteil;
	}

}
