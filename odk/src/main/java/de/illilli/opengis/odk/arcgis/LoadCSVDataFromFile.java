package de.illilli.opengis.odk.arcgis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

import de.illilli.opengis.odk.parser.CsvParser;

public class LoadCSVDataFromFile<T> {

	private static final Logger logger = Logger
			.getLogger(LoadCSVDataFromFile.class);

	private boolean fileFound = false;
	private List<T> objectList = new ArrayList<T>();
	private File file;
	private BufferedReader br;

	public LoadCSVDataFromFile(String fileName, CsvParser<T> csvParser)
			throws JsonProcessingException, UnsupportedEncodingException,
			IOException {

		file = new File(fileName);
		fileFound = file.exists();
		if (fileFound) {
			br = new BufferedReader(new FileReader(file));
		} else {
			return;
		}

		String line;
		boolean firstLine = true;
		while ((line = br.readLine()) != null) {
			if (!firstLine) {
				T myTinyObject = csvParser.getObject(line);
				objectList.add(myTinyObject);
			}
			firstLine = false;
		}
		br.close();
		logger.debug("Data read from '" + file.getAbsolutePath() + "'");
	}

	public boolean isFileFound() {
		return fileFound;
	}

	public List<T> getObjectList() {
		return objectList;
	}

}
