package de.illilli.opengis.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.GeometryCollection;
import org.geojson.Point;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.opengis.bo.PlanetOsmPointDao;
import de.illilli.opengis.dto.PlanetOsmPoint;
import de.illilli.opengis.feature.GeojsonJacksonOsmFeature;
import de.illilli.opengis.feature.PlanetOsmFeature;
import de.illilli.opengis.jdbc.query.AskForKioske;
import de.illilli.opengis.jdbc.query.AskForSupermarket;

/**
 * 
 * <pre>
 * select osm_id, name, shop, ST_AsText(ST_Transform(way,4326))
 * from planet_osm_point
 * where shop like '%kiosk%';
 * </pre>
 * 
 * @author wolfram
 * 
 */
@Path("/shop")
public class OsmShopService {

	private static final Logger logger = Logger.getLogger(OsmShopService.class);

	public OsmShopService() {
	}

	/**
	 * <a href="http://localhost:8090/osm/dataservice/shop/kiosk">http://localhost:8090/osmdataservice/shop/kiosk</a>
	 * 
	 * @return
	 * @throws SQLException
	 * @throws JsonProcessingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("kiosk")
	public String getKiosk() throws SQLException, JsonProcessingException {
		logger.debug("requesting kiosk");
		List<PlanetOsmPoint> pois = new AskForKioske().getPois();
		// 2. User Dao for converting to Bo
		PlanetOsmPointDao planetOsmPointDao = new PlanetOsmPointDao(pois);
		// 3. change to feature List
		PlanetOsmFeature geojsonJacksonOsmFeature = new GeojsonJacksonOsmFeature(planetOsmPointDao.getPlanetOsmBoList());
		List<Feature> featureList = geojsonJacksonOsmFeature.getFeatureList();
		// 4. Prepare FeatureCollection; other features can be added.
		FeatureCollection featureCollection = new FeatureCollection();
		for (Feature feature : featureList) {
			featureCollection.add(feature);
		}
		logger.debug("return " + pois.size() + " of pois");
		// 5. get GeoJson - String
		return new ObjectMapper().writeValueAsString(featureCollection);
	}

	/**
	 * Bsp.: <a href=
	 * "http://localhost:8090/osm/dataservice/shop/kioskxyz?centerx=50.94135&centery=6.95819&upperleftx=50.949180964446164&upperlefty=6.969194412231444"
	 * >Köln</a>
	 * 
	 * @param request
	 * @return
	 * @throws SQLException
	 * @throws JsonProcessingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("kioskxyz")
	public String getKiosk(@Context HttpServletRequest request) throws SQLException, JsonProcessingException {
		// 1. get latlng from parameter
		String centerx = request.getParameter("centerx");
		String centery = request.getParameter("centery");
		String upperleftx = request.getParameter("upperleftx");
		String upperlefty = request.getParameter("upperlefty");
		String q = request.getParameter("q");
		logger.debug("requesting q: '" + q + "'");
		logger.debug("requesting kioskxyz (" + centerx + ":" + centery + ";" + upperleftx + ":" + upperlefty + ")");
		List<PlanetOsmPoint> pois = new AskForKioske(centerx, centery, upperleftx, upperlefty).getPois();
		// 2. User Dao for converting to Bo
		PlanetOsmPointDao planetOsmPointDao = new PlanetOsmPointDao(pois);
		// 3. change to feature List
		PlanetOsmFeature geojsonJacksonOsmFeature = new GeojsonJacksonOsmFeature(planetOsmPointDao.getPlanetOsmBoList());
		List<Feature> featureList = geojsonJacksonOsmFeature.getFeatureList();
		// 4. Prepare FeatureCollection; other features can be added.
		FeatureCollection featureCollection = new FeatureCollection();
		for (Feature feature : featureList) {
			featureCollection.add(feature);
		}
		// 5. get GeoJson - String
		logger.debug("return " + pois.size() + " of pois");
		return new ObjectMapper().writeValueAsString(featureCollection);
	}

	/**
	 * Die Form der Antwort;
	 * 
	 * <pre>
	 * [{"loc":[41.507149,13.172994],"title":"chocolate"},{"loc":[41.847149,14.132994],"title":"coral"},{"loc":[41.21919,13.062145],"title":"cyan"}]
	 * </pre>
	 * 
	 * @param request
	 * @return
	 * @throws SQLException
	 * @throws JsonProcessingException
	 */

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("kioskbyname")
	public String getKioskByName(@Context HttpServletRequest request) throws SQLException, JsonProcessingException {
		String name = request.getParameter("q");
		logger.debug("requesting q: '" + name + "'");
		List<PlanetOsmPoint> pois = new AskForKioske(name).getPois();
		// 2. User Dao for converting to Bo
		PlanetOsmPointDao planetOsmPointDao = new PlanetOsmPointDao(pois);
		// 3. change to feature List
		PlanetOsmFeature geojsonJacksonOsmFeature = new GeojsonJacksonOsmFeature(planetOsmPointDao.getPlanetOsmBoList());
		List<Feature> featureList = geojsonJacksonOsmFeature.getFeatureList();
		// 4. Prepare FeatureCollection; other features can be added.
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		boolean first = true;
		for (Feature feature : featureList) {
			// {"loc":[41.507149,13.172994],"title":"chocolate"}
			if (!first) {
				sb.append(",");
			}
			first = false;
			sb.append("{");
			sb.append("\"loc\":[");
			GeometryCollection geometryCollection = (GeometryCollection) feature.getGeometry();
			Point point = (Point) geometryCollection.getGeometries().get(0);
			sb.append(point.getCoordinates().getLatitude());
			sb.append(",");
			sb.append(point.getCoordinates().getLongitude());
			sb.append("],");
			sb.append("\"title\":\"");
			sb.append(feature.getProperties().get("name"));
			sb.append("\"");
			sb.append("}");
		}
		sb.append("]");

		// 5. get GeoJson - String
		logger.debug("return " + sb.toString());
		return sb.toString();
	}

	/**
	 * <a href="http://localhost:8090/osm/dataservice/shop/supermarket">http://localhost:8090/osmdataservice/shop/kiosk</a>
	 * 
	 * @return
	 * @throws SQLException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("supermarket")
	public String getSupermarket() throws SQLException, JsonProcessingException {
		logger.debug("requesting supermarket");
		List<PlanetOsmPoint> pois = new AskForSupermarket().getPois();
		// 2. User Dao for converting to Bo
		PlanetOsmPointDao planetOsmPointDao = new PlanetOsmPointDao(pois);
		// 3. change to feature List
		PlanetOsmFeature geojsonJacksonOsmFeature = new GeojsonJacksonOsmFeature(planetOsmPointDao.getPlanetOsmBoList());
		List<Feature> featureList = geojsonJacksonOsmFeature.getFeatureList();
		// 4. Prepare FeatureCollection; other features can be added.
		FeatureCollection featureCollection = new FeatureCollection();
		for (Feature feature : featureList) {
			featureCollection.add(feature);
		}
		logger.debug("return " + pois.size() + " of pois");
		// 5. get GeoJson - String
		return new ObjectMapper().writeValueAsString(featureCollection);

	}

	/**
	 * <p>
	 * Diese Methode erlaubt es verschiedene Supermaerkte abzufragen. Dabei muss anstatt {market} ein zulaessiger Supermarkt-Name stehen; bsp: rewe,
	 * edeka, aldi, netto etc.
	 * </p>
	 * <a href="http://localhost:8090/osm/dataservice/shop/supermarket/{market}">http://localhost:8090/osmdataservice/shop/kiosk</a>
	 * 
	 * @return
	 * @throws SQLException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("supermarket/{market}")
	public String getSupermarket(@PathParam("market") String market) throws SQLException, JsonProcessingException {
		logger.debug("requesting supermarket: " + market);

		List<PlanetOsmPoint> pois = new AskForSupermarket(market).getPois();
		// 2. User Dao for converting to Bo
		PlanetOsmPointDao planetOsmPointDao = new PlanetOsmPointDao(pois);
		// 3. change to feature List
		PlanetOsmFeature geojsonJacksonOsmFeature = new GeojsonJacksonOsmFeature(planetOsmPointDao.getPlanetOsmBoList());
		List<Feature> featureList = geojsonJacksonOsmFeature.getFeatureList();
		// 4. Prepare FeatureCollection; other features can be added.
		FeatureCollection featureCollection = new FeatureCollection();
		for (Feature feature : featureList) {
			featureCollection.add(feature);
		}
		// 5. get GeoJson - String
		logger.debug("return " + pois.size() + " of pois");
		return new ObjectMapper().writeValueAsString(featureCollection);

	}
}
