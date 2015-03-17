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

@Path("/school")
public class SchulenInKoelnService {

	private final static Logger logger = Logger
			.getLogger(SchulenInKoelnService.class);

	@Context
	HttpServletRequest request;

	@Context
	HttpServletResponse response;

	/**
	 * <a href="http://localhost:8080/odk/dataservice/school/koeln">/odk/
	 * dataservice/school/koeln</a>
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("koeln")
	public String getKoeln() throws JsonParseException, JsonMappingException,
			IOException, URISyntaxException {
		// setze das Character-Encoding fuer die Antwort auf UTF-8
		response.setCharacterEncoding("UTF-8");
		logger.debug("requesting koeln");
		String param = request.getParameter("js");
		if (param != null) {
			return new SchulenInKoelnToJsFacade().getString();
		}
		return new SchulenInKoelnFacade().getString();
	}

	/**
	 * Beispiele:
	 * <ul>
	 * <li>
	 * <a href=
	 * "http://localhost:8080/odk/dataservice/school/koeln/2.%20bildungsweg">/
	 * odk/dataservice/school/koeln/2.%20bildungsweg</a></li>
	 * <li>
	 * <a
	 * href="http://localhost:8080/odk/dataservice/school/koeln/berufskolleg">/
	 * odk/dataservice/school/koeln/berufskolleg</a></li>
	 * <li>
	 * <a href=
	 * "http://localhost:8080/odk/dataservice/school/koeln/f%C3%B6rderschule">/
	 * odk/dataservice/school/koeln/f%C3%B6rderschule</a></li>
	 * <li>
	 * <a href=
	 * "http://localhost:8080/odk/dataservice/school/koeln/freie%20waldorfschule"
	 * >/ odk/dataservice/school/koeln/freie%20waldorfschule</a></li>
	 * <li>
	 * <a
	 * href="http://localhost:8080/odk/dataservice/school/koeln/gesamtschule">/
	 * odk/dataservice/school/koeln/gesamtschule</a></li>
	 * <li>
	 * <a
	 * href="http://localhost:8080/odk/dataservice/school/koeln/grundschule">/
	 * odk/dataservice/school/koeln/grundschule</a></li>
	 * <li>
	 * <a href="http://localhost:8080/odk/dataservice/school/koeln/gymnasium">/
	 * odk/dataservice/school/koeln/gymnasium</a></li>
	 * <li>
	 * <a
	 * href="http://localhost:8080/odk/dataservice/school/koeln/hauptschule">/
	 * odk/dataservice/school/koeln/hauptschule</a></li>
	 * <li>
	 * <a href="http://localhost:8080/odk/dataservice/school/koeln/realschule">/
	 * odk/dataservice/school/koeln/realschule</a></li>
	 * </ul>
	 * 
	 * @param schulart
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("koeln/{schulart}")
	public String getKoelnBySchulart(@PathParam("schulart") String schulart)
			throws JsonParseException, JsonMappingException, IOException,
			URISyntaxException {
		logger.debug("requesting koeln");
		// setze das Character-Encoding fuer die Antwort auf UTF-8
		response.setCharacterEncoding("UTF-8");
		return new SchulenInKoelnBySchulartFacade(schulart).getJson();
	}

	/**
	 * <a
	 * href="http://localhost:8090/odkdataservice/school/koeln/schule/64"></a>
	 * 
	 * @param id
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@GET
	@Produces({ MediaType.TEXT_HTML })
	@Path("koeln/schule/{id}")
	public String getSchuleById(@PathParam("id") String id) {
		SchuleInKoelnMitEnergieFacade facade = new SchuleInKoelnMitEnergieFacade(
				id);
		String html = facade.getHtml();
		logger.debug("getSchuleById [" + id + "]: " + html);
		return html;
	}

}
