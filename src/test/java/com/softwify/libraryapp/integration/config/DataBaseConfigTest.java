package com.softwify.libraryapp.integration.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.softwify.libraryapp.configuration.DataBaseConfig;

public class DataBaseConfigTest extends DataBaseConfig {
	private static final Logger logger = LogManager.getLogger("ConfigurationTest");

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		logger.info("Create DB connection");
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/librarytest?serverTimezone=UTC", "root",
				"rootroot");
	}
}
