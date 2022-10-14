package ru.smal.dao;

import ru.smal.model.Student;

import java.util.List;

public interface StudentDao extends CrudDao<Student, Integer> {

    @Override
    Student findById(Integer key);

    @Override
    List<Student> findAll();

    @Override
    boolean save(Student entity);

    @Override
    boolean update(Student entity, Integer key);

    @Override
    boolean delete(Integer key);
}
