package de.illilli.opengis.odk.parser;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import de.illilli.opengis.odk.bo.csv.EnergieSchuleKoeln;

public class EnergieSchulenKolnCsvParserTest {

	private static final Logger logger = Logger
			.getLogger(EnergieSchulenKolnCsvParserTest.class);

	final String line = "21260,Griech. Lyzeum,Aachener Str. 443,2156,0,0,0,-100,0,0,-100,0.0,0,-100,Objekt ist seit 1997 an das Griechische Generalkonsulat vermietet;";

	@Test
	public void testMapping() throws JsonProcessingException, IOException {
		EnergieSchulenKoelnCsvParser parser = new EnergieSchulenKoelnCsvParser(
				line);
		EnergieSchuleKoeln energie = parser.getEnergieSchulenKoeln();
		logger.debug(energie.toString());
	}

}
