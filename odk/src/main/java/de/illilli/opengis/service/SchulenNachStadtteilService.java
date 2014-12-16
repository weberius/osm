package de.illilli.opengis.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/district")
public class SchulenNachStadtteilService {

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("pupils/koeln")
	public String getPupils() {
		String stadt = "köln";
		SchuelerNachStadtteilFacade facade = new SchuelerNachStadtteilFacade(
				stadt);
		return facade.getString();
	}
}
