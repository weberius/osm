package de.illilli.opengis.odk.bo;

import java.util.Map;

import org.geojson.GeoJsonObject;

public interface GeoJsonBo {

	String getId();

	Map<String, Object> getProperties();

	GeoJsonObject getGeometry();

	String getType();

}
