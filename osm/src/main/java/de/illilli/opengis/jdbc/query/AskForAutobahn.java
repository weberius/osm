package de.illilli.opengis.jdbc.query;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;

import de.illilli.opengis.dto.PlanetOsmLine;
import de.illilli.opengis.jdbc.ConnectionFactory;
import de.illilli.opengis.jdbc.DbUtilsBeanListHandler;

public class AskForAutobahn {

	private final static Logger logger = Logger.getLogger(AskForAutobahn.class);

	public String sql = "select osm_id, admin_level, bicycle, bridge, boundary, foot, highway, motorcar, "
			+ "name, population, ref, surface, tracktype, waterway, width, " //
			+ "ST_ASGEOJSON(ST_Transform(way,4326)) as way " //
			+ "from planet_osm_line where highway = 'motorway' ";

	private DbUtilsBeanListHandler<PlanetOsmLine> handler;
	private List<PlanetOsmLine> pois;
	private Connection connection;
	BeanListHandler<PlanetOsmLine> beanListHandler;

	public AskForAutobahn() throws SQLException {
		connection = ConnectionFactory.getConnection();
		beanListHandler = new BeanListHandler<PlanetOsmLine>(PlanetOsmLine.class);
	}

	public AskForAutobahn(String id) throws SQLException {
		this();
		String a1 = id.toLowerCase();
		StringBuffer sb = new StringBuffer(a1);
		sb.insert(1, " ");
		String a2 = id.toLowerCase();
		this.sql = this.sql + "and lower(ref) like '" + sb.toString() + "'";
		logger.debug(this.sql);
	}

	public List<PlanetOsmLine> getPois() throws SQLException {
		handler = new DbUtilsBeanListHandler<PlanetOsmLine>(connection, beanListHandler, sql);
		pois = handler.getList();
		return pois;
	}

}
