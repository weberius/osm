package de.illilli.opengis.bo;

import java.util.ArrayList;
import java.util.List;

import de.illilli.opengis.dto.PlanetOsmPoint;

public class PlanetOsmPointDao {

	private List<PlanetOsmBo> planetOsmBoList;

	public PlanetOsmPointDao(PlanetOsmPoint planetOsmPoint) {
		planetOsmBoList = new ArrayList<PlanetOsmBo>();
		planetOsmBoList.add(new PlanetOsmPointBo(planetOsmPoint));
	}

	public PlanetOsmPointDao(List<PlanetOsmPoint> planetOsmPointList) {
		planetOsmBoList = new ArrayList<PlanetOsmBo>();
		for (PlanetOsmPoint planetOsmpoint : planetOsmPointList) {
			planetOsmBoList.add(new PlanetOsmPointBo(planetOsmpoint));
		}
	}

	public List<PlanetOsmBo> getPlanetOsmBoList() {
		return planetOsmBoList;
	}

}
