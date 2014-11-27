package de.illilli.opengis.dto;

/**
 * Abfrage der Kioske:
 * 
 * 
 */
public class PlanetOsmPoint {

	private long osm_id;
	private String name;
	private String shop;
	private String way;
	private String imageFile;
	private static String escape = "\"";

	public String getName() {
		if (name != null && name.contains(escape)) {
			return this.name.replace(escape, "");
		} else {
			return this.name;
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public long getOsm_id() {
		return osm_id;
	}

	public void setOsm_id(long osm_id) {
		this.osm_id = osm_id;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

}
