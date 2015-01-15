package de.illilli.opengis.service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;
import org.junit.Test;

public class SchuelerNachStadtteilFacadeSystemTest {

	private final static Logger logger = Logger
			.getLogger(SchuelerNachStadtteilFacadeSystemTest.class);

	@Test
	public void test() throws URISyntaxException, IOException {
		String stadt = "köln";
		SchuelerImStadtteilFacade facade = new SchuelerImStadtteilFacade(
				stadt);
		logger.debug(facade.getString());
	}

}
