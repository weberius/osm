package de.illilli.opengis.jdbc.query;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;

public class AskForStadtteileKoelnIntegrationTest {

	private static final Logger logger = Logger
			.getLogger(AskForStadtteileKoelnIntegrationTest.class);

	String pattern = "HH:mm:ss.SSS";

	@Test
	public void testForStadtKoeln() throws SQLException {
		String stadt = "köln";
		logger.debug("testForStadtKoeln");
		long before = System.currentTimeMillis();
		AskForStadtteile askFor = new AskForStadtteile(stadt);
		long after = System.currentTimeMillis();
		logger.debug("time needed: "
				+ new SimpleDateFormat(pattern)
						.format(new Date(after - before)));
		logger.debug(askFor.getPois());
	}

}
