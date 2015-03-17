package de.illilli.opengis.service;

import java.io.IOException;
import java.net.URISyntaxException;

import de.illilli.opengis.odk.bo.json.SchulartenKoelnEnum;

/**
 * This class writes Javascript File to filesystem.
 * 
 *
 */
public class SchulenInKoelnToJsFacade {

	private StringBuilder sb;

	public SchulenInKoelnToJsFacade() throws IOException, URISyntaxException {
		sb = new StringBuilder();

		for (SchulartenKoelnEnum n : SchulartenKoelnEnum.values()) {
			sb.append(n.name());
			sb.append(" = ");
			sb.append(new SchulenInKoelnBySchulartFacade(n.schulart())
					.getJson());
			sb.append("\n");
			sb.append("\n");
		}
	}

	public String getString() {
		return sb.toString();
	}
}
