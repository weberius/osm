package de.illilli.opengis.odk.arcgis;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import de.illilli.opengis.odk.bo.csv.EinwohnerNachAltersgruppen;

public class AskForEinwohnerAltersgruppenStadtteileSystemTest {

	private static final Logger logger = Logger
			.getLogger(AskForEinwohnerAltersgruppenStadtteileSystemTest.class);

	@Test
	public void test() {
		AskForEinwohnerAltersgruppenStadtteile askFor = new AskForEinwohnerAltersgruppenStadtteile();
		List<EinwohnerNachAltersgruppen> list = askFor.getList();
		for (EinwohnerNachAltersgruppen einwohnerNachAltersgruppenInKoeln : list) {
			logger.debug(einwohnerNachAltersgruppenInKoeln);
		}
		Assert.assertFalse(list.isEmpty());
	}

}
