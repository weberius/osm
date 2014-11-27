package de.illilli.opengis.bo;

import java.util.ArrayList;
import java.util.List;

import de.illilli.opengis.dto.PlanetOsmLine;

/**
 * Diese Klasse wandelt ein PlanetOsmLine - Objekt oder eine Liste davon in eine
 * Liste an PlanetOsmBo Objekten.
 */
public class PlanetOsmLineDao {

	private List<PlanetOsmBo> planetOsmBoList;

	public PlanetOsmLineDao(PlanetOsmLine planetOsmLine) {
		planetOsmBoList = new ArrayList<PlanetOsmBo>();
		planetOsmBoList.add(new PlanetOsmLineBo(planetOsmLine));
	}

	public PlanetOsmLineDao(List<PlanetOsmLine> planetOsmLineList) {
		planetOsmBoList = new ArrayList<PlanetOsmBo>();
		for (PlanetOsmLine planetOsmLine : planetOsmLineList) {
			planetOsmBoList.add(new PlanetOsmLineBo(planetOsmLine));
		}
	}

	public List<PlanetOsmBo> getPlanetOsmBoList() {
		return planetOsmBoList;
	}

}
