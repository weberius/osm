package de.illilli.opengis.odk.bo;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opengis.odk.arcgis.AskForSchulenInKoeln;

public class SchulenInKoelnNachStadtteilIntegrationTest {

	private static final Logger logger = Logger
			.getLogger(SchulenInKoelnNachStadtteilIntegrationTest.class);

	@Test
	public void test() throws JsonParseException, JsonMappingException,
			IOException, URISyntaxException {
		AskForSchulenInKoeln askfor = new AskForSchulenInKoeln();

		SchulenInKoelnNachStadtteil schule = new SchulenInKoelnNachStadtteil(
				askfor.getSchulenInKoeln());
	}

	@Test
	public void testgetAnzahlSchulenJeStadtteil() throws JsonParseException,
			JsonMappingException, IOException, URISyntaxException {
		int nrStadtteil = 903;
		AskForSchulenInKoeln askfor = new AskForSchulenInKoeln();
		SchulenInKoelnNachStadtteil schule = new SchulenInKoelnNachStadtteil(
				askfor.getSchulenInKoeln());
		int anzahlSchulen = schule.getAnzahlSchulenJeStadtteil(nrStadtteil);
		logger.debug(anzahlSchulen);
	}

	//
	@Test
	public void testGetAnteilSchulartJeStadtteil() throws JsonParseException,
			JsonMappingException, IOException, URISyntaxException {
		int nrStadtteil = 805;// 903;
		String schulart = "Grundschule";
		AskForSchulenInKoeln askfor = new AskForSchulenInKoeln();
		SchulenInKoelnNachStadtteil schule = new SchulenInKoelnNachStadtteil(
				askfor.getSchulenInKoeln());
		double anteilSchulen = schule.getAnteilSchulartJeStadtteil(nrStadtteil,
				schulart);
		logger.debug(anteilSchulen);
	}
}
