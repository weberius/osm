package de.illilli.opengis.odk.bo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.illilli.opengis.odk.arcgis.AskForEnergieSchulenKoeln;
import de.illilli.opengis.odk.arcgis.AskForSchulenInKoeln;
import de.illilli.opengis.odk.bo.csv.EnergieSchuleKoeln;
import de.illilli.opengis.odk.bo.json.SchulenInKoeln;

public class SchulenInKoelnMitEnergieDaoTest {

	/**
	 * Der Test prueft, ob Daten gemerged wurden, nicht wie viele und nicht wie
	 * genau.
	 * 
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	@Test
	public void test() throws URISyntaxException, IOException {
		SchulenInKoeln schulen = new AskForSchulenInKoeln().getSchulenInKoeln();
		List<EnergieSchuleKoeln> energie = new AskForEnergieSchulenKoeln()
				.getEnergieSchulenInKoeln();
		SchulenInKoelnMitEnergieDao schulenEnergie = new SchulenInKoelnMitEnergieDao(
				schulen, energie);
		Assert.assertTrue(schulenEnergie.getSchuleInKoelnMitEnergieList()
				.size() > 0);
	}

}
