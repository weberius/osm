package de.illilli.opengis.service;

import org.junit.Test;

public class NavbarServiceTest {

	@Test
	public void test() {
		NavbarService service = new NavbarService();
		String navbar = service.getNavbar();
		System.out.println(navbar);
	}

}
