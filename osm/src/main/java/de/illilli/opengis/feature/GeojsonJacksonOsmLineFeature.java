package de.illilli.opengis.feature;

import java.util.ArrayList;
import java.util.List;

import org.geojson.Feature;
import org.geojson.GeoJsonObject;

import de.illilli.opengis.bo.PlanetOsmBo;

/**
 * Diese Klasse fasst alle geometry-Punkte zusammen, sodass eine Linie am Stueck ausgeliefert werden kann.
 */
public class GeojsonJacksonOsmLineFeature implements PlanetOsmFeature {

	List<Feature> featureList;

	public GeojsonJacksonOsmLineFeature(List<PlanetOsmBo> planetOsmBoList) {
		featureList = new ArrayList<Feature>();
		boolean firstRow = true;
		GeoJsonObject geometry = null;
		Feature feature = new Feature();
		for (PlanetOsmBo bo : planetOsmBoList) {
			// set feature
			if (firstRow) {
				feature.setId(bo.getId());
				feature.setProperties(bo.getProperties());
			}
			feature.setGeometry(geometry);
		}

		featureList.add(feature);
	}

	@Override
	public List<Feature> getFeatureList() {
		return featureList;
	}

}
