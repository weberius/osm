package de.illilli.opengis.jdbc.query;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;

import de.illilli.opengis.dto.PlanetOsmPolygon;
import de.illilli.opengis.jdbc.ConnectionFactory;
import de.illilli.opengis.jdbc.DbUtilsBeanListHandler;

public class AskForAdministrativeBoundaries {

	private final static Logger logger = Logger.getLogger(AskForAdministrativeBoundaries.class);

	/**
	 * http://postgis.net/docs/manual-1.4/ST_Simplify.html
	 */
	private final int tolerance = 10;
	private final String boundary = "administrative";

	StringBuffer sqlSb = new StringBuffer();

	void initSql(String adminLevel) {
		sqlSb.append("select osm_id, admin_level, name, ref, ");
		sqlSb.append("  ST_ASGEOJSON(ST_Transform(ST_Simplify(way, " + tolerance + "),4326)) as way ");
		sqlSb.append("from planet_osm_polygon ");
		sqlSb.append("where boundary = '" + boundary + "' and admin_level = ");
		sqlSb.append("'" + adminLevel + "'");
	}

	private DbUtilsBeanListHandler<PlanetOsmPolygon> handler;
	private List<PlanetOsmPolygon> pois;

	public AskForAdministrativeBoundaries(String adminLevel) throws SQLException {
		initSql(adminLevel);
		Connection connection = ConnectionFactory.getConnection();
		BeanListHandler<PlanetOsmPolygon> beanListHandler = new BeanListHandler<PlanetOsmPolygon>(PlanetOsmPolygon.class);
		logger.debug(sqlSb.toString());
		long before = System.currentTimeMillis();
		handler = new DbUtilsBeanListHandler<PlanetOsmPolygon>(connection, beanListHandler, sqlSb.toString());
		long after = System.currentTimeMillis();
		logger.debug("time needed: " + new SimpleDateFormat("mm.ss.SSS").format(new Date(after - before)));
		pois = handler.getList();
	}

	public List<PlanetOsmPolygon> getPois() {
		return pois;
	}

}
