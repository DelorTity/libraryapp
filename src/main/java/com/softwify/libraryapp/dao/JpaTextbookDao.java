package com.softwify.libraryapp.dao;

import com.softwify.libraryapp.constants.Queries;
import com.softwify.libraryapp.model.Textbook;
import jakarta.persistence.EntityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class JpaTextbookDao extends JpaDao<Textbook> implements TextbookDao{

    public static final Logger logger = LogManager.getLogger(JpaTextbookDao.class.getSimpleName());

    public JpaTextbookDao(EntityManager entityManager) {
        super(Textbook.class, entityManager);
    }

}
