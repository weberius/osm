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

import de.illilli.opengis.bo.PlanetOsmLineDao;
import de.illilli.opengis.dto.PlanetOsmLine;
import de.illilli.opengis.feature.GeojsonJacksonOsmFeature;
import de.illilli.opengis.feature.PlanetOsmFeature;
import de.illilli.opengis.jdbc.query.AskForAutobahn;

@Path("/roads")
public class OsmRoadsService {

	private static final Logger logger = Logger.getLogger(OsmRoadsService.class);

	/**
	 * <a href="http://localhost:8090/osm/dataservice/roads/autobahn">http:/ /localhost:8090/dataservice/osm/boundary/administrative</a>
	 * 
	 * @return
	 * @throws SQLException
	 * @throws JsonProcessingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("autobahn")
	public String getAutobahn() throws SQLException, JsonProcessingException {
		logger.debug("asking for autobahn");
		// 1. get Data from DB
		List<PlanetOsmLine> pois = new AskForAutobahn().getPois();
		// 2. User Dao for converting to Bo
		PlanetOsmLineDao planetOsmLineDao = new PlanetOsmLineDao(pois);
		// 3. change to feature List
		PlanetOsmFeature geojsonJacksonOsmFeature = new GeojsonJacksonOsmFeature(planetOsmLineDao.getPlanetOsmBoList());
		List<Feature> featureList = geojsonJacksonOsmFeature.getFeatureList();
		// 4. Prepare FeatureCollection; other features can be added.
		FeatureCollection featureCollection = new FeatureCollection();
		for (Feature feature : featureList) {
			featureCollection.add(feature);
		}
		logger.debug("fetching " + featureList.size() + " of pois");
		// 5. get GeoJson - String
		return new ObjectMapper().writeValueAsString(featureCollection);
	}

	/**
	 * <a href="http://localhost:8090/osm/dataservice/roads/autobahn">http:/ /localhost:8090/dataservice/osm/boundary/administrative</a>
	 * 
	 * @return
	 * @throws SQLException
	 * @throws JsonProcessingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("autobahn/{id}")
	public String getAutobahn(@PathParam("id") String id) throws SQLException, JsonProcessingException {
		logger.debug("asking for autobahn");
		// 1. get Data from DB
		List<PlanetOsmLine> pois = new AskForAutobahn(id).getPois();
		// 2. User Dao for converting to Bo
		PlanetOsmLineDao planetOsmLineDao = new PlanetOsmLineDao(pois);
		// 3. change to feature List
		PlanetOsmFeature geojsonJacksonOsmFeature = new GeojsonJacksonOsmFeature(planetOsmLineDao.getPlanetOsmBoList());
		List<Feature> featureList = geojsonJacksonOsmFeature.getFeatureList();
		// 4. Prepare FeatureCollection; other features can be added.
		FeatureCollection featureCollection = new FeatureCollection();
		for (Feature feature : featureList) {
			featureCollection.add(feature);
		}
		logger.debug("fetching " + featureList.size() + " of pois");
		// 5. get GeoJson - String
		return new ObjectMapper().writeValueAsString(featureCollection);
	}
}
