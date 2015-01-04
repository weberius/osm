package de.illilli.opengis.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.illilli.opengis.odk.arcgis.AskForEinwohnerAltersgruppenStadtteile;
import de.illilli.opengis.odk.bo.EinwohnerNachAltersgruppenBo;
import de.illilli.opengis.odk.bo.EinwohnerNachAltersgruppenSchuelerDao;
import de.illilli.opengis.odk.bo.csv.EinwohnerNachAltersgruppen;

public class EinwohnerNachAltersgruppenFacade {

	private List<EinwohnerNachAltersgruppenBo> boList;

	private final static Logger logger = Logger
			.getLogger(EinwohnerNachAltersgruppenFacade.class);

	public EinwohnerNachAltersgruppenFacade(int nr) {

		EinwohnerNachAltersgruppen einwohner = new AskForEinwohnerAltersgruppenStadtteile()
				.getEinwohnerInStadtteil(nr);
		EinwohnerNachAltersgruppenSchuelerDao dao = new EinwohnerNachAltersgruppenSchuelerDao(
				einwohner);
		boList = dao.getBoList();
		logger.debug("added einwohner to boList");
	}

	public String getJson() throws JsonProcessingException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		return gson.toJson(boList);
	}

}
