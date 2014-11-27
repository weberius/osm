package de.illilli.opengis.dto;

public class PlanetOsmLine {
	private long osm_id;
	private String bicycle;
	private String foot;
	private String highway;
	private String operator;
	private String ref;
	private String route;
	private String surface;
	private String tracktype;
	private String width;
	private String way;

	public long getOsm_id() {
		return osm_id;
	}

	public void setOsm_id(long osm_id) {
		this.osm_id = osm_id;
	}

	public String getBicycle() {
		return bicycle;
	}

	public void setBicycle(String bicycle) {
		this.bicycle = bicycle;
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

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
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
		result = prime * result + ((bicycle == null) ? 0 : bicycle.hashCode());
		result = prime * result + ((foot == null) ? 0 : foot.hashCode());
		result = prime * result + ((highway == null) ? 0 : highway.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + (int) (osm_id ^ (osm_id >>> 32));
		result = prime * result + ((ref == null) ? 0 : ref.hashCode());
		result = prime * result + ((route == null) ? 0 : route.hashCode());
		result = prime * result + ((surface == null) ? 0 : surface.hashCode());
		result = prime * result + ((tracktype == null) ? 0 : tracktype.hashCode());
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
		PlanetOsmLine other = (PlanetOsmLine) obj;
		if (bicycle == null) {
			if (other.bicycle != null) {
				return false;
			}
		} else if (!bicycle.equals(other.bicycle)) {
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
		if (operator == null) {
			if (other.operator != null) {
				return false;
			}
		} else if (!operator.equals(other.operator)) {
			return false;
		}
		if (osm_id != other.osm_id) {
			return false;
		}
		if (ref == null) {
			if (other.ref != null) {
				return false;
			}
		} else if (!ref.equals(other.ref)) {
			return false;
		}
		if (route == null) {
			if (other.route != null) {
				return false;
			}
		} else if (!route.equals(other.route)) {
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
		return "PlanetOsmLine [osm_id=" + osm_id + ", bicycle=" + bicycle + ", foot=" + foot + ", highway=" + highway + ", operator=" + operator + ", ref="
				+ ref + ", route=" + route + ", surface=" + surface + ", tracktype=" + tracktype + ", width=" + width + ", way=" + way + "]";
	}

}
