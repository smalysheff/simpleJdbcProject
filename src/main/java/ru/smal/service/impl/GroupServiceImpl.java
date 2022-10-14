package ru.smal.service.impl;

import ru.smal.dao.GroupDao;
import ru.smal.dao.impl.GroupDaoImpl;
import ru.smal.model.Group;
import ru.smal.service.GroupService;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    private final GroupDao dao;

    public GroupServiceImpl() {
        this.dao = new GroupDaoImpl();
    }

    @Override
    public Group findById(Integer key) {
        return dao.findById(key);
    }

    @Override
    public List<Group> findAll() {
        return dao.findAll();
    }

    @Override
    public boolean save(Group entity) {
        return dao.save(entity);
    }

    @Override
    public boolean update(Group entity, Integer key) {
        return dao.update(entity, key);
    }

    @Override
    public boolean delete(Integer key) {
        return dao.delete(key);
    }
}
