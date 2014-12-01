package de.illilli.opengis.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/stadtteile")
public class OsmKoelnBoundaryService {

	private static final Logger logger = Logger
			.getLogger(OsmKoelnBoundaryService.class);

	@Context
	HttpServletRequest request;

	@Context
	HttpServletResponse response;

	/**
	 * <a href="http://localhost:8090/osm/dataservice/stadtteile/koeln"> </a>
	 * 
	 * @return
	 * @throws SQLException
	 * @throws JsonProcessingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("koeln")
	public String getStadtteile() throws SQLException, JsonProcessingException {

		response.setCharacterEncoding("UTF-8");
		String stadt = "köln";
		KoelnBoundaryStadtteileFacade facade = new KoelnBoundaryStadtteileFacade(
				stadt);
		return facade.getString();

	}

}
