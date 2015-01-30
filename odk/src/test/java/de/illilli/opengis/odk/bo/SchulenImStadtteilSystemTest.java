package de.illilli.opengis.odk.bo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opengis.odk.arcgis.AskForSchulenInKoeln;
import de.illilli.opengis.odk.bo.json.SchulenInKoeln;

public class SchulenImStadtteilSystemTest {

	private static final Logger logger = Logger
			.getLogger(SchulenImStadtteilSystemTest.class);

	@Test
	public void testGetSchulartList() throws JsonParseException,
			JsonMappingException, IOException, URISyntaxException {
		List<String> schulartList = new SchulenImStadtteil(
				new AskForSchulenInKoeln().getSchulenInKoeln())
				.getSchulartList();
		for (String schulart : schulartList) {
			logger.debug(schulart);
		}
		Assert.assertTrue(schulartList.size() == 9);
	}

	@Test
	public void testGetAnzahlSchulenJeStadtteil() throws JsonParseException,
			JsonMappingException, IOException, URISyntaxException {
		int anzahlSchulenJeStadtteil = new SchulenImStadtteil(
				new AskForSchulenInKoeln().getSchulenInKoeln())
				.getAnzahlSchulenJeStadtteil(903);
		logger.debug("anzahlSchulenJeStadtteil : " + anzahlSchulenJeStadtteil);
	}

	@Test
	public void testGetAnteilSchulartJeStadtteil() throws JsonParseException,
			JsonMappingException, NumberFormatException, IOException,
			URISyntaxException {
		SchulenInKoeln schulenInKoeln = new AskForSchulenInKoeln()
				.getSchulenInKoeln();
		double anteilGrundschule = new SchulenImStadtteil(schulenInKoeln)
				.getAnteilSchulartJeStadtteil(Integer.parseInt("903"),
						SchulenImStadtteil.Head.grundschule.name());
		logger.debug("anteilGrundschule : " + anteilGrundschule);
	}

	@Test
	public void testGetAnzahlSchulartJeStadtteil() throws JsonParseException,
			JsonMappingException, IOException, URISyntaxException {
		SchulenInKoeln schulenInKoeln = new AskForSchulenInKoeln()
				.getSchulenInKoeln();
		int anteilGrundschule = new SchulenImStadtteil(schulenInKoeln)
				.getAnzahlSchulartJeStadtteil(Integer.parseInt("903"),
						SchulenImStadtteil.Head.grundschule.name());
		logger.debug("anteilGrundschule : " + anteilGrundschule);
	}
}
