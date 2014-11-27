package de.illilli.opengis.bo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.geojson.GeoJsonObject;
import org.geojson.GeometryCollection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opengis.dto.PlanetOsmLine;
import de.illilli.opengis.feature.GeometrieDeserializerGeoJson;

public class PlanetOsmLineBo implements PlanetOsmBo {

	private String id;
	private Map<String, Object> properties;
	private String type;
	private GeometryCollection geometryCollection;

	public PlanetOsmLineBo(PlanetOsmLine planetOsmLine) {
		// set id
		id = Long.toString(planetOsmLine.getOsm_id());
		// set properties
		properties = new HashMap<String, Object>();
		properties.put("bicycle", planetOsmLine.getBicycle());
		properties.put("foot", planetOsmLine.getFoot());
		properties.put("highway", planetOsmLine.getHighway());
		properties.put("operator", planetOsmLine.getOperator());
		properties.put("ref", planetOsmLine.getRef());
		properties.put("highway", planetOsmLine.getHighway());
		properties.put("route", planetOsmLine.getRoute());
		properties.put("surface", planetOsmLine.getSurface());
		properties.put("tracktype", planetOsmLine.getTracktype());
		properties.put("width", planetOsmLine.getWidth());
		// set geometry
		geometryCollection = new GeometryCollection();

		GeometrieDeserializerGeoJson geometrieDeserializer;
		try {
			geometrieDeserializer = new GeometrieDeserializerGeoJson(planetOsmLine.getWay());
			GeoJsonObject geometry = geometrieDeserializer.getGeometry();
			geometryCollection.add(geometry);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public Map<String, Object> getProperties() {
		return properties;
	}

	/**
	 * return the fist geometry out of the geometryCollection.
	 */
	@Override
	public GeoJsonObject getGeometry() {
		return geometryCollection;
	}

	@Override
	public String getType() {
		return type;
	}

}
