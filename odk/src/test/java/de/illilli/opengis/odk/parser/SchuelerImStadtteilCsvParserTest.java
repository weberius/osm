package de.illilli.opengis.odk.parser;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import de.illilli.opengis.odk.bo.csv.SchuelerImStadtteil;

public class SchuelerImStadtteilCsvParserTest {

	private static final Logger logger = Logger
			.getLogger(SchuelerImStadtteilCsvParserTest.class);

	@Test
	public void testGetSchuelerImStadtteil() throws JsonProcessingException,
			UnsupportedEncodingException, IOException {
		String line = "101,Altstadt-Süd,5078,282,412,719,3293,0,372";
		CsvParser<SchuelerImStadtteil> parser = new SchuelerImStadtteilCsvParser();
		SchuelerImStadtteil schueler = parser.getObject(line);
		logger.debug(schueler.toString());
	}

}
