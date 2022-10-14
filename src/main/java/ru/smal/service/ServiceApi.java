package ru.smal.service;

import ru.smal.model.AbstractEntity;

import java.util.List;

public interface ServiceApi <E extends AbstractEntity, K extends Number>{

    E findById(K key);
    List<E> findAll();
    boolean save(E entity);
    boolean update(E entity, K key);
    boolean delete(K key);
}
