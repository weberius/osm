package de.illilli.opengis.odk.arcgis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

/**
 * <a href=
 * "http://www.offenedaten-koeln.de/dataset/ca726675-5a73-45f8-a760-e50739d45c77/resource/ca726675-5a73-45f8-a760-e50739d45c77"
 * >Offene Daten Koeln: 2012 Einwohner Altersgruppen Stadtteile</a>
 *
 */
public class AskForEinwohnerAltersgruppenStadtteile {

	private static final Logger logger = Logger
			.getLogger(AskForEinwohnerAltersgruppenStadtteile.class);

	String ALTERSGRUPPEN_STADTTEIL_URL = "http://www.offenedaten-koeln.de/sites/default/files/2012_Altersgruppen_Stadtteil.csv";

	public AskForEinwohnerAltersgruppenStadtteile() {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet getRequest = new HttpGet(ALTERSGRUPPEN_STADTTEIL_URL);
		getRequest.addHeader("accept", "application/json");
		HttpResponse response;
		try {
			response = httpClient.execute(getRequest);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			InputStream src = response.getEntity().getContent();
		} catch (ClientProtocolException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}
}
