package de.illilli.opengis.odk.arcgis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import de.illilli.opengis.odk.parser.CsvParser;

public class LoadCSVDataFromResource<T> {

	private boolean fileFound = false;
	private List<T> objectList = new ArrayList<T>();
	private File file;
	private BufferedReader br;

	public LoadCSVDataFromResource(String fileName, CsvParser<T> csvParser)
			throws URISyntaxException, JsonProcessingException,
			UnsupportedEncodingException, IOException {

		URL url1 = this.getClass().getClassLoader().getResource(fileName);

		fileFound = url1 != null;
		if (fileFound) {
			file = new File(url1.toURI());
		} else {
			return;
		}

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
	}

	public boolean isFileFound() {
		return fileFound;
	}

	public List<T> getObjectList() {
		return objectList;
	}

}
