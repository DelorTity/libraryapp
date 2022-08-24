package com.softwify.libraryapp.dao;

import com.softwify.libraryapp.constants.Queries;
import com.softwify.libraryapp.model.Textbook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.softwify.libraryapp.service.LibraryMenu.dataBaseConfig;

public class NativeJdbcTextbookDao implements TextbookDao{
    public static final Logger logger = LogManager.getLogger(NativeJdbcTextbookDao.class.getSimpleName());
    @Override
    public List<Textbook> getAll() {
        Connection connection = null;
        List<Textbook> textbooks = new ArrayList<>();

        try {
            connection = dataBaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_TEXTBOOKS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                int isbn = resultSet.getInt("isbn");
                String editor = resultSet.getString("editor");
                Date publicationDate = resultSet.getDate("publication_date");
                int authorId = resultSet.getInt("author_id");
                Textbook textbook = new Textbook(id, title, authorId, isbn, editor, publicationDate);
                textbooks.add(textbook);
            }
            dataBaseConfig.closeResultSet(resultSet);
            dataBaseConfig.closePreparedStatement(preparedStatement);
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("An error has occurred", e);
        } finally {
            dataBaseConfig.closeConnection(connection);
        }

        return textbooks;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = null;
        boolean deleted = false;
        try {
            connection = dataBaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.DELETE_TEXTBOOK);
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            deleted = affectedRows == 1;
            dataBaseConfig.closePreparedStatement(preparedStatement);
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("An error has occurred", e);
        } finally {
            dataBaseConfig.closeConnection(connection);
        }

        return deleted;
    }

    @Override
    public Textbook getById(int id) {
        Connection connection = null;
        Textbook textbook = null;
        try {
            connection = dataBaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.GET_TEXTBOOK);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                String title = resultSet.getString("title");
                /*String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");*/
                int isbn = resultSet.getInt("isbn");
                String editor = resultSet.getString("editor");
                Date publicationDate = resultSet.getDate("publication_date");
                int authorId = resultSet.getInt("author_id");
                textbook = new Textbook(id, title, authorId, isbn, editor, publicationDate);
            }
            dataBaseConfig.closeResultSet(resultSet);
            dataBaseConfig.closePreparedStatement(preparedStatement);
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("An error has occurred", e);
        } finally {
            dataBaseConfig.closeConnection(connection);
        }

        return textbook;
    }

    @Override
    public Textbook save(Textbook textbook) {
        Connection connection = null;
        Textbook createdTextbook = null;
        try {
            connection = dataBaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.ADD_TEXTBOOK, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, textbook.getTitle());
            preparedStatement.setInt(2, textbook.getAuthorId());
            preparedStatement.setInt(3, textbook.getIsbn());
            preparedStatement.setString(4, textbook.getEditor());
            java.util.Date publicationDate = textbook.getPublicationDate();
            //    java.util.Date utilPackageDate = new java.util.Date();
            java.sql.Date sqlPackageDate = new java.sql.Date(publicationDate.getTime());
            preparedStatement.setDate(5, sqlPackageDate);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                int id = resultSet.getInt(1);
                createdTextbook = new Textbook(id, textbook.getTitle(), textbook.getAuthorId(), textbook.getIsbn(), textbook.getEditor(), textbook.getPublicationDate());
            }
            dataBaseConfig.closePreparedStatement(preparedStatement);
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("An error has occurred", e);
        } finally {
            dataBaseConfig.closeConnection(connection);
        }
        return createdTextbook;
    }

}
