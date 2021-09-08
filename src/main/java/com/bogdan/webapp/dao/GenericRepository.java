package com.bogdan.webapp.dao;

import java.util.List;

public interface GenericRepository<T> {

    public List<T>  findAll();

    T findById(int id);

    void save(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteById(int id);

}
