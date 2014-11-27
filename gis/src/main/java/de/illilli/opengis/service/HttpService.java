package de.illilli.opengis.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/http")
public class HttpService {

	@Context
	private HttpServletRequest servletRequest;

	@Context
	private HttpServletResponse servletResponse;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("servletRequest")
	public String getServletRequest() {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("localAddr:");
		sb.append(servletRequest.getLocalAddr());
		sb.append("sessionId:");
		sb.append(servletRequest.getSession().getId());
		sb.append("}");
		return sb.toString();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("sessionid")
	public String getsessionId() {
		StringBuffer sb = new StringBuffer();
		sb.append(servletRequest.getSession().getId());
		return sb.toString();
	}

}
