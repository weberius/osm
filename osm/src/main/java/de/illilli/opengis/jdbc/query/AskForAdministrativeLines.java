package de.illilli.opengis.jdbc.query;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import de.illilli.opengis.dto.PlanetOsmLine;
import de.illilli.opengis.jdbc.ConnectionFactory;
import de.illilli.opengis.jdbc.DbUtilsBeanListHandler;

public class AskForAdministrativeLines {

	private String sql = "select osm_id, admin_level, bicycle, bridge, boundary, foot, highway, motorcar, name, population, ref, surface, tracktype, waterway, width, "
			// + "ST_AsText(ST_Transform(way,4326)) as way "
			+ "ST_ASGEOJSON(ST_Transform(way,4326)) as way " //
			+ "from planet_osm_roads where boundary = 'administrative' and name = 'Köln'";

	private DbUtilsBeanListHandler<PlanetOsmLine> handler;
	private List<PlanetOsmLine> pois;

	public List<PlanetOsmLine> getPois(int adminLevel) throws SQLException {

		Connection connection = ConnectionFactory.getConnection();
		BeanListHandler<PlanetOsmLine> beanListHandler = new BeanListHandler<PlanetOsmLine>(PlanetOsmLine.class);
		sql = sql + " and admin_level = '" + adminLevel + "'";
		handler = new DbUtilsBeanListHandler<PlanetOsmLine>(connection, beanListHandler, sql);
		pois = handler.getList();

		return pois;
	}

}
