package de.illilli.opengis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

public class TestProperties {

	public static final String PATH = "src/test/resources/";

	public static final String getPropertie(String key)
			throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileReader(new File(PATH + "test.properties")));
		return properties.getProperty(key);
	}

	@Test
	public void testTheTest() throws FileNotFoundException, IOException {
		String expected = "test";
		String actual = TestProperties
				.getPropertie("TestProperties.testTheTest");
		Assert.assertEquals(expected, actual);
	}
}
