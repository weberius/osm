package de.illilli.opengis.service;

import org.apache.log4j.Logger;
import org.junit.Test;

public class EinwohnerNachAltersgruppenVariablesFacadeSystemTest {

	private static final Logger logger = Logger
			.getLogger(EinwohnerNachAltersgruppenVariablesFacadeSystemTest.class);

	@Test
	public void testEinwohnerNachAltersgruppenVariablesFacade() {
		EinwohnerNachAltersgruppenVariablesFacade facade = new EinwohnerNachAltersgruppenVariablesFacade();
		logger.debug(facade.getJson());
	}

}
