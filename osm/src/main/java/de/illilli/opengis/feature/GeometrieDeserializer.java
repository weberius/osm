package de.illilli.opengis.feature;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import org.geojson.LngLatAlt;

/**
 * Diese Klasse verwandelt einen String aus
 * <code> ST_AsText(ST_Transform(way, 4326))</code> in eine Liste aus LngLatAlt
 * - Objekten.
 *
 * @see LngLatAlt
 */
public class GeometrieDeserializer {

	private List<List<LngLatAlt>> lngLatAltListList;
	private String type;
	String way;

	public static final String POINT = "Point";
	public static final String MULTIPOINT = "MultiPoint";
	public static final String POLYGON = "Polygon";
	public static final String MULTIPOLYGON = "MultiPolygon";
	public static final String LINESTRING = "LineString";
	public static final String MULTILINESTRING = "MultiLineString";

	public static final String START = "((";
	public static final String END = "))";
	public static final String MULTIDELIM = "),(";

	static int counter = 0;

	public GeometrieDeserializer(String way) {
		this.way = way;
		lngLatAltListList = new ArrayList<List<LngLatAlt>>();
		if (way == null) {
			return;
		}
		deserialize();
	}

	void deserialize() {

		// 1. die Daten herausschaelen
		StringBuffer sb = new StringBuffer(way);
		System.out.println("##### " + counter++ + " #####");
		String typeFromWay = sb.substring(0, sb.indexOf(START));
		System.out.println("typeFromWay: " + typeFromWay);
		String lnglatFromWay = sb.substring(sb.indexOf(START) + 1,
				sb.indexOf(END) + 1);
		System.out.println("longlatFromWay: " + lnglatFromWay);

		if (sb.indexOf(MULTIDELIM) > -1) {
			// 1. set correct type
			setMultiType(typeFromWay);
			// 2. analyse geometry
			String[] lnglatArray = lnglatFromWay.split(Pattern
					.quote(MULTIDELIM));
			for (String lnglat : lnglatArray) {
				if (lnglat.startsWith("(")) {
					lnglat = lnglat.substring(1, lnglat.length());
				} else if (lnglat.endsWith(")")) {
					lnglat = lnglat.substring(0, lnglat.length() - 1);
				}
				List<LngLatAlt> lngLatAltList = tokenizeLngLat(lnglat);
				lngLatAltListList.add(lngLatAltList);
			}
		} else {
			// 1. set correct type
			setType(typeFromWay);
			// 2. analyse geometry
			String lnglat = lnglatFromWay.substring(1,
					lnglatFromWay.length() - 1);
			lngLatAltListList.add(tokenizeLngLat(lnglat));
		}
	}

	/**
	 * If recognised Mulitype (Multipolygon etc.), set type for GeoJSON.
	 * Decision if Mulit-Type is not set here.
	 * 
	 * @param typeFromWay
	 */
	private void setMultiType(String typeFromWay) {
		if (POLYGON.toUpperCase().equals(typeFromWay)) {
			type = MULTIPOLYGON;
		} else if (LINESTRING.toUpperCase().equals(typeFromWay)) {
			type = MULTILINESTRING;
		} else if (POINT.toUpperCase().equals(typeFromWay)) {
			type = MULTIPOINT;
		}
	}

	/**
	 * If recognised SingleType (Polygon etc.), set type for GeoJSON. Decision
	 * if Mulit-Type is not set here.
	 * 
	 * @param typeFromWay
	 */
	private void setType(String typeFromWay) {
		if (POLYGON.toUpperCase().equals(typeFromWay)) {
			type = POLYGON;
		} else if (LINESTRING.toUpperCase().equals(typeFromWay)) {
			type = LINESTRING;
		} else if (POINT.toUpperCase().equals(typeFromWay)) {
			type = POINT;
		}
	}

	/**
	 * Tokenizes with StringTokenizer and return a List with LngLatAlt -
	 * Objects.
	 * 
	 * @param lnglat
	 *            All Data in one String; e.g: 6.78178317759263
	 *            51.284053872153,6.78336538030255 51.285947077026, ...
	 * @return List with LngLatAlt - Objects; empty if lnglat is empty or lnglat
	 *         is null.
	 * @see LngLatAlt
	 */
	private List<LngLatAlt> tokenizeLngLat(String lnglat) {
		List<LngLatAlt> lngLatAltList = new ArrayList<LngLatAlt>();
		if (lnglat == null) {
			return lngLatAltList;
		}
		// 2. anhand des Komma tokenizen
		StringTokenizer st = new StringTokenizer(lnglat, ",");
		while (st.hasMoreElements()) {
			StringBuffer longlatsb = new StringBuffer(st.nextToken());
			// 3. separieren in longitude und latitude
			Double longitude = Double.valueOf(longlatsb.substring(0,
					longlatsb.indexOf(" ")));
			Double latitude = Double.valueOf(longlatsb.substring(
					longlatsb.indexOf(" ") + 1, longlatsb.length() - 1));
			// 4. zu einem Objekt zusammensetzen
			lngLatAltList.add(new LngLatAlt(longitude, latitude));
		}
		return lngLatAltList;
	}

	/**
	 * Gibt nur den ersten Record der Liste heraus.
	 * 
	 * @return
	 */
	public List<LngLatAlt> getLngLatAlts() {
		List<LngLatAlt> lngLatAlts = new ArrayList<LngLatAlt>();
		for (List<LngLatAlt> list : lngLatAltListList) {
			lngLatAlts = list;
			break;
		}
		return lngLatAlts;
	}

	/**
	 * Gibt die komplette Liste heraus.
	 * 
	 * @return
	 */
	public List<List<LngLatAlt>> getLngLatAltList() {
		return lngLatAltListList;
	}

	/**
	 * Gibt den Typ der Geometrie heraus.
	 * 
	 * @return
	 */
	public String getTyp() {
		return type;
	}

}
