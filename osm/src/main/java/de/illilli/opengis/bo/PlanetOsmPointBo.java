package de.illilli.opengis.bo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.geojson.GeoJsonObject;
import org.geojson.GeometryCollection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opengis.dto.PlanetOsmPoint;
import de.illilli.opengis.feature.GeometrieDeserializerGeoJson;

public class PlanetOsmPointBo implements PlanetOsmBo {

	private String id;
	private Map<String, Object> properties;
	private String type;
	private GeometryCollection geometryCollection;

	public PlanetOsmPointBo(PlanetOsmPoint planetOsmPoint) {
		// set id
		id = Long.toString(planetOsmPoint.getOsm_id());
		// set properties
		properties = new HashMap<String, Object>();
		properties.put("shop", planetOsmPoint.getShop());
		properties.put("imageFile", planetOsmPoint.getImageFile());
		properties.put("name", planetOsmPoint.getName());
		// set geometry
		geometryCollection = new GeometryCollection();
		GeometrieDeserializerGeoJson geometrieDeserializer;
		try {
			geometrieDeserializer = new GeometrieDeserializerGeoJson(planetOsmPoint.getWay());
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
