package de.illilli.opengis.odk.bo.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpatialReference {

	@JsonProperty("wkid")
	String wkid;

	public String getWkid() {
		return wkid;
	}

	public void setWkid(String wkid) {
		this.wkid = wkid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((wkid == null) ? 0 : wkid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpatialReference other = (SpatialReference) obj;
		if (wkid == null) {
			if (other.wkid != null)
				return false;
		} else if (!wkid.equals(other.wkid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SpatialReference [wkid=" + wkid + "]";
	}

}
