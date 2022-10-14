package ru.smal.service;

import ru.smal.model.Group;

import java.util.List;

public interface GroupService extends ServiceApi<Group, Integer>{
    @Override
    Group findById(Integer key);

    @Override
    List<Group> findAll();

    @Override
    boolean save(Group entity);

    @Override
    boolean update(Group entity, Integer key);

    @Override
    boolean delete(Integer key);
}
