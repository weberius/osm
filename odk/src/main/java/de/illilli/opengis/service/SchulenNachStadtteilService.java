package de.illilli.opengis.service;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

@Path("/district")
public class SchulenNachStadtteilService {

	private static final Logger logger = Logger
			.getLogger(SchulenNachStadtteilService.class);

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("pupils/koeln")
	public String getPupils() throws URISyntaxException, IOException {
		String stadt = "köln";
		SchuelerNachStadtteilFacade facade = new SchuelerNachStadtteilFacade(
				stadt);
		logger.debug(facade.getString());
		return facade.getString();
	}
}
