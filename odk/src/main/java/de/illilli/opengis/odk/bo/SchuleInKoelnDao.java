package de.illilli.opengis.odk.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import de.illilli.opengis.odk.bo.json.Feature;
import de.illilli.opengis.odk.bo.json.FieldAliases;
import de.illilli.opengis.odk.bo.json.SchulenInKoeln;

public class SchuleInKoelnDao {

	private final static Logger logger = Logger.getLogger(SchulenInKoeln.class);
	private List<GeoJsonBo> geoJsonBoList;

	/**
	 * Verwandelt alle Schulen in eine GeoJson Liste.
	 * 
	 * @param schulenInKoeln
	 */
	public SchuleInKoelnDao(SchulenInKoeln schulenInKoeln) {
		geoJsonBoList = new ArrayList<GeoJsonBo>();
		List<Feature> features = schulenInKoeln.getFeatures();
		FieldAliases fieldAliases = schulenInKoeln.getFieldAliases();
		for (Feature feature : features) {
			logger.debug(feature.getAttributes().getSchulart());
			geoJsonBoList.add(new SchuleInKoelnBo(feature, fieldAliases));
		}
	}

	/**
	 * Verwandelt die Schulen in Koeln unterschieden nach Schulart in eine
	 * GeoJson Liste.
	 * 
	 * @param schulenInKoeln
	 * @param schulart
	 */
	public SchuleInKoelnDao(SchulenInKoeln schulenInKoeln, String schulart) {
		geoJsonBoList = new ArrayList<GeoJsonBo>();
		List<Feature> features = schulenInKoeln.getFeatures();
		FieldAliases fieldAliases = schulenInKoeln.getFieldAliases();
		for (Feature feature : features) {
			if (feature.getAttributes().getSchulart().toLowerCase()
					.equals(schulart.toLowerCase())) {
				geoJsonBoList.add(new SchuleInKoelnBo(feature, fieldAliases));
				logger.debug(feature.getAttributes().getSchulart());
			}
		}
	}

	public List<GeoJsonBo> getGeoJsonBoList() {
		return this.geoJsonBoList;
	}
}
