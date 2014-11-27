package de.illilli.opengis.service;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.geojson.Feature;
import org.geojson.FeatureCollection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.opengis.bo.PlanetOsmPolygonDao;
import de.illilli.opengis.dto.PlanetOsmPolygon;
import de.illilli.opengis.feature.GeojsonJacksonOsmFeature;
import de.illilli.opengis.feature.PlanetOsmFeature;
import de.illilli.opengis.jdbc.query.AskForAdministrativeBoundaries;
import de.illilli.opengis.jdbc.query.AskForPostalCodeBoundaries;

/**
 * <a href="http://jce.iaik.tugraz.at/sic/Products/Communication-Messaging-Security/iSaSiLk/documentation/Secure-Renegotiation">Probleme mit
 * "Connection reset by peer"</a>
 * 
 * @author ow#1115
 * 
 */
@Path("/boundary")
public class OsmBoundaryService {

	private static final Logger logger = Logger.getLogger(OsmBoundaryService.class);

	/**
	 * <a href="http://localhost:8090/osm/dataservice/boundary/administrative/6"> http://localhost:8090/dataservice/osm/boundary/administrative</a>
	 * 
	 * @return
	 * @throws SQLException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("administrative/{adminLevel}")
	public String getAdministrative(@PathParam("adminLevel") String adminLevel) throws SQLException, JsonProcessingException {
		logger.debug("requesting adminLevel " + adminLevel);

		// 1. get Data from DB
		List<PlanetOsmPolygon> pois = new AskForAdministrativeBoundaries(adminLevel).getPois();
		// 2. User Dao for converting to Bo
		PlanetOsmPolygonDao planetOsmLineDao = new PlanetOsmPolygonDao(pois);
		// 3. change to feature List
		PlanetOsmFeature geojsonJacksonOsmFeature = new GeojsonJacksonOsmFeature(planetOsmLineDao.getPlanetOsmBoList());
		List<Feature> featureList = geojsonJacksonOsmFeature.getFeatureList();
		// 4. Prepare FeatureCollection; other features can be added.
		FeatureCollection featureCollection = new FeatureCollection();
		for (Feature feature : featureList) {
			featureCollection.add(feature);
		}
		// 5. get GeoJson - String
		logger.debug("return adminLevel " + adminLevel + ": " + pois.size() + " of pois");
		return new ObjectMapper().writeValueAsString(featureCollection);
	}

	/**
	 * <a href="http://localhost:8090/osm/dataservice/boundary/postalcode"> http://localhost:8090/dataservice/osm/boundary/administrative</a>
	 * 
	 * @return
	 * @throws SQLException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("postalcode")
	public String getPostalCode() throws SQLException, JsonProcessingException {
		logger.debug("requesting postalcode");
		// 1. get Data from DB
		List<PlanetOsmPolygon> pois = new AskForPostalCodeBoundaries().getPois();
		// 2. User Dao for converting to Bo
		PlanetOsmPolygonDao planetOsmPolygonDao = new PlanetOsmPolygonDao(pois);
		// 3. change to feature List
		PlanetOsmFeature geojsonJacksonOsmFeature = new GeojsonJacksonOsmFeature(planetOsmPolygonDao.getPlanetOsmBoList());
		List<Feature> featureList = geojsonJacksonOsmFeature.getFeatureList();
		// 4. Prepare FeatureCollection; other features can be added.
		FeatureCollection featureCollection = new FeatureCollection();
		for (Feature feature : featureList) {
			featureCollection.add(feature);
		}
		// 5. get GeoJson - String
		logger.debug("return postalcode: " + pois.size() + " of pois");
		return new ObjectMapper().writeValueAsString(featureCollection);
	}

}
