package de.illilli.opengis.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import de.illilli.opengis.odk.arcgis.AskForEinwohnerAltersgruppenStadtteile;
import de.illilli.opengis.odk.bo.EinwohnerNachAltersgruppenBo;
import de.illilli.opengis.odk.bo.EinwohnerNachAltersgruppenSchuelerDao;
import de.illilli.opengis.odk.bo.csv.EinwohnerNachAltersgruppen;

public class EinwohnerNachAltersgruppenVariablesFacade {

	private final static Logger logger = Logger
			.getLogger(EinwohnerNachAltersgruppenVariablesFacade.class);
	private List<EinwohnerNachAltersgruppenBo> boList;

	private StringBuilder sb = new StringBuilder();

	public EinwohnerNachAltersgruppenVariablesFacade() {

		List<EinwohnerNachAltersgruppen> einwohnerList = new AskForEinwohnerAltersgruppenStadtteile()
				.getList();

		sb.append("// begin data");
		for (EinwohnerNachAltersgruppen einwohner : einwohnerList) {
			sb.append("var einwohner" + einwohner.getNr() + " = ");
			EinwohnerNachAltersgruppenSchuelerDao dao = new EinwohnerNachAltersgruppenSchuelerDao(
					einwohner);
			boList = dao.getBoList();
			String json = new Gson().toJson(boList);
			sb.append(json);
			sb.append("\n");
		}

		logger.debug("added einwohner to boList");

	}

	public String getJson() {
		return sb.toString();
	}

}
