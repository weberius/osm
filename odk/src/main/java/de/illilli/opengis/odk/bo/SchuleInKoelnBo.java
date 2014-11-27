package de.illilli.opengis.odk.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.geojson.GeoJsonObject;
import org.geojson.GeometryCollection;
import org.geojson.LngLatAlt;
import org.geojson.Point;

import de.illilli.opengis.odk.bo.json.Feature;
import de.illilli.opengis.odk.bo.json.FieldAliases;

/**
 * Diese Klasse setzt die Werte in ein GeoJson - Objekt um
 *
 */
public class SchuleInKoelnBo implements GeoJsonBo {

	private static final Logger logger = Logger
			.getLogger(SchuleInKoelnBo.class);

	private String id;
	Map<String, Object> properties;
	private String type;
	private GeometryCollection geometryCollection;

	public SchuleInKoelnBo(Feature feature, FieldAliases fieldAliases) {
		id = feature.getAttributes().getObjectid();
		type = "Point";
		properties = new HashMap<String, Object>();
		properties.put(fieldAliases.getStadtbezirk(), feature.getAttributes()
				.getStadtbezirk());
		properties.put(fieldAliases.getAdresse(), feature.getAttributes()
				.getAdresse());
		properties.put(fieldAliases.getName(), feature.getAttributes()
				.getName());
		properties.put(fieldAliases.getNrStadtbezirk(), feature.getAttributes()
				.getNrStadtbezirk());
		properties.put(fieldAliases.getNrStadtteil(), feature.getAttributes()
				.getNrStadtteil());
		properties.put(fieldAliases.getPostzustellbezirk(), feature
				.getAttributes().getPostzustellbezirk());
		properties.put(fieldAliases.getSchulart(), feature.getAttributes()
				.getSchulart());
		properties.put(fieldAliases.getSchulname(), feature.getAttributes()
				.getSchulname());
		properties.put(fieldAliases.getSchulstrasse(), feature.getAttributes()
				.getSchulstrasse());
		properties.put(fieldAliases.getSchultyp(), feature.getAttributes()
				.getSchultyp());
		properties.put(fieldAliases.getStadtbezirk(), feature.getAttributes()
				.getStadtbezirk());
		properties.put(fieldAliases.getStadtteil(), feature.getAttributes()
				.getStadtteil());
		properties.put(fieldAliases.getTraeger(), feature.getAttributes()
				.getTraeger());

		geometryCollection = new GeometryCollection();
		LngLatAlt coordinates = new LngLatAlt();
		coordinates.setLatitude(feature.getGeometry().getY());
		coordinates.setLongitude(feature.getGeometry().getX());

		Point point = new Point();
		point.setCoordinates(coordinates);

		List<GeoJsonObject> geoJsonObjectList = new ArrayList<GeoJsonObject>();
		geoJsonObjectList.add(point);
		geometryCollection.setGeometries(geoJsonObjectList);
		logger.debug(this.toString());
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public Map<String, Object> getProperties() {
		return properties;
	}

	@Override
	public GeoJsonObject getGeometry() {
		return geometryCollection;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "SchuleInKoelnBo [id=" + id + ", properties=" + properties
				+ ", type=" + type + ", geometryCollection="
				+ geometryCollection + "]";
	}

}
