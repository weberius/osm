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
import de.illilli.opengis.jdbc.query.AskForAdministrativeLines;
import de.illilli.opengis.jdbc.query.AskForBicycle;
import de.illilli.opengis.jdbc.query.AskForFahrradwege;

@Path("/line")
public class OsmLineService {

	private static final Logger logger = Logger.getLogger(OsmLineService.class);

	/**
	 * <a href="http://localhost:8090/osm/dataservice/line/administrative">http:/ /localhost:8090/dataservice/osm/boundary/administrative</a>
	 * 
	 * @return
	 * @throws SQLException
	 * @throws JsonProcessingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("administrative")
	public String getAdministrative() throws SQLException, JsonProcessingException {

		int adminLevel = 6;
		// 1. get Data from DB
		List<PlanetOsmLine> pois = new AskForAdministrativeLines().getPois(adminLevel);
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
		// 5. get GeoJson - String
		return new ObjectMapper().writeValueAsString(featureCollection);
	}

	/**
	 * <a href="http://localhost:8090/osm/dataservice/line/bycicle/yes">http:/ /localhost:8090/dataservice/osm/boundary/administrative</a>
	 * 
	 * @return
	 * @throws SQLException
	 * @throws JsonProcessingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("bicycle/{bicycle}")
	public String getFahrradwege(@PathParam("bicycle") String bicycle) throws SQLException, JsonProcessingException {

		// 1. get Data from DB
		List<PlanetOsmLine> pois = new AskForFahrradwege(bicycle).getPois();
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
		// 5. get GeoJson - String
		return new ObjectMapper().writeValueAsString(featureCollection);
	}

	/**
	 * <a href="http://localhost:8090/osm/dataservice/line/bicycle">http:/ /localhost:8090/dataservice/osm/boundary/administrative</a>
	 * 
	 * @return
	 * @throws SQLException
	 * @throws JsonProcessingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("bicycle")
	public String getBicycle() throws SQLException, JsonProcessingException {

		// 1. get Data from DB
		List<PlanetOsmLine> pois = new AskForBicycle().getPois();
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
		// 5. get GeoJson - String
		return new ObjectMapper().writeValueAsString(featureCollection);
	}

}
