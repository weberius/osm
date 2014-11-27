package de.illilli.opengis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

public class ConnectionFactory {

	// static final String url = "jdbc:postgresql://10.63.22.188:5432/gis";
	static final String url = "jdbc:postgresql://ubuntu1404tileserver:5432/gis";
	static final String driver = "org.postgresql.Driver";
	static final String usr = "gis";
	static final String pwd = "";

	public static Connection getConnection() throws SQLException {
		DbUtils.loadDriver(driver);
		return DriverManager.getConnection(url, usr, pwd);
	}
}
