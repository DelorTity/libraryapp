package com.softwify.libraryapp.dao;

import com.softwify.libraryapp.constants.Queries;
import com.softwify.libraryapp.model.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JpaAuthorDao extends JpaDao<Author> implements AuthorDao {

    private final EntityManager entityManager;

    public JpaAuthorDao(EntityManager entityManager) {
        super(Author.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Author getByFirstNameAndLastName(String firstName, String lastName) {
        try {
            return entityManager.createQuery(Queries.JPA_GET_AUTHOR_BY_FIRSTNAME_AND_LASTNAME, Author.class)
                    .setParameter("firstName", firstName)
                    .setParameter("lastName", lastName)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
