package de.illilli.opengis.feature;

import java.util.ArrayList;
import java.util.List;

import org.geojson.Feature;

import de.illilli.opengis.bo.PlanetOsmBo;

public class GeojsonJacksonOsmFeature implements PlanetOsmFeature {

	List<Feature> featureList;

	public GeojsonJacksonOsmFeature(List<PlanetOsmBo> planetOsmBoList) {
		featureList = new ArrayList<Feature>();
		for (PlanetOsmBo bo : planetOsmBoList) {
			// set feature
			Feature feature = new Feature();
			feature.setId(bo.getId());
			feature.setProperties(bo.getProperties());
			feature.setGeometry(bo.getGeometry());
			featureList.add(feature);
		}
	}

	@Override
	public List<Feature> getFeatureList() {
		return featureList;
	}

}
