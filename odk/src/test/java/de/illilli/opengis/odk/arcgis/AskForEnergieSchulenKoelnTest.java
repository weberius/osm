package de.illilli.opengis.odk.arcgis;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.illilli.opengis.odk.bo.csv.EnergieSchuleKoeln;

public class AskForEnergieSchulenKoelnTest {

	@Test
	public void testAskForEnergieSchulenKoeln() throws URISyntaxException,
			IOException {
		AskForEnergieSchulenKoeln askForEnergieSchulenKoeln = new AskForEnergieSchulenKoeln();
		List<EnergieSchuleKoeln> energieSchulenKoelnList = askForEnergieSchulenKoeln
				.getEnergieSchulenInKoeln();
		Assert.assertTrue(energieSchulenKoelnList.size() > 1);
	}

}
