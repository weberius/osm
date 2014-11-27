package de.illilli.opengis.bo;

import org.junit.Test;

import de.illilli.opengis.dto.PolygonHelper;

public class PolygonHelperTest {

	private String polygonTestData = "POLYGON((5.86631528177507 51.051103481149,5.86637223496408 51.0511161870149,5.86638768598697 51.0511196881862,5.86681645187208 51.0512155750013,5.86691733267849 51.0512381066799))";

	@Test
	public void testGetPolygon() {
		PolygonHelper helper = new PolygonHelper(polygonTestData);
		String str = helper.getCoordinates();
		String type = helper.getType();
		System.out.println(type + ": " + str);

	}
}
