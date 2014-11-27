package de.illilli.opengis.odk.bo;

import de.illilli.opengis.odk.bo.csv.EnergieSchuleKoeln;
import de.illilli.opengis.odk.bo.json.Feature;

public class SchuleInKoelnMitEnergie {

	private Feature schule;
	private EnergieSchuleKoeln energie;

	public SchuleInKoelnMitEnergie(Feature schule, EnergieSchuleKoeln energie) {
		this.schule = schule;
		this.energie = energie;
	}

	public Feature getSchule() {
		return schule;
	}

	public EnergieSchuleKoeln getEnergie() {
		return energie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((energie == null) ? 0 : energie.hashCode());
		result = prime * result + ((schule == null) ? 0 : schule.hashCode());
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
		SchuleInKoelnMitEnergie other = (SchuleInKoelnMitEnergie) obj;
		if (energie == null) {
			if (other.energie != null)
				return false;
		} else if (!energie.equals(other.energie))
			return false;
		if (schule == null) {
			if (other.schule != null)
				return false;
		} else if (!schule.equals(other.schule))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SchuleInKoelnMitEnergie [schule=" + schule + ", energie="
				+ energie + "]";
	}

}
