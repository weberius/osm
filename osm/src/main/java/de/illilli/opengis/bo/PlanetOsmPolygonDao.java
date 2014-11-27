package de.illilli.opengis.bo;

import java.util.ArrayList;
import java.util.List;

import de.illilli.opengis.dto.PlanetOsmPolygon;

public class PlanetOsmPolygonDao {

	private List<PlanetOsmBo> planetOsmBoList;

	public PlanetOsmPolygonDao(PlanetOsmPolygon planetOsmLine) {
		planetOsmBoList = new ArrayList<PlanetOsmBo>();
		planetOsmBoList.add(new PlanetOsmPolygonBo(planetOsmLine));
	}

	public PlanetOsmPolygonDao(List<PlanetOsmPolygon> planetOsmLineList) {
		planetOsmBoList = new ArrayList<PlanetOsmBo>();
		for (PlanetOsmPolygon planetOsmLine : planetOsmLineList) {
			planetOsmBoList.add(new PlanetOsmPolygonBo(planetOsmLine));
		}
	}

	public List<PlanetOsmBo> getPlanetOsmBoList() {
		return planetOsmBoList;
	}

}
