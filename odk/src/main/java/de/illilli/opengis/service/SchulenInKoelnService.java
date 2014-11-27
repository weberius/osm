package de.illilli.opengis.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

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

@Path("/school")
public class SchulenInKoelnService {

	private final static Logger logger = Logger
			.getLogger(SchulenInKoelnService.class);

	@Context
	HttpServletRequest request;

	@Context
	HttpServletResponse response;

	/**
	 * <a href="http://localhost:8090/odk/dataservice/school/koeln">http://
	 * localhost:8090/odkdataservice/school/koeln</a>
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("koeln")
	public String getKoeln() throws JsonParseException, JsonMappingException,
			IOException, URISyntaxException {
		// setze das Character-Encoding fuer die Antwort auf UTF-8
		response.setCharacterEncoding("UTF-8");
		logger.debug("requesting koeln");
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
		return new ObjectMapper().writeValueAsString(featureCollection);

	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("koeln/{schulart}")
	public String getKoelnBySchulart(@PathParam("schulart") String schulart)
			throws JsonParseException, JsonMappingException, IOException,
			URISyntaxException {
		logger.debug("requesting koeln");
		SchulenInKoeln schulenInKoeln = new AskForSchulenInKoeln()
				.getSchulenInKoeln();
		// 2. User Dao for converting to Bo
		SchuleInKoelnDao schulenInKoelnDao = new SchuleInKoelnDao(
				schulenInKoeln, schulart);
		// 3. change to feature List
		List<GeoJsonBo> geoJsonBoList = schulenInKoelnDao.getGeoJsonBoList();
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
		return new ObjectMapper().writeValueAsString(featureCollection);
	}

	/**
	 * <a
	 * href="http://localhost:8090/odkdataservice/school/koeln/schule/64"></a>
	 * 
	 * @param id
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@GET
	@Produces({ MediaType.TEXT_HTML })
	@Path("koeln/schule/{id}")
	public String getSchuleById(@PathParam("id") String id) {
		SchuleInKoelnMitEnergieFacade facade = new SchuleInKoelnMitEnergieFacade(
				id);
		String html = facade.getHtml();
		logger.debug("getSchuleById [" + id + "]: " + html);
		return html;
	}

}
