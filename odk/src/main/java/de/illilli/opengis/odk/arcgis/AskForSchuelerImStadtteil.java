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

import de.illilli.opengis.odk.bo.csv.SchuelerImStadtteil;
import de.illilli.opengis.odk.parser.SchuelerImStadtteilCsvParser;

public class AskForSchuelerImStadtteil {

	private static final Logger logger = Logger
			.getLogger(AskForSchuelerImStadtteil.class);

	private List<SchuelerImStadtteil> schuelerImStadtteilList = new ArrayList<SchuelerImStadtteil>();

	public AskForSchuelerImStadtteil() throws URISyntaxException, IOException {
		URL url1 = this.getClass().getClassLoader()
				.getResource("2012_Schueler_Stadtteil.csv");

		File schuelerImStadtteilFile = new File(url1.toURI());
		BufferedReader br = new BufferedReader(new FileReader(
				schuelerImStadtteilFile));
		String line;
		boolean firstLine = true;
		while ((line = br.readLine()) != null) {
			if (!firstLine) {
				SchuelerImStadtteil schuelerImStadtteil = new SchuelerImStadtteilCsvParser(
						line).getSchuelerImStadtteil();
				schuelerImStadtteilList.add(schuelerImStadtteil);
			}
			firstLine = false;
		}
		br.close();

	}

	public List<SchuelerImStadtteil> getSchuelerImStadtteilList() {
		return schuelerImStadtteilList;
	}

}
