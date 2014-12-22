package de.illilli.opengis.odk.arcgis;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import de.illilli.opengis.odk.bo.csv.SchuelerImStadtteil;
import de.illilli.opengis.odk.parser.CsvParser;
import de.illilli.opengis.odk.parser.SchuelerImStadtteilCsvParser;

public class LoadCSVDataFromHttpRequestSystemTest {

	@Test
	public void testIsFileFound() throws JsonProcessingException,
			UnsupportedEncodingException, IOException {
		String urlString = AskForSchuelerImStadtteil.SCHUELER_STADTTEIL_URL;
		CsvParser<SchuelerImStadtteil> csvParser = new SchuelerImStadtteilCsvParser();
		LoadCSVDataFromHttpRequest<SchuelerImStadtteil> csvData = new LoadCSVDataFromHttpRequest<SchuelerImStadtteil>(
				urlString, csvParser);
		boolean isFileFound = csvData.isFileFound();

		Assert.assertTrue(isFileFound);
	}

	@Test
	public void testGetObjectList() throws JsonProcessingException,
			UnsupportedEncodingException, IOException {
		String urlString = AskForSchuelerImStadtteil.SCHUELER_STADTTEIL_URL;
		CsvParser<SchuelerImStadtteil> csvParser = new SchuelerImStadtteilCsvParser();
		LoadCSVDataFromHttpRequest<SchuelerImStadtteil> csvData = new LoadCSVDataFromHttpRequest<SchuelerImStadtteil>(
				urlString, csvParser);
		List<SchuelerImStadtteil> list = csvData.getObjectList();

		Assert.assertFalse(list.isEmpty());
	}

}
