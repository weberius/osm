package de.illilli.opengis.jdbc.query;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;

import de.illilli.opengis.dto.PlanetOsmPolygon;
import de.illilli.opengis.jdbc.ConnectionFactory;
import de.illilli.opengis.jdbc.DbUtilsBeanListHandler;

public class AskForStadtteile {

	private static final Logger logger = Logger
			.getLogger(AskForStadtteile.class);

	StringBuffer sb = new StringBuffer();

	private void initSql(String stadt) {
		sb.append("select osm_id, admin_level, name, ref, ST_ASGEOJSON(ST_Transform(ST_Simplify(way,10),4326)) as way ");
		sb.append("from planet_osm_polygon ");
		sb.append("where boundary = 'administrative' and admin_level = '10' ");
		sb.append("and ST_CONTAINS((select way from planet_osm_polygon ");
		sb.append("where boundary = 'administrative' and admin_level = '6' ");
		sb.append("and lower(name) like '" + stadt + "'), way) ");
	}

	private DbUtilsBeanListHandler<PlanetOsmPolygon> handler;
	private List<PlanetOsmPolygon> pois;

	public AskForStadtteile(String stadt) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		initSql(stadt);

		BeanListHandler<PlanetOsmPolygon> beanListHandler = new BeanListHandler<PlanetOsmPolygon>(
				PlanetOsmPolygon.class);
		handler = new DbUtilsBeanListHandler<PlanetOsmPolygon>(connection,
				beanListHandler, sb.toString());
		pois = handler.getList();

		logger.debug("number of pois: " + pois.size());

		connection.close();
	}

	public List<PlanetOsmPolygon> getPois() {
		return pois;
	}

}
