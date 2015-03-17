package de.illilli.opengis.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.log4j.Logger;
import org.geojson.Feature;
import org.geojson.FeatureCollection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.opengis.odk.arcgis.AskForSchulenInKoeln;
import de.illilli.opengis.odk.bo.GeoJsonBo;
import de.illilli.opengis.odk.bo.SchuleInKoelnDao;
import de.illilli.opengis.odk.bo.json.SchulenInKoeln;

public class SchulenInKoelnFacade {

	private static final Logger logger = Logger
			.getLogger(SchulenInKoelnFacade.class);

	private String json;

	public SchulenInKoelnFacade() throws JsonParseException,
			JsonMappingException, IOException, URISyntaxException {
		SchulenInKoeln schulenInKoeln = new AskForSchulenInKoeln()
				.getSchulenInKoeln();
		// 2. User Dao for converting to Bo
		SchuleInKoelnDao planetOsmPointDao = new SchuleInKoelnDao(
				schulenInKoeln);
		// 3. change to feature List
		List<GeoJsonBo> geoJsonBoList = planetOsmPointDao.getGeoJsonBoList();
		// 4. Prepare FeatureCollection; other features can be added.
		FeatureCollection featureCollection = new FeatureCollection();
		for (GeoJsonBo geoJsonBo : geoJsonBoList) {
			Feature feature = new Feature();
			feature.setGeometry(geoJsonBo.getGeometry());
			feature.setProperties(geoJsonBo.getProperties());
			feature.setId(geoJsonBo.getId());
			featureCollection.add(feature);
		}

		logger.debug("return " + geoJsonBoList.size() + " of pois");
		// 5. get GeoJson - String
		json = new ObjectMapper().writeValueAsString(featureCollection);
	}

	public String getString() {
		return json.toString();
	}

}
