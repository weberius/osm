package de.illilli.opengis.service;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

@Path("/stadtteil")
public class SchuelerImStadtteilService {

	private static final Logger logger = Logger
			.getLogger(SchuelerImStadtteilService.class);

	/**
	 * <a
	 * href="http://localhost:8080/odk/dataservice/stadtteil/schueler/koeln">/
	 * odk/dataservice/stadtteil/schueler/koeln</a>
	 * 
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("schueler/koeln")
	public String getSchueler() throws URISyntaxException, IOException {
		String stadt = "köln";
		SchuelerImStadtteilFacade facade = new SchuelerImStadtteilFacade(stadt);
		logger.debug(facade.getString());
		return facade.getString();
	}

	/**
	 * Bsp.: <a href=
	 * "http://localhost:8080/odk/dataservice/stadtteil/schueler/chart/radar"
	 * >/odk/dataservice/stadtteil/schueler/chart/radar</a>
	 * 
	 * @return chart data in json format
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("schueler/chart/radar/{stadtteil}")
	public String getRadarChartData(@PathParam("stadtteil") int stadtteilnr) {
		logger.debug("stadtteilnr: " + stadtteilnr);
		SchuelerImStadtteilRadarChartDataFacade facade = new SchuelerImStadtteilRadarChartDataFacade(
				stadtteilnr);
		logger.debug(facade.getString());
		return facade.getString();
	}
}
