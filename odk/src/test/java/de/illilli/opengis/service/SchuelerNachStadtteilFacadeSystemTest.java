package de.illilli.opengis.service;

import org.junit.Test;

public class SchuelerNachStadtteilFacadeSystemTest {

	@Test
	public void test() {
		String stadt = "köln";
		SchuelerNachStadtteilFacade facade = new SchuelerNachStadtteilFacade(
				stadt);
	}

}
