package de.illilli.opengis.odk.arcgis;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import de.illilli.opengis.odk.bo.csv.EnergieSchuleKoeln;
import de.illilli.opengis.odk.parser.CsvParser;
import de.illilli.opengis.odk.parser.EnergieSchulenKoelnCsvParser;

/**
 * Die Daten werden zur Zeit von einer lokal hinterlegten Datei eingelesen. Die
 * URL zu den Informationen liegt aber vor. Es wäre besser, wenn die Daten von
 * der Adresse gelesen würden, um sicher zu stellen, dass sie aktuell sind.
 *
 */
public class AskForEnergieSchulenKoeln {

	String energieSchulenInKoelnFileUrl = "energie_schulen.csv";
	String energieSchulenInKoelnUrl = "http://www.offenedaten-koeln.de/sites/default/files/energie_schulen.csv";

	private static final Logger logger = Logger
			.getLogger(AskForSchuelerImStadtteil.class);

	private List<EnergieSchuleKoeln> list = new ArrayList<EnergieSchuleKoeln>();

	public AskForEnergieSchulenKoeln() throws URISyntaxException, IOException {

		CsvParser<EnergieSchuleKoeln> csvParser = new EnergieSchulenKoelnCsvParser();
		LoadCSVDataFromResource<EnergieSchuleKoeln> loadCSVDataFromResource = new LoadCSVDataFromResource<EnergieSchuleKoeln>(
				energieSchulenInKoelnFileUrl, csvParser);
		list = loadCSVDataFromResource.getObjectList();
		logger.debug("Data read from '" + energieSchulenInKoelnFileUrl + "'");

	}

	public List<EnergieSchuleKoeln> getEnergieSchulenInKoeln() {
		return list;
	}

}
