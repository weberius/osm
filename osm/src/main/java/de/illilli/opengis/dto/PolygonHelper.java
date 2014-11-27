package de.illilli.opengis.dto;

import java.util.StringTokenizer;

@Deprecated
public class PolygonHelper {

	private StringBuffer coordinates = new StringBuffer();
	private String type = "Polygon";
	public static final String POLYGON = "POLYGON";

	/**
	 * e.g.POLYGON((5.86631528177507 51.051103481149,5.86637223496408 51.0511161870149,5.86638768598697 51.0511196881862,5.86681645187208
	 * 51.0512155750013,5.86691733267849 51.0512381066799))
	 * 
	 * @param str
	 */
	@Deprecated
	public PolygonHelper(String str) {
		// 1. die Daten herausschaelen
		StringBuffer sb = new StringBuffer(str);
		String longlat = sb.substring(POLYGON.length() + 2, sb.length() - 2);
		// 2. anhand des Komma tokenizen
		StringTokenizer st = new StringTokenizer(longlat, ",");
		for (int i = 0; st.hasMoreElements(); i++) {
			StringBuffer longlatsb = new StringBuffer(st.nextToken());
			// 3. separieren in longitude und latitude
			longlatsb.setCharAt(longlatsb.indexOf(" "), ',');
			String newFormat = longlatsb.toString();
			// 4. wieder zusammensetzen
			if (i > 0) {
				coordinates.append(", ");
			}
			coordinates.append("[");
			coordinates.append(newFormat);
			coordinates.append("]");
		}
	}

	@Deprecated
	public String getCoordinates() {
		return coordinates.toString();
	}

	@Deprecated
	public String getType() {
		return type;
	}
}
