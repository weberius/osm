package de.illilli.opengis.odk.bo.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FieldAliases {

	@JsonProperty("OBJECTID")
	String objectid;
	@JsonProperty("NR_STADTBEZIRK")
	String nrStadtbezirk;
	@JsonProperty("STADTBEZIRK")
	String stadtbezirk;
	@JsonProperty("NR_STADTTEIL")
	String nrStadtteil;
	@JsonProperty("STADTTEIL")
	String stadtteil;
	@JsonProperty("ADRESSE")
	String adresse;
	@JsonProperty("POSTZUSTELLBEZIRK")
	String postzustellbezirk;
	@JsonProperty("SCHULART")
	String schulart;
	@JsonProperty("SCHULTYP")
	String schultyp;
	@JsonProperty("NAME")
	String name;
	@JsonProperty("SCHULSTRASSE")
	String schulstrasse;
	@JsonProperty("SCHULNAME")
	String schulname;
	@JsonProperty("TRAEGER")
	String traeger;
	@JsonProperty("XKOOR")
	String xkoor;
	@JsonProperty("YKOOR")
	String ykoor;

	public String getObjectid() {
		return objectid;
	}

	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}

	public String getNrStadtbezirk() {
		return nrStadtbezirk;
	}

	public void setNrStadtbezirk(String nrStadtbezirk) {
		this.nrStadtbezirk = nrStadtbezirk;
	}

	public String getStadtbezirk() {
		return stadtbezirk;
	}

	public void setStadtbezirk(String stadtbezirk) {
		this.stadtbezirk = stadtbezirk;
	}

	public String getNrStadtteil() {
		return nrStadtteil;
	}

	public void setNrStadtteil(String nrStadtteil) {
		this.nrStadtteil = nrStadtteil;
	}

	public String getStadtteil() {
		return stadtteil;
	}

	public void setStadtteil(String stadtteil) {
		this.stadtteil = stadtteil;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPostzustellbezirk() {
		return postzustellbezirk;
	}

	public void setPostzustellbezirk(String postzustellbezirk) {
		this.postzustellbezirk = postzustellbezirk;
	}

	public String getSchulart() {
		return schulart;
	}

	public void setSchulart(String schulart) {
		this.schulart = schulart;
	}

	public String getSchultyp() {
		return schultyp;
	}

	public void setSchultyp(String schultyp) {
		this.schultyp = schultyp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchulstrasse() {
		return schulstrasse;
	}

	public void setSchulstrasse(String schulstrasse) {
		this.schulstrasse = schulstrasse;
	}

	public String getSchulname() {
		return schulname;
	}

	public void setSchulname(String schulname) {
		this.schulname = schulname;
	}

	public String getTraeger() {
		return traeger;
	}

	public void setTraeger(String traeger) {
		this.traeger = traeger;
	}

	public String getXkoor() {
		return xkoor;
	}

	public void setXkoor(String xkoor) {
		this.xkoor = xkoor;
	}

	public String getYkoor() {
		return ykoor;
	}

	public void setYkoor(String ykoor) {
		this.ykoor = ykoor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((nrStadtbezirk == null) ? 0 : nrStadtbezirk.hashCode());
		result = prime * result
				+ ((nrStadtteil == null) ? 0 : nrStadtteil.hashCode());
		result = prime * result
				+ ((objectid == null) ? 0 : objectid.hashCode());
		result = prime
				* result
				+ ((postzustellbezirk == null) ? 0 : postzustellbezirk
						.hashCode());
		result = prime * result
				+ ((schulart == null) ? 0 : schulart.hashCode());
		result = prime * result
				+ ((schulname == null) ? 0 : schulname.hashCode());
		result = prime * result
				+ ((schulstrasse == null) ? 0 : schulstrasse.hashCode());
		result = prime * result
				+ ((schultyp == null) ? 0 : schultyp.hashCode());
		result = prime * result
				+ ((stadtbezirk == null) ? 0 : stadtbezirk.hashCode());
		result = prime * result
				+ ((stadtteil == null) ? 0 : stadtteil.hashCode());
		result = prime * result + ((traeger == null) ? 0 : traeger.hashCode());
		result = prime * result + ((xkoor == null) ? 0 : xkoor.hashCode());
		result = prime * result + ((ykoor == null) ? 0 : ykoor.hashCode());
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
		FieldAliases other = (FieldAliases) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nrStadtbezirk == null) {
			if (other.nrStadtbezirk != null)
				return false;
		} else if (!nrStadtbezirk.equals(other.nrStadtbezirk))
			return false;
		if (nrStadtteil == null) {
			if (other.nrStadtteil != null)
				return false;
		} else if (!nrStadtteil.equals(other.nrStadtteil))
			return false;
		if (objectid == null) {
			if (other.objectid != null)
				return false;
		} else if (!objectid.equals(other.objectid))
			return false;
		if (postzustellbezirk == null) {
			if (other.postzustellbezirk != null)
				return false;
		} else if (!postzustellbezirk.equals(other.postzustellbezirk))
			return false;
		if (schulart == null) {
			if (other.schulart != null)
				return false;
		} else if (!schulart.equals(other.schulart))
			return false;
		if (schulname == null) {
			if (other.schulname != null)
				return false;
		} else if (!schulname.equals(other.schulname))
			return false;
		if (schulstrasse == null) {
			if (other.schulstrasse != null)
				return false;
		} else if (!schulstrasse.equals(other.schulstrasse))
			return false;
		if (schultyp == null) {
			if (other.schultyp != null)
				return false;
		} else if (!schultyp.equals(other.schultyp))
			return false;
		if (stadtbezirk == null) {
			if (other.stadtbezirk != null)
				return false;
		} else if (!stadtbezirk.equals(other.stadtbezirk))
			return false;
		if (stadtteil == null) {
			if (other.stadtteil != null)
				return false;
		} else if (!stadtteil.equals(other.stadtteil))
			return false;
		if (traeger == null) {
			if (other.traeger != null)
				return false;
		} else if (!traeger.equals(other.traeger))
			return false;
		if (xkoor == null) {
			if (other.xkoor != null)
				return false;
		} else if (!xkoor.equals(other.xkoor))
			return false;
		if (ykoor == null) {
			if (other.ykoor != null)
				return false;
		} else if (!ykoor.equals(other.ykoor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FieldAliases [objectid=" + objectid + ", nrStadtbezirk="
				+ nrStadtbezirk + ", stadtbezirk=" + stadtbezirk
				+ ", nrStadtteil=" + nrStadtteil + ", stadtteil=" + stadtteil
				+ ", adresse=" + adresse + ", postzustellbezirk="
				+ postzustellbezirk + ", schulart=" + schulart + ", schultyp="
				+ schultyp + ", name=" + name + ", schulstrasse="
				+ schulstrasse + ", schulname=" + schulname + ", traeger="
				+ traeger + ", xkoor=" + xkoor + ", ykoor=" + ykoor + "]";
	}

}
