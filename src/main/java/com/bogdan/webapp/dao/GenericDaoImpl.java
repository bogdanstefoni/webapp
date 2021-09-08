package com.bogdan.webapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public abstract   class GenericDaoImpl<T> implements GenericRepository<T> {

    private Class<T> myClass;

    EntityManager em;

    @Autowired
    public GenericDaoImpl(EntityManager em) {
        this.em = em;
    }

    public void setMyClass(Class<T> classToSet) {
        this.myClass = classToSet;
    }

    public List<T> findAll() {
        return em.createQuery("FROM " + myClass.getName()).getResultList();
    }

    public T findById(int id) {

        T object = em.find(myClass, id);

        return object;
    }

    public void save(T entity) {
        em.persist(entity);
    }

    public void delete(T entity) {
        em.remove(entity);
    }

    public void update(T entity) {
        em.merge(entity);
    }

    public void deleteById(int id) {
        T entity = findById(id);
        delete(entity);
    }

}
