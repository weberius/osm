package de.illilli.opengis.jdbc.query;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import de.illilli.opengis.dto.PlanetOsmPoint;
import de.illilli.opengis.jdbc.ConnectionFactory;
import de.illilli.opengis.jdbc.DbUtilsBeanListHandler;

public class AskForSupermarket {

	private String sql = "select osm_id, name, shop, ST_ASGEOJSON(ST_Transform(way,4326)) as way from planet_osm_point " + "where lower(shop) = 'supermarket'";

	private DbUtilsBeanListHandler<PlanetOsmPoint> handler;
	private List<PlanetOsmPoint> pointsList;

	public AskForSupermarket() throws SQLException {
	}

	public AskForSupermarket(String markt) throws SQLException {
		sql = sql + " and lower(name) like '%" + markt.toLowerCase() + "%' ";
		Connection connection = ConnectionFactory.getConnection();
		BeanListHandler<PlanetOsmPoint> beanListHandler = new BeanListHandler<PlanetOsmPoint>(PlanetOsmPoint.class);
		handler = new DbUtilsBeanListHandler<PlanetOsmPoint>(connection, beanListHandler, sql);
		pointsList = handler.getList();
		for (PlanetOsmPoint point : pointsList) {
			point.setImageFile(markt + ".gif");
		}
	}

	public List<PlanetOsmPoint> getPois() throws SQLException {
		return pointsList;
	}

}
