package de.illilli.opengis.odk.arcgis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

public class WriteCSVDataToFile {

	private static final Logger logger = Logger
			.getLogger(WriteCSVDataToFile.class);

	public WriteCSVDataToFile(String fileName, String content) {

		try {
			File file = new File(fileName);
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write(content);
			out.close();
			logger.debug("File " + fileName + " written to ");
		} catch (IOException e) {
			logger.error("Datei " + fileName
					+ " kann nicht geschrieben werden.", e);
		}

	}
}
