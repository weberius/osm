package de.illilli.opengis.odk.arcgis;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.illilli.opengis.odk.bo.csv.SchuelerImStadtteil;

public class AskForSchuelerImStadtteilTest {

	@Test
	public void testForSize() throws URISyntaxException, IOException {
		AskForSchuelerImStadtteil askForSchuelerImStadtteil = new AskForSchuelerImStadtteil();
		List<SchuelerImStadtteil> schuelerImStadtTeilList = askForSchuelerImStadtteil
				.getList();
		Assert.assertTrue(schuelerImStadtTeilList.size() > 1);
	}

}
