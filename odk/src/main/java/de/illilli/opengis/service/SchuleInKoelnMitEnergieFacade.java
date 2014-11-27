package de.illilli.opengis.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.log4j.Logger;

import de.illilli.opengis.odk.arcgis.AskForEnergieSchulenKoeln;
import de.illilli.opengis.odk.arcgis.AskForSchulenInKoeln;
import de.illilli.opengis.odk.bo.SchuleInKoelnMitEnergie;
import de.illilli.opengis.odk.bo.SchulenInKoelnMitEnergieDao;
import de.illilli.opengis.odk.bo.csv.EnergieSchuleKoeln;
import de.illilli.opengis.odk.bo.json.SchulenInKoeln;

public class SchuleInKoelnMitEnergieFacade {

	private static final Logger logger = Logger
			.getLogger(SchuleInKoelnMitEnergieFacade.class);

	private StringBuffer html;

	public SchuleInKoelnMitEnergieFacade(String id) {

		logger.debug("requesting schule mit id " + id);

		SchulenInKoelnMitEnergieDao schulenDao = null;
		try {
			SchulenInKoeln schulen = new AskForSchulenInKoeln()
					.getSchulenInKoeln();
			List<EnergieSchuleKoeln> energie = new AskForEnergieSchulenKoeln()
					.getEnergieSchulenInKoeln();
			schulenDao = new SchulenInKoelnMitEnergieDao(schulen, energie);
		} catch (IOException | URISyntaxException e) {
			logger.error(e);
		}
		// 3. change to feature List
		List<SchuleInKoelnMitEnergie> schuleList = schulenDao
				.getSchuleInKoelnMitEnergieList();
		// 4. Prepare FeatureCollection; other features can be added.

		html = new StringBuffer();
		for (SchuleInKoelnMitEnergie schule : schuleList) {
			if (schule.getSchule().getAttributes().getObjectid().equals(id)) {
				html.append("<table>");
				html.append("<tr>");

				html.append("<th>");
				html.append("Tr&auml;ger");
				html.append("</th>");
				html.append("<td>");
				html.append(schule.getSchule().getAttributes().getTraeger());
				html.append("</td>");
				html.append("</tr>");

				html.append("<th>");
				html.append(EnergieSchuleKoeln.Head.grundflaeche.key());
				html.append("</th>");
				html.append("<td>");
				html.append(schule.getEnergie().getGrundflaeche());
				html.append("</td>");
				html.append("</tr>");

				html.append("<th>");
				html.append(EnergieSchuleKoeln.Head.heizung_ekw.key());
				html.append("</th>");
				html.append("<td>");
				html.append(schule.getEnergie().getHeizung_ekw());
				html.append("</td>");
				html.append("</tr>");

				html.append("<th>");
				html.append("Bemerkung");
				html.append("</th>");
				html.append("<td>");
				html.append(schule.getEnergie().getBemerkung());
				html.append("</td>");
				html.append("</tr>");

				html.append("</tr>");
				html.append("</table>");
			}
		}

		logger.debug("return " + html.toString());

	}

	public String getHtml() {
		return html.toString();
	}
}
