package com.softwify.libraryapp.dao;

import jakarta.persistence.EntityManager;

import java.util.List;

public abstract class JpaDao<T> {

    private final Class<T> clazz;
    private final String entityName;

    private final EntityManager entityManager;

    public JpaDao(Class<T> clazz, EntityManager entityManager) {
        this.clazz = clazz;
        this.entityName = clazz.getSimpleName();
        this.entityManager = entityManager;
    }

    public List<T> getAll() {
        return entityManager.createQuery("FROM " + entityName, clazz).getResultList();
    }

    public T getById(int id) {
        return entityManager.createQuery("SELECT entity FROM " + entityName + " entity WHERE entity.id = :id", clazz)
                .setParameter("id", id)
                .getSingleResult();
    }

    public T save(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    public boolean delete(int id) {
        try {
            T entity = entityManager.find(clazz, id);
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
