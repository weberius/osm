package de.illilli.opengis.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
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
import de.illilli.opengis.jdbc.query.AskForStadtteile;

@Path("/stadtteile")
public class OsmKoelnBoundaryService {

	private static final Logger logger = Logger
			.getLogger(OsmKoelnBoundaryService.class);

	@Context
	HttpServletRequest request;

	@Context
	HttpServletResponse response;

	/**
	 * <a href="http://localhost:8090/osm/dataservice/stadtteile/koeln"> </a>
	 * 
	 * @return
	 * @throws SQLException
	 * @throws JsonProcessingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("koeln")
	public String getStadtteile() throws SQLException, JsonProcessingException {
		// 1. get Data from DB
		String stadt = "köln";

		response.setCharacterEncoding("UTF-8");
		long before = System.currentTimeMillis();
		List<PlanetOsmPolygon> pois = new AskForStadtteile(stadt).getPois();
		// 2. User Dao for converting to Bo
		PlanetOsmPolygonDao planetOsmPolygonDao = new PlanetOsmPolygonDao(pois);
		// 3. change to feature List
		PlanetOsmFeature geojsonJacksonOsmFeature = new GeojsonJacksonOsmFeature(
				planetOsmPolygonDao.getPlanetOsmBoList());
		List<Feature> featureList = geojsonJacksonOsmFeature.getFeatureList();
		// 4. Prepare FeatureCollection; other features can be added.
		FeatureCollection featureCollection = new FeatureCollection();
		for (Feature feature : featureList) {
			featureCollection.add(feature);
		}
		// 5. get GeoJson - String
		String stadtteile = new ObjectMapper()
				.writeValueAsString(featureCollection);
		long after = System.currentTimeMillis();
		logger.debug("return Stadtteile for '" + stadt + "': " + stadtteile);
		logger.debug(new SimpleDateFormat("mm:ss.SSS").format(new Date(after
				- before)));
		return stadtteile;

	}

}
