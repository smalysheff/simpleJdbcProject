package ru.smal.service.impl;

import ru.smal.dao.StudentDao;
import ru.smal.dao.impl.StudentDaoImpl;
import ru.smal.model.Student;
import ru.smal.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public StudentServiceImpl() {
        this.studentDao = new StudentDaoImpl();
    }

    @Override
    public Student findById(Integer key) {
        return studentDao.findById(key);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public boolean save(Student entity) {
        return studentDao.save(entity);
    }

    @Override
    public boolean update(Student entity, Integer key) {
        return studentDao.update(entity, key);
    }

    @Override
    public boolean delete(Integer key) {
        return studentDao.delete(key);
    }
}
