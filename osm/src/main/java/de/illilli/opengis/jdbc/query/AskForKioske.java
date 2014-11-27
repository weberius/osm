package de.illilli.opengis.jdbc.query;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;

import de.illilli.opengis.dto.PlanetOsmPoint;
import de.illilli.opengis.jdbc.ConnectionFactory;
import de.illilli.opengis.jdbc.DbUtilsBeanListHandler;

public class AskForKioske {

	private static final Logger logger = Logger.getLogger(AskForKioske.class);

	private String sql = "select osm_id, name, shop, ST_ASGEOJSON(ST_Transform(way,4326)) as way from planet_osm_point where lower(shop) like '%kiosk%'";

	private DbUtilsBeanListHandler<PlanetOsmPoint> handler;
	private List<PlanetOsmPoint> pois = new ArrayList<PlanetOsmPoint>();

	public AskForKioske() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		BeanListHandler<PlanetOsmPoint> beanListHandler = new BeanListHandler<PlanetOsmPoint>(PlanetOsmPoint.class);
		handler = new DbUtilsBeanListHandler<PlanetOsmPoint>(connection, beanListHandler, sql);
		pois = handler.getList();
	}

	public AskForKioske(String name) throws SQLException {

		if (name != null) {
			sql = sql + " and lower(name) like '%" + name.toLowerCase() + "%'";
			logger.debug(sql);
		}

		Connection connection = ConnectionFactory.getConnection();
		BeanListHandler<PlanetOsmPoint> beanListHandler = new BeanListHandler<PlanetOsmPoint>(PlanetOsmPoint.class);
		handler = new DbUtilsBeanListHandler<PlanetOsmPoint>(connection, beanListHandler, sql);
		pois = handler.getList();
	}

	public AskForKioske(String centerx, String centery, String upperleftx, String upperlefty) throws SQLException {

		if (centerx != null & centery != null & upperleftx != null & upperlefty != null) {
			String transformCenter = "ST_Transform(ST_GeomFromText('POINT(" + centery + " " + centerx + ")',4326),900913)";
			String transformUpperLeft = "ST_Transform(ST_GeomFromText('POINT(" + upperlefty + " " + upperleftx + ")',4326),900913)";
			String distance = "ST_Distance( " + transformCenter + ", " + transformUpperLeft + ")";
			sql = sql + " and ST_DWithin(way, " + transformCenter + ", " + distance + ")";
			logger.debug(sql);
		}

		Connection connection = ConnectionFactory.getConnection();
		BeanListHandler<PlanetOsmPoint> beanListHandler = new BeanListHandler<PlanetOsmPoint>(PlanetOsmPoint.class);
		handler = new DbUtilsBeanListHandler<PlanetOsmPoint>(connection, beanListHandler, sql);
		pois = handler.getList();
	}

	public List<PlanetOsmPoint> getPois() {
		return pois;
	}

}
