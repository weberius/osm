package de.illilli.opengis.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

public class SchuelerNachStadtteilFacade {

	public static final String STADTTEIL_REST_SERVICE_URL = "http://localhost:8080/osm/dataservice/stadtteile/koeln";

	private String json;

	private final static Logger logger = Logger
			.getLogger(SchuelerNachStadtteilFacade.class);

	@Context
	HttpServletRequest request;

	@Context
	HttpServletResponse response;

	public SchuelerNachStadtteilFacade(String stadt) {
		logger.debug("stadt: " + stadt);
		// 1. hole alle stadtteile aus dem osm-service
		// http://www.mkyong.com/webservices/jax-rs/restful-java-client-with-apache-httpclient/
		// http://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/org/apache/http/impl/client/HttpClientBuilder.html
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet getRequest = new HttpGet(STADTTEIL_REST_SERVICE_URL);
		getRequest.addHeader("accept", "application/json");
		HttpResponse response;
		try {
			response = httpClient.execute(getRequest);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			String output;
			logger.debug("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				logger.debug(output);
			}
		} catch (ClientProtocolException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}

		httpClient.getConnectionManager().shutdown();
		// 2. reichere die notwendigen Informationen an
	}

	/**
	 * get GeoJson - String
	 * 
	 * @return
	 */
	public String getString() {
		return json;
	}

}
