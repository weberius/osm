package de.illilli.opengis.dto;

public class PlanetOsmRoads {

	private long osm_id;
	private String admin_level;
	private String bicycle;
	private String bridge;
	private String boundary;
	private String foot;
	private String highway;
	private String motorcar;
	private String name;
	private String population;
	private String ref;
	private String surface;
	private String tracktype;
	private String waterway;
	private String width;
	private String way;

	public long getOsm_id() {
		return osm_id;
	}

	public void setOsm_id(long osm_id) {
		this.osm_id = osm_id;
	}

	public String getAdmin_level() {
		return admin_level;
	}

	public void setAdmin_level(String admin_level) {
		this.admin_level = admin_level;
	}

	public String getBicycle() {
		return bicycle;
	}

	public void setBicycle(String bicycle) {
		this.bicycle = bicycle;
	}

	public String getBridge() {
		return bridge;
	}

	public void setBridge(String bridge) {
		this.bridge = bridge;
	}

	public String getBoundary() {
		return boundary;
	}

	public void setBoundary(String boundary) {
		this.boundary = boundary;
	}

	public String getFoot() {
		return foot;
	}

	public void setFoot(String foot) {
		this.foot = foot;
	}

	public String getHighway() {
		return highway;
	}

	public void setHighway(String highway) {
		this.highway = highway;
	}

	public String getMotorcar() {
		return motorcar;
	}

	public void setMotorcar(String motorcar) {
		this.motorcar = motorcar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public String getTracktype() {
		return tracktype;
	}

	public void setTracktype(String tracktype) {
		this.tracktype = tracktype;
	}

	public String getWaterway() {
		return waterway;
	}

	public void setWaterway(String waterway) {
		this.waterway = waterway;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin_level == null) ? 0 : admin_level.hashCode());
		result = prime * result + ((bicycle == null) ? 0 : bicycle.hashCode());
		result = prime * result + ((boundary == null) ? 0 : boundary.hashCode());
		result = prime * result + ((bridge == null) ? 0 : bridge.hashCode());
		result = prime * result + ((foot == null) ? 0 : foot.hashCode());
		result = prime * result + ((highway == null) ? 0 : highway.hashCode());
		result = prime * result + ((motorcar == null) ? 0 : motorcar.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (osm_id ^ (osm_id >>> 32));
		result = prime * result + ((population == null) ? 0 : population.hashCode());
		result = prime * result + ((ref == null) ? 0 : ref.hashCode());
		result = prime * result + ((surface == null) ? 0 : surface.hashCode());
		result = prime * result + ((tracktype == null) ? 0 : tracktype.hashCode());
		result = prime * result + ((waterway == null) ? 0 : waterway.hashCode());
		result = prime * result + ((way == null) ? 0 : way.hashCode());
		result = prime * result + ((width == null) ? 0 : width.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PlanetOsmRoads other = (PlanetOsmRoads) obj;
		if (admin_level == null) {
			if (other.admin_level != null) {
				return false;
			}
		} else if (!admin_level.equals(other.admin_level)) {
			return false;
		}
		if (bicycle == null) {
			if (other.bicycle != null) {
				return false;
			}
		} else if (!bicycle.equals(other.bicycle)) {
			return false;
		}
		if (boundary == null) {
			if (other.boundary != null) {
				return false;
			}
		} else if (!boundary.equals(other.boundary)) {
			return false;
		}
		if (bridge == null) {
			if (other.bridge != null) {
				return false;
			}
		} else if (!bridge.equals(other.bridge)) {
			return false;
		}
		if (foot == null) {
			if (other.foot != null) {
				return false;
			}
		} else if (!foot.equals(other.foot)) {
			return false;
		}
		if (highway == null) {
			if (other.highway != null) {
				return false;
			}
		} else if (!highway.equals(other.highway)) {
			return false;
		}
		if (motorcar == null) {
			if (other.motorcar != null) {
				return false;
			}
		} else if (!motorcar.equals(other.motorcar)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (osm_id != other.osm_id) {
			return false;
		}
		if (population == null) {
			if (other.population != null) {
				return false;
			}
		} else if (!population.equals(other.population)) {
			return false;
		}
		if (ref == null) {
			if (other.ref != null) {
				return false;
			}
		} else if (!ref.equals(other.ref)) {
			return false;
		}
		if (surface == null) {
			if (other.surface != null) {
				return false;
			}
		} else if (!surface.equals(other.surface)) {
			return false;
		}
		if (tracktype == null) {
			if (other.tracktype != null) {
				return false;
			}
		} else if (!tracktype.equals(other.tracktype)) {
			return false;
		}
		if (waterway == null) {
			if (other.waterway != null) {
				return false;
			}
		} else if (!waterway.equals(other.waterway)) {
			return false;
		}
		if (way == null) {
			if (other.way != null) {
				return false;
			}
		} else if (!way.equals(other.way)) {
			return false;
		}
		if (width == null) {
			if (other.width != null) {
				return false;
			}
		} else if (!width.equals(other.width)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "PlanetOsmRoads [osm_id=" + osm_id + ", admin_level=" + admin_level + ", bicycle=" + bicycle + ", bridge=" + bridge + ", boundary=" + boundary
				+ ", foot=" + foot + ", highway=" + highway + ", motorcar=" + motorcar + ", name=" + name + ", population=" + population + ", ref=" + ref
				+ ", surface=" + surface + ", tracktype=" + tracktype + ", waterway=" + waterway + ", width=" + width + ", way=" + way + "]";
	}

}
