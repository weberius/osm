package de.illilli.opengis.service;

import org.apache.log4j.Logger;
import org.junit.Test;

public class SchuelerImStadtteilRadarChartDataFacadeTest {

	private static final Logger logger = Logger
			.getLogger(SchuelerImStadtteilRadarChartDataFacadeTest.class);

	@Test
	public void testGetString() {
		int stadttteilnr = 903;
		SchuelerImStadtteilRadarChartDataFacade facade = new SchuelerImStadtteilRadarChartDataFacade(
				stadttteilnr);
		String json = facade.getString();
		logger.debug(json);
	}

}
