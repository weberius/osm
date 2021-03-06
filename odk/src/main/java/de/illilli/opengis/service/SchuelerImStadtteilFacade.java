package de.illilli.opengis.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.GeometryCollection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.opengis.odk.arcgis.AskForEinwohnerAltersgruppenStadtteile;
import de.illilli.opengis.odk.arcgis.AskForSchuelerImStadtteil;
import de.illilli.opengis.odk.arcgis.AskForSchulenInKoeln;
import de.illilli.opengis.odk.bo.SchulenImStadtteil;
import de.illilli.opengis.odk.bo.csv.EinwohnerNachAltersgruppen;
import de.illilli.opengis.odk.bo.csv.SchuelerImStadtteil;
import de.illilli.opengis.odk.bo.json.SchulenInKoeln;

public class SchuelerImStadtteilFacade {

	public static final String STADTTEIL_REST_SERVICE_URL = "http://localhost:8080/osm/dataservice/stadtteile/koeln";

	private FeatureCollection featureCollection = new FeatureCollection();

	private final static Logger logger = Logger
			.getLogger(SchuelerImStadtteilFacade.class);

	private DecimalFormat df = new DecimalFormat("0.00");

	public SchuelerImStadtteilFacade(String stadt) throws URISyntaxException,
			IOException {
		logger.debug("stadt: " + stadt);
		// 1. hole alle stadtteile aus dem osm-service und verstaue sie in einer
		// FeatureCollection
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

			InputStream src = response.getEntity().getContent();
			ObjectMapper objectMapper = new ObjectMapper();
			// wenn die GeometrieCollection nicht registriert wird, kommt es zu
			// einer Exception; d
			// http://stackoverflow.com/questions/19239413/de-serializing-json-to-polymorphic-object-model-using-spring-and-jsontypeinfo-an
			objectMapper.registerSubtypes(GeometryCollection.class);
			featureCollection = objectMapper.readValue(src,
					FeatureCollection.class);

		} catch (ClientProtocolException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		} finally {
			httpClient.getConnectionManager().shutdown();
		}

		// 2. Lies die Schueler im Stadtteil aus
		List<SchuelerImStadtteil> schuelerList = new AskForSchuelerImStadtteil()
				.getList();
		Map<String, SchuelerImStadtteil> schuelerMap = new HashMap<String, SchuelerImStadtteil>();
		// 3. Iteriere nur einmal
		for (SchuelerImStadtteil schueler : schuelerList) {
			schuelerMap.put(Integer.toString(schueler.getNr()), schueler);
		}
		// 4. Lies die Bevoelkerungsstrukur ein
		List<EinwohnerNachAltersgruppen> einwohnerList = new AskForEinwohnerAltersgruppenStadtteile()
				.getList();
		Map<String, EinwohnerNachAltersgruppen> einwohnerMap = new HashMap<String, EinwohnerNachAltersgruppen>();
		// 5. Iteriere nur einmal
		for (EinwohnerNachAltersgruppen einwohner : einwohnerList) {
			einwohnerMap.put(Integer.toString(einwohner.getNr()), einwohner);
		}
		// 6. reichere die notwendigen Informationen um Schulen an
		SchulenInKoeln schulenInKoeln = new AskForSchulenInKoeln()
				.getSchulenInKoeln();
		// 7. nun alles in den properties unterbringen
		List<Feature> featureList = featureCollection.getFeatures();
		for (Feature feature : featureList) {
			Map<String, Object> properties = feature.getProperties();
			String ref = (String) properties.get("ref");
			int nr = Integer.parseInt(ref);
			SchuelerImStadtteil schuelerImStadtteil = schuelerMap.get(ref);
			EinwohnerNachAltersgruppen einwohner = einwohnerMap.get(ref);
			if (schuelerImStadtteil != null) {
				properties.put("schueler_allgemeinbildende_schulen",
						schuelerImStadtteil.getAllgemeinbildende_schulen());
				properties.put("schueler_grundschule",
						schuelerImStadtteil.getGrundschule());
				properties.put("schueler_hauptschule",
						schuelerImStadtteil.getHauptschule());
				properties.put("schueler_realschule",
						schuelerImStadtteil.getRealschule());
				properties.put("schueler_gymnasium",
						schuelerImStadtteil.getGymnasium());
				properties.put("schueler_gesamtschule",
						schuelerImStadtteil.getGesamtschule());
				properties.put("schueler_foerderschule",
						schuelerImStadtteil.getFoerderschule());

				double schuelerProEinwohner = (double) schuelerImStadtteil
						.getAllgemeinbildende_schulen()
						/ (double) einwohner.getEinwohnerInsgesamt() * 100;
				properties.put("schueler_allgemeinbildende_schulen_proz",
						df.format(schuelerProEinwohner));
				schuelerProEinwohner = (double) schuelerImStadtteil
						.getGrundschule()
						/ (double) einwohner.getEinwohnerInsgesamt() * 100;
				properties.put("schueler_grundschule_proz",
						df.format(schuelerProEinwohner));
				schuelerProEinwohner = (double) schuelerImStadtteil
						.getHauptschule()
						/ (double) einwohner.getEinwohnerInsgesamt() * 100;
				properties.put("schueler_hauptschule_proz",
						df.format(schuelerProEinwohner));
				schuelerProEinwohner = (double) schuelerImStadtteil
						.getRealschule()
						/ (double) einwohner.getEinwohnerInsgesamt() * 100;
				properties.put("schueler_realschule_proz",
						df.format(schuelerProEinwohner));
				schuelerProEinwohner = (double) schuelerImStadtteil
						.getGymnasium()
						/ (double) einwohner.getEinwohnerInsgesamt() * 100;
				properties.put("schueler_gymnasium_proz",
						df.format(schuelerProEinwohner));
				schuelerProEinwohner = (double) schuelerImStadtteil
						.getGesamtschule()
						/ (double) einwohner.getEinwohnerInsgesamt() * 100;
				properties.put("schueler_gesamtschule_proz",
						df.format(schuelerProEinwohner));
				schuelerProEinwohner = (double) schuelerImStadtteil
						.getFoerderschule()
						/ (double) einwohner.getEinwohnerInsgesamt() * 100;
				properties.put("schueler_foerderschule_proz",
						df.format(schuelerProEinwohner));

				properties.put("schulen_allgemeinbildende_schulen",
						new SchulenImStadtteil(schulenInKoeln)
								.getAnzahlSchulenJeStadtteil(nr));
				properties.put("schulen_grundschule", new SchulenImStadtteil(
						schulenInKoeln).getAnzahlSchulartJeStadtteil(nr,
						SchulenImStadtteil.Head.grundschule.key()));
				properties.put("schulen_realschule", new SchulenImStadtteil(
						schulenInKoeln).getAnzahlSchulartJeStadtteil(nr,
						SchulenImStadtteil.Head.realschule.key()));
				properties.put("schulen_foerderschule", new SchulenImStadtteil(
						schulenInKoeln).getAnzahlSchulartJeStadtteil(nr,
						SchulenImStadtteil.Head.foerderschule.key()));
				properties.put("schulen_gymnasium", new SchulenImStadtteil(
						schulenInKoeln).getAnzahlSchulartJeStadtteil(nr,
						SchulenImStadtteil.Head.gymnasium.key()));
				properties.put("schulen_hauptschule", new SchulenImStadtteil(
						schulenInKoeln).getAnzahlSchulartJeStadtteil(nr,
						SchulenImStadtteil.Head.hauptschule.key()));
				properties.put("schulen_gesamtschule", new SchulenImStadtteil(
						schulenInKoeln).getAnzahlSchulartJeStadtteil(nr,
						SchulenImStadtteil.Head.gesamtschule.key()));
				properties.put("schulen_berufskolleg", new SchulenImStadtteil(
						schulenInKoeln).getAnzahlSchulartJeStadtteil(nr,
						SchulenImStadtteil.Head.berufskolleg.key()));
				properties
						.put("schulen_zweiterBildungsweg",
								new SchulenImStadtteil(schulenInKoeln)
										.getAnzahlSchulartJeStadtteil(
												nr,
												SchulenImStadtteil.Head.zweiterBildungsweg
														.key()));
				properties
						.put("schulen_freieWaldorfschule",
								new SchulenImStadtteil(schulenInKoeln)
										.getAnzahlSchulartJeStadtteil(
												nr,
												SchulenImStadtteil.Head.freieWaldorfschule
														.key()));

			}
		}
	}

	/**
	 * get GeoJson - String
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	public String getString() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(featureCollection);
	}

}
