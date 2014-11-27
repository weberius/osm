package de.illilli.opengis.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import de.illilli.opengis.TestProperties;

public class OsmShopServiceIntegrationTest {

	@Test
	public void testGetKioskByName() throws SQLException, FileNotFoundException, IOException {
		OsmShopService service = new OsmShopService();
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		Mockito.when(request.getParameter("q")).thenReturn("Nuss");
		String expected = service.getKioskByName(request);
		String actual = TestProperties.getPropertie("osm.shop.service.kiosk.name");
		Assert.assertEquals(expected, actual);
	}
}
