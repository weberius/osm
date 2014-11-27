package de.illilli.opengis;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class HtmlProperties {

	public static final String NAVBAR = "navbar.properties";
	private Properties properties;

	public HtmlProperties() {
		properties = new Properties();
		URL navbar = getClass().getClassLoader().getResource(NAVBAR);

		try {
			File file = new File(navbar.toURI());
			properties.load(new FileReader(file));
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getPropertie(String key) {
		return properties.getProperty(key) != null ? properties.getProperty(key) : "";
	}
}
