package de.illilli.opengis.writer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class GeoJsonWriter {

	public GeoJsonWriter(String str, String fileName) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(fileName);
		writer.print(str);
		writer.close();
	}
}
