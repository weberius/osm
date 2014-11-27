package de.illilli.opengis.odk.arcgis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import de.illilli.opengis.odk.bo.csv.EnergieSchuleKoeln;
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

	@SuppressWarnings("unused")
	private static final Logger logger = Logger
			.getLogger(AskForSchuelerImStadtteil.class);

	private List<EnergieSchuleKoeln> energieSchulenInKoelnList = new ArrayList<EnergieSchuleKoeln>();

	public AskForEnergieSchulenKoeln() throws URISyntaxException, IOException {
		URL url1 = this.getClass().getClassLoader()
				.getResource(energieSchulenInKoelnFileUrl);

		File file = new File(url1.toURI());
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		boolean firstLine = true;
		while ((line = br.readLine()) != null) {
			if (!firstLine) {
				EnergieSchuleKoeln energieSchulenKoeln = new EnergieSchulenKoelnCsvParser(
						line).getEnergieSchulenKoeln();
				energieSchulenInKoelnList.add(energieSchulenKoeln);
			}
			firstLine = false;
		}
		br.close();

	}

	public List<EnergieSchuleKoeln> getEnergieSchulenInKoeln() {
		return energieSchulenInKoelnList;
	}

}
