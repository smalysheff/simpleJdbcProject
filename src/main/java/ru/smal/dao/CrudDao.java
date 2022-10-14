package ru.smal.dao;

import ru.smal.model.AbstractEntity;

import java.util.List;

public interface CrudDao<E extends AbstractEntity, K extends Number> {

    int SUCCESS = 1;

    E findById(K key);
    List<E> findAll();
    boolean save(E entity);
    boolean update(E entity, K key);
    boolean delete(K key);
}
