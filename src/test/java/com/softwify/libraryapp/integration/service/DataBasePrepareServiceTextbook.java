package com.softwify.libraryapp.integration.service;

import com.softwify.libraryapp.integration.config.DataBaseConfigTest;

import java.sql.Connection;

public class DataBasePrepareServiceTextbook {
    DataBaseConfigTest dataBaseTestConfig = new DataBaseConfigTest();

    public void clearDataBaseEntries() {
        Connection connection = null;
        try {
            connection = dataBaseTestConfig.getConnection();

            connection.prepareStatement("delete from textbook").execute();
            connection.prepareStatement("alter table textbook AUTO_INCREMENT = 1").execute();

            final String INSERT_TEXTBOOKS= "INSERT INTO `textbook` (`id`, `title`, `author_id`, `isbn`, `editor`, `publication_date`) VALUES\n" +
                    "(3, 'En as-tu vraiment besoin ?', 3, 1234567890, 'paris', '2022-08-21'),\n" +
                    "(5, 'Demain tu gouvernes le monde', 5, 1234567890, 'paris', '2022-08-02'),\n" +
                    "(8, 'Social Entrepreneurship', 5, 1234567890, 'USA', '2022-08-18'),\n" +
                    "(9, 'L\\'effet papillon', 9, 1234567890, 'france', '2022-08-23'),\n" +
                    "(16, 'Liberté 45', 3, 1234567890, 'canada', '2022-08-12'),\n" +
                    "(21, 'Think and grow rich', 16, 1234567890, 'baham', '2022-08-19')";

            // insert authors in author table
            connection.prepareStatement(INSERT_TEXTBOOKS).execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dataBaseTestConfig.closeConnection(connection);
        }
    }
}
