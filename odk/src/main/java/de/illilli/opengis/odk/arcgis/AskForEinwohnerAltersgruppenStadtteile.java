package de.illilli.opengis.odk.arcgis;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import de.illilli.opengis.odk.bo.csv.EinwohnerNachAltersgruppen;
import de.illilli.opengis.odk.parser.CsvParser;
import de.illilli.opengis.odk.parser.EinwohnerNachAltersgruppenCsvParser;

/**
 * <a href=
 * "http://www.offenedaten-koeln.de/dataset/ca726675-5a73-45f8-a760-e50739d45c77/resource/ca726675-5a73-45f8-a760-e50739d45c77"
 * >Offene Daten Koeln: 2012 Einwohner Altersgruppen Stadtteile</a>
 *
 */
public class AskForEinwohnerAltersgruppenStadtteile {

	private static final Logger logger = Logger
			.getLogger(AskForEinwohnerAltersgruppenStadtteile.class);

	public static final String ALTERSGRUPPEN_STADTTEIL_URL = "http://www.offenedaten-koeln.de/sites/default/files/2012_Altersgruppen_Stadtteil.csv";

	/**
	 * Die Einwohner Liste soll nur einmal gelesen werden. Wenn sie bereits
	 * gelesen wurde, kann sie aus dem Speicher wieder hergestellt werden.
	 */
	private static List<EinwohnerNachAltersgruppen> einwohnerList;

	public AskForEinwohnerAltersgruppenStadtteile() {

		if (einwohnerList == null) {
			einwohnerList = new ArrayList<EinwohnerNachAltersgruppen>();
			CsvParser<EinwohnerNachAltersgruppen> csvParser = new EinwohnerNachAltersgruppenCsvParser();
			LoadCSVDataFromHttpRequest<EinwohnerNachAltersgruppen> loadCSVDataFromResource = new LoadCSVDataFromHttpRequest<EinwohnerNachAltersgruppen>(
					ALTERSGRUPPEN_STADTTEIL_URL, csvParser);
			einwohnerList = loadCSVDataFromResource.getObjectList();
			logger.debug("Data read from '" + ALTERSGRUPPEN_STADTTEIL_URL + "'");
		} else {
			logger.debug("Data already read.");
		}

	}

	public List<EinwohnerNachAltersgruppen> getList() {
		return einwohnerList;
	}

	public EinwohnerNachAltersgruppen getEinwohnerInStadtteil(int nr) {
		EinwohnerNachAltersgruppen einwohnerNachAltersgruppen = null;
		for (EinwohnerNachAltersgruppen einwohner : einwohnerList) {
			if (einwohner.getNr() == nr) {
				einwohnerNachAltersgruppen = einwohner;
			}
		}

		return einwohnerNachAltersgruppen;
	}

}
