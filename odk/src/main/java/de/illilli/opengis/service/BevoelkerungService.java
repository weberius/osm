package de.illilli.opengis.service;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Path("/bevoelkerung")
public class BevoelkerungService {

	private static final Logger logger = Logger
			.getLogger(BevoelkerungService.class);

	@Context
	HttpServletRequest request;

	@Context
	HttpServletResponse response;

	/**
	 * Beispiel fuer die Abfrage der Daten von M&uuml;lheim:
	 * <p>
	 * <a href=
	 * "http://localhost:8080/odk/dataservice/bevoelkerung/altersgruppen/stadtteile/901"
	 * >/odk/dataservice/bevoelkerung/altersgruppen/stadtteile/901</a>
	 * </p>
	 * 
	 * @param nr
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("altersgruppen/stadtteile/{nr}")
	public String getStadtteilByNr(@PathParam("nr") int nr)
			throws JsonParseException, JsonMappingException, IOException,
			URISyntaxException {
		EinwohnerNachAltersgruppenFacade facade = new EinwohnerNachAltersgruppenFacade(
				nr);
		String json = facade.getJson();
		logger.debug("json: " + json);
		return json;
	}

	/**
	 * Dieser Service liefert bereits gefuellte java-script Variablen. Der
	 * Inhalt muss einfach ein einer .js Datei abgespeichert und mit der Seite
	 * geladen werden.
	 * <p>
	 * <a href=
	 * "http://localhost:8080/odk/dataservice/bevoelkerung/altersgruppen/stadtteile"
	 * >/odk/dataservice/bevoelkerung/altersgruppen/stadtteile</a>
	 * </p>
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("altersgruppen/stadtteile")
	public String getAlleStadtteile() throws JsonParseException,
			JsonMappingException, IOException, URISyntaxException {
		EinwohnerNachAltersgruppenVariablesFacade facade = new EinwohnerNachAltersgruppenVariablesFacade();
		String json = facade.getJson();
		logger.debug("json: " + json);
		return json;
	}
}
