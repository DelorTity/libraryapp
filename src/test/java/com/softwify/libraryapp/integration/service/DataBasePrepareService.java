package com.softwify.libraryapp.integration.service;

import java.sql.Connection;

import com.softwify.libraryapp.integration.config.DataBaseConfigTest;

public class DataBasePrepareService {
	DataBaseConfigTest dataBaseTestConfig = new DataBaseConfigTest();

	public void clearDataBaseEntries() {
		Connection connection = null;
		try {
			connection = dataBaseTestConfig.getConnection();

			connection.prepareStatement("delete from author").execute();
			connection.prepareStatement("alter table author AUTO_INCREMENT = 1").execute();

			// clear author entries;
			// connection.prepareStatement("truncate table author").execute();

			final String INSERT_AUTHORS = "INSERT INTO `author` (`id`, `lastname`, `firstname`) " + "VALUES\r\n"
					+ "(3, 'Mcsween', 'Pierre-Yves'),\r\n" + "(5, 'Niang', 'Thione'),\r\n"
					+ "(9, 'Djomo', 'Wilfried'),\r\n" + "(16, 'Hill', 'Napoleon')";

			// insert authors in author table
			connection.prepareStatement(INSERT_AUTHORS).execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dataBaseTestConfig.closeConnection(connection);
		}
	}
}
