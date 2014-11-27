package de.illilli.opengis.service;

import org.junit.Test;

public class SchuleInKoelnMitEnergieFacadeIntegrationTest {

	@Test
	public void test() {
		String id = "113";
		SchuleInKoelnMitEnergieFacade facade = new SchuleInKoelnMitEnergieFacade(
				id);
		System.out.println(facade.getHtml());
	}

}
