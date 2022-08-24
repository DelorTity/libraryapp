package com.softwify.libraryapp.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefaultDataBaseConfig extends DataBaseConfig {

	private static final Logger logger = LogManager.getLogger(DefaultDataBaseConfig.class.getSimpleName());

	@Override
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		logger.info("Cree la connection a la base de donne");
		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/library?serverTimezone=UTC", "root", "rootroot");
	}
}
