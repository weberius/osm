package de.illilli.opengis.odk.bo;

import de.illilli.opengis.odk.bo.csv.EnergieSchuleKoeln;
import de.illilli.opengis.odk.bo.json.Feature;
import de.illilli.opengis.odk.bo.json.FieldAliases;

public class SchuleInKoelnMitEnergieBo extends SchuleInKoelnBo {

	public SchuleInKoelnMitEnergieBo(Feature feature,
			FieldAliases fieldAliases, EnergieSchuleKoeln energie) {
		super(feature, fieldAliases);
		properties.put(EnergieSchuleKoeln.Head.we.key(), energie.getWe());
		properties.put(EnergieSchuleKoeln.Head.adresse.key(),
				energie.getAdresse());
		properties.put(EnergieSchuleKoeln.Head.bemerkung.key(),
				energie.getBemerkung());
		properties.put(EnergieSchuleKoeln.Head.grundflaeche.key(),
				energie.getGrundflaeche());
		properties.put(EnergieSchuleKoeln.Head.heizung_ekw.key(),
				energie.getHeizung_ekw());
		properties.put(
				EnergieSchuleKoeln.Head.heizung_ekw_differenz_vergleichswert
						.key(), energie
						.getHeizung_ekw_differenz_vergleichswert());
		properties.put(
				EnergieSchuleKoeln.Head.heizung_ekw_differenz_vorjahr.key(),
				energie.getHeizung_ekw_differenz_vorjahr());
		properties.put(EnergieSchuleKoeln.Head.heizung_energietraeger.key(),
				energie.getHeizung_energietraeger());
		properties.put(EnergieSchuleKoeln.Head.objektbezeichnung.key(),
				energie.getObjektbezeichnung());
		properties.put(
				EnergieSchuleKoeln.Head.strom_differenz_vergleichswert.key(),
				energie.getStrom_differenz_vergleichswert());
		properties.put(EnergieSchuleKoeln.Head.strom_differenz_vorjahr.key(),
				energie.getStrom_differenz_vorjahr());
		properties.put(EnergieSchuleKoeln.Head.strom_ekw.key(),
				energie.getStrom_ekw());
		properties.put(
				EnergieSchuleKoeln.Head.wasser_differenz_vergleichswert.key(),
				energie.getWasser_differenz_vergleichswert());
		properties.put(EnergieSchuleKoeln.Head.wasser_ekw.key(),
				energie.getWasser_ekw());
		properties.put(
				EnergieSchuleKoeln.Head.wasser_ekw_differenz_vorjahr.key(),
				energie.getWasser_ekw_differenz_vorjahr());
		properties.put(EnergieSchuleKoeln.Head.we.key(), energie.getWe());
	}

}
