package de.illilli.opengis.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

/**
 * This class retrieves boundaries for Stadtteile Koeln from OSM Database. It
 * caches them to filesystem the first time used to fasten the system. It is
 * even possible to lay the geoJson-File to resources-Folder.
 * 
 * @author wolfram
 *
 */
public class KoelnBoundaryStadtteileFacade {

	private static final Logger logger = Logger
			.getLogger(KoelnBoundaryStadtteileFacade.class);

	private FeatureCollection featureCollection = new FeatureCollection();
	private static final String STADTTEILE_KOELN = "stadtteile-koeln.json";
	private String getString;

	public KoelnBoundaryStadtteileFacade(String stadt) {

		URL url = this.getClass().getClassLoader()
				.getResource(STADTTEILE_KOELN);

		File file = null;
		try {
			file = new File(url.toURI());
		} catch (URISyntaxException e1) {
			logger.error(e1);
		}
		if (file != null && file.exists()) {
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(file));
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();
				getString = sb.toString();
			} catch (FileNotFoundException e) {
				logger.error(e);
			} catch (IOException e) {
				logger.error(e);
			}
		} else {
			// 1. get Data from DB
			long before = System.currentTimeMillis();
			List<PlanetOsmPolygon> pois;
			try {
				pois = new AskForStadtteile(stadt).getPois();
				// 2. User Dao for converting to Bo
				PlanetOsmPolygonDao planetOsmPolygonDao = new PlanetOsmPolygonDao(
						pois);
				// 3. change to feature List
				PlanetOsmFeature geojsonJacksonOsmFeature = new GeojsonJacksonOsmFeature(
						planetOsmPolygonDao.getPlanetOsmBoList());
				List<Feature> featureList = geojsonJacksonOsmFeature
						.getFeatureList();
				// 4. Prepare FeatureCollection; other features can be added.
				for (Feature feature : featureList) {
					featureCollection.add(feature);
				}
				getString = new ObjectMapper()
						.writeValueAsString(featureCollection);
			} catch (SQLException e) {
				logger.error(e);
			} catch (JsonProcessingException e) {
				logger.error(e);
			}

			long after = System.currentTimeMillis();
			logger.debug(new SimpleDateFormat("mm:ss.SSS").format(new Date(
					after - before)));
		}

	}

	/**
	 * get GeoJson - String
	 * 
	 * @return
	 */
	public String getString() {
		return getString;
	}
}
