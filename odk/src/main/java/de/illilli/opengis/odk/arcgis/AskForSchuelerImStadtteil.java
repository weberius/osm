package de.illilli.opengis.odk.arcgis;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import de.illilli.opengis.odk.bo.csv.SchuelerImStadtteil;
import de.illilli.opengis.odk.parser.CsvParser;
import de.illilli.opengis.odk.parser.SchuelerImStadtteilCsvParser;

public class AskForSchuelerImStadtteil {

	private static final Logger logger = Logger
			.getLogger(AskForSchuelerImStadtteil.class);

	public static final String SCHUELER_STADTTEIL_URL = "http://www.offenedaten-koeln.de/sites/default/files/2012_Schueler_Stadtteil.csv";
	public static final String SCHUELER_STADTTEIL_FILE = "2012_Schueler_Stadtteil.csv";

	private List<SchuelerImStadtteil> schuelerImStadtteilList = new ArrayList<SchuelerImStadtteil>();

	public AskForSchuelerImStadtteil() throws URISyntaxException, IOException {
		CsvParser<SchuelerImStadtteil> csvParser = new SchuelerImStadtteilCsvParser();
		LoadCSVDataFromResource<SchuelerImStadtteil> loadCSVDataFromResource = new LoadCSVDataFromResource<SchuelerImStadtteil>(
				SCHUELER_STADTTEIL_FILE, csvParser);
		schuelerImStadtteilList = loadCSVDataFromResource.getObjectList();
		logger.debug("Data read from '" + SCHUELER_STADTTEIL_FILE + "'");
	}

	public List<SchuelerImStadtteil> getList() {
		return schuelerImStadtteilList;
	}

}
