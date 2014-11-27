package de.illilli.opengis.jdbc.query;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import de.illilli.opengis.dto.PlanetOsmLine;
import de.illilli.opengis.jdbc.ConnectionFactory;
import de.illilli.opengis.jdbc.DbUtilsBeanListHandler;

/**
 * Bicycleway types
 * <ul>
 * <li>dismount</li>
 * <li>track</li>
 * <li>private</li>
 * <li>official</li>
 * <li>limited</li>
 * <li>permissive</li>
 * <li>oneway=no</li>
 * <li>no</li>
 * <li>destination</li>
 * <li>yes</li>
 * <li>use_sidepath</li>
 * <li>designated</li>
 * </ul>
 */
public class AskForFahrradwege {

	private String sql = "select osm_id, admin_level, bicycle, bridge, boundary, foot, highway, motorcar, name, population, ref, surface, tracktype, waterway, width, "
			+ "ST_ASGEOJSON(ST_Transform(way,4326)) as way " //
			+ "from planet_osm_line ";

	private DbUtilsBeanListHandler<PlanetOsmLine> handler;
	private List<PlanetOsmLine> pois;

	public AskForFahrradwege(String bicycle) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		BeanListHandler<PlanetOsmLine> beanListHandler = new BeanListHandler<PlanetOsmLine>(PlanetOsmLine.class);
		sql = sql + " where bicycle like '%" + bicycle.trim().toLowerCase() + "%'";
		handler = new DbUtilsBeanListHandler<PlanetOsmLine>(connection, beanListHandler, sql);
	}

	public List<PlanetOsmLine> getPois() throws SQLException {
		return handler.getList();
	}

}
