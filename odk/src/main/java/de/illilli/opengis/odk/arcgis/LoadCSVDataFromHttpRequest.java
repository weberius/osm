package de.illilli.opengis.odk.arcgis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

import de.illilli.opengis.odk.parser.CsvParser;

public class LoadCSVDataFromHttpRequest<T> {

	private static final Logger logger = Logger
			.getLogger(LoadCSVDataFromHttpRequest.class);

	private StringBuilder lineBuilder = new StringBuilder();
	private List<T> objectList = new ArrayList<T>();
	private boolean fileFound = false;

	public LoadCSVDataFromHttpRequest(String urlString, CsvParser<T> csvParser) {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet getRequest = new HttpGet(urlString);
		getRequest.addHeader("accept", "application/json");
		HttpResponse response;
		try {
			response = httpClient.execute(getRequest);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			InputStream src = response.getEntity().getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(src,
					"UTF-8"));
			String line;
			boolean firstLine = true;
			while ((line = br.readLine()) != null) {

				if (!firstLine) {
					lineBuilder.append("\n");
					lineBuilder.append(line);
					T myTinyObject = csvParser.getObject(line);
					objectList.add(myTinyObject);
				} else {
					lineBuilder.append(line);
				}
				firstLine = false;
			}
			br.close();

		} catch (ClientProtocolException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}

	public boolean isFileFound() {
		return fileFound;
	}

	public List<T> getObjectList() {
		return objectList;
	}

}
