package de.illilli.opengis.service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opengis.TestProperties;

public class SchulenInKoelnServiceIntegrationTest {

	private static final Logger logger = Logger
			.getLogger(SchulenInKoelnServiceIntegrationTest.class);

	@Test
	public void testGetKoeln() throws JsonParseException, JsonMappingException,
			IOException, URISyntaxException {
		SchulenInKoelnService service = new SchulenInKoelnService();
		String str = service.getKoeln();
		boolean condition = str.startsWith(TestProperties
				.getPropertie("odk.schulen.koeln.testGetKoeln"));
		Assert.assertTrue(condition);
	}

	@Test
	public void testGetKoelnGymnasien() throws JsonParseException,
			JsonMappingException, IOException, URISyntaxException {
		String schulart = "Gymnasium";
		SchulenInKoelnService service = new SchulenInKoelnService();
		String str = service.getKoelnBySchulart(schulart);
		logger.debug(str);
		boolean condition = str.contains("Gymnasium");
		Assert.assertTrue(condition);
		condition = str.contains("Grundschule");
		Assert.assertFalse(condition);
	}

	@Test
	public void testGetKoelnFoerderschulen() throws JsonParseException,
			JsonMappingException, IOException, URISyntaxException {
		String schulart = "Förderschule";
		SchulenInKoelnService service = new SchulenInKoelnService();
		String str = service.getKoelnBySchulart(schulart);
		logger.debug(str);
		boolean condition = str.contains("Förderschule");
		Assert.assertTrue(condition);
		condition = str.contains("Grundschule");
		Assert.assertFalse(condition);
	}

}
