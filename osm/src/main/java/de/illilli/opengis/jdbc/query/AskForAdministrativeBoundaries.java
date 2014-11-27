package de.illilli.opengis.jdbc.query;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import de.illilli.opengis.dto.PlanetOsmPolygon;
import de.illilli.opengis.jdbc.ConnectionFactory;
import de.illilli.opengis.jdbc.DbUtilsBeanListHandler;

public class AskForAdministrativeBoundaries {

	private String sql = "select osm_id, admin_level, name, ref, ST_ASGEOJSON(ST_Transform(way,4326)) as way "
			+ "from planet_osm_polygon where boundary = 'administrative' and admin_level = ";

	private DbUtilsBeanListHandler<PlanetOsmPolygon> handler;
	private List<PlanetOsmPolygon> pois;

	public AskForAdministrativeBoundaries(String adminLevel) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		BeanListHandler<PlanetOsmPolygon> beanListHandler = new BeanListHandler<PlanetOsmPolygon>(PlanetOsmPolygon.class);
		sql = sql + "'" + adminLevel + "'";
		handler = new DbUtilsBeanListHandler<PlanetOsmPolygon>(connection, beanListHandler, sql);
		pois = handler.getList();
	}

	public List<PlanetOsmPolygon> getPois() {
		return pois;
	}

}
