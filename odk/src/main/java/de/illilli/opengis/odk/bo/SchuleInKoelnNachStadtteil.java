package de.illilli.opengis.odk.bo;

import java.util.List;

import de.illilli.opengis.odk.bo.json.Feature;
import de.illilli.opengis.odk.bo.json.SchulenInKoeln;

public class SchuleInKoelnNachStadtteil {

	public SchuleInKoelnNachStadtteil(SchulenInKoeln schulen) {
		List<Feature> featureList = schulen.getFeatures();
		for (Feature feature : featureList) {
			System.out.println(feature.toString());
		}
	}
}
