package de.illilli.opengis.service;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

public class EinwohnerNachAltersgruppenFacadeSystemTest {

	private static final Logger logger = Logger
			.getLogger(EinwohnerNachAltersgruppenFacadeSystemTest.class);

	@Test
	public void testGetJson() throws JsonProcessingException {
		int nr = 901; // Koeln-Muelheim
		EinwohnerNachAltersgruppenFacade facade = new EinwohnerNachAltersgruppenFacade(
				nr);
		String json = facade.getJson();
		logger.debug(json);
		Assert.assertTrue(json != null);
	}

}
