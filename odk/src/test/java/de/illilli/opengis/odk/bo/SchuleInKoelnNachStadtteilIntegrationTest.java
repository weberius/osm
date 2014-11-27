package de.illilli.opengis.odk.bo;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opengis.odk.arcgis.AskForSchulenInKoeln;

public class SchuleInKoelnNachStadtteilIntegrationTest {

	@Test
	public void test() throws JsonParseException, JsonMappingException,
			IOException, URISyntaxException {
		AskForSchulenInKoeln askfor = new AskForSchulenInKoeln();

		SchuleInKoelnNachStadtteil schule = new SchuleInKoelnNachStadtteil(
				askfor.getSchulenInKoeln());
	}
}
