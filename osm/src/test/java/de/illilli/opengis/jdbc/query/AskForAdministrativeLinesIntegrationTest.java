package de.illilli.opengis.jdbc.query;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import de.illilli.opengis.dto.PlanetOsmLine;

public class AskForAdministrativeLinesIntegrationTest {

	@Test
	public void test() throws SQLException {
		AskForAdministrativeLines lines = new AskForAdministrativeLines();
		List<PlanetOsmLine> polList = lines.getPois(6);
		for (PlanetOsmLine pol : polList) {
			System.out.println(pol.getWay());
		}

	}

}
