package de.illilli.opengis.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import de.illilli.opengis.HtmlProperties;

/**
 * 
 *
 */
@Path("/html")
public class NavbarService {

	private static final Logger logger = Logger.getLogger(NavbarService.class);

	@Context
	private HttpServletRequest servletRequest;

	@Context
	private HttpServletResponse servletResponse;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("navbar")
	public String getNavbar() {
		HtmlProperties htmlProperties = new HtmlProperties();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 100; i++) {
			sb.append(htmlProperties.getPropertie("navbar." + i));
		}
		return sb.toString();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("navbar/{id}")
	public String getNavbar(@PathParam("id") String id) {
		HtmlProperties htmlProperties = new HtmlProperties();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 100; i++) {
			sb.append(htmlProperties.getPropertie("navbar." + i));
		}
		logger.debug(id);
		return sb.toString();
	}

}
