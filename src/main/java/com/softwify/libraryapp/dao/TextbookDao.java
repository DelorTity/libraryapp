package com.softwify.libraryapp.dao;

import com.softwify.libraryapp.configuration.DataBaseConfig;
import com.softwify.libraryapp.constants.Queries;
import com.softwify.libraryapp.model.Textbook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface TextbookDao {

    List<Textbook> getAll() ;

    boolean delete(int id);

    Textbook getById(int id);

    Textbook save(Textbook textbook);

}