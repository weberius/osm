package de.illilli.opengis.odk.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import de.illilli.opengis.odk.bo.csv.EnergieSchuleKoeln;
import de.illilli.opengis.odk.bo.json.Feature;
import de.illilli.opengis.odk.bo.json.SchulenInKoeln;

/**
 * In dieser Klasse werden die Information zu den Schulen und den Energiewerten
 * der Schulen zusammengeführt. Die Methode ist sehr ineffektiv und ungenau. Von
 * 301/271 Datensätzen können hier nur 219 zusammengeführt werden. Wenn es
 * genauer, effektiver und schneller sein muss, ist dies die richtige Stelle, um
 * zu korrigieren.
 */
public class SchulenInKoelnMitEnergieDao {

	private static final Logger logger = Logger
			.getLogger(SchulenInKoelnMitEnergieDao.class);

	private List<SchuleInKoelnMitEnergie> schuleInKoelnMitEnergieList = new ArrayList<SchuleInKoelnMitEnergie>();

	/**
	 * Hier werden auf Basis der SchulenInKoeln und List<EnergieSchulenKoeln>
	 * Informationen, die
	 * 
	 * @param schulen
	 * @param energieSchulenInKoeln
	 */
	public SchulenInKoelnMitEnergieDao(SchulenInKoeln schulen,
			List<EnergieSchuleKoeln> energieSchulenInKoeln) {

		List<Feature> featureList = schulen.getFeatures();

		for (Feature feature : featureList) {
			for (EnergieSchuleKoeln energieSchulenKoeln : energieSchulenInKoeln) {
				if (energieSchulenKoeln.getAdresse().trim()
						.contains(feature.getAttributes().getAdresse().trim())) {
					SchuleInKoelnMitEnergie schuleEnergie = new SchuleInKoelnMitEnergie(
							feature, energieSchulenKoeln);
					schuleInKoelnMitEnergieList.add(schuleEnergie);
				}
			}
		}
		StringBuffer msg = new StringBuffer();
		msg.append("count schooldataset: ");
		msg.append(featureList.size());
		msg.append("; count energiedataset: ");
		msg.append(energieSchulenInKoeln.size());
		msg.append("; merged data: ");
		msg.append(schuleInKoelnMitEnergieList.size());

		logger.debug(msg.toString());
	}

	public List<SchuleInKoelnMitEnergie> getSchuleInKoelnMitEnergieList() {
		return schuleInKoelnMitEnergieList;
	}

}
