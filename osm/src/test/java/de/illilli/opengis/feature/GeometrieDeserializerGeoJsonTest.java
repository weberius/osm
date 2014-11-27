package de.illilli.opengis.feature;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.geojson.LineString;
import org.geojson.LngLatAlt;
import org.junit.Assert;
import org.junit.Test;

import de.illilli.opengis.TestProperties;

public class GeometrieDeserializerGeoJsonTest {

	@Test
	public void testLineString() throws FileNotFoundException, IOException {

		String way = TestProperties.getPropertie("osm.line.administration.6.koeln.asgeojson.0");
		GeometrieDeserializerGeoJson deserializer = new GeometrieDeserializerGeoJson(way);
		String expectedType = GeometrieDeserializerGeoJson.LINESTRING;
		String actualType = deserializer.getType();
		Assert.assertEquals(expectedType, actualType);

		LineString geometry = (LineString) deserializer.getGeometry();
		List<LngLatAlt> lngLatAltList = geometry.getCoordinates();
		int expectedSize = 2768;
		int actualSize = lngLatAltList.size();
		Assert.assertEquals(expectedSize, actualSize);

	}
}
