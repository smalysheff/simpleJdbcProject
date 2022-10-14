package ru.smal.dao.impl;

import ru.smal.configuration.ConnectionConfig;
import ru.smal.dao.StudentDao;
import ru.smal.model.Student;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private final ConnectionConfig connectionConfig;

    public StudentDaoImpl() {
        this.connectionConfig = new ConnectionConfig();
    }

    @Override
    public Student findById(Integer key) {
        Connection connection = connectionConfig.getConnection();
        Student student = new Student();
        try {
            String sql = "select * from COLLEGE.STUDENTS WHERE ID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, key);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                student.setId(resultSet.getInt(1));
                student.setFirstName(resultSet.getString(2));
                student.setLastName(resultSet.getString(3));
                student.setGroupId(resultSet.getInt(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionConfig.close();
        }

        return student;
    }

    @Override
    public List<Student> findAll() {
        Connection connection = connectionConfig.getConnection();
        List<Student> students = new ArrayList<>();
        try {
            String sql = "select * from COLLEGE.STUDENTS";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                students.add(
                        new Student(
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getInt(4),
                                resultSet.getInt(5)
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionConfig.close();
        }
        return students;
    }

    @Override
    public boolean save(Student entity) {
        Connection connection = connectionConfig.getConnection();
        try {
            String sql = "insert into COLLEGE.STUDENTS (first_name, last_name, age, group_id) values (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setInt(3, entity.getAge());
            statement.setInt(4, entity.getGroupId());
            return statement.executeUpdate() == SUCCESS;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionConfig.close();
        }
    }

    @Override
    public boolean update(Student entity, Integer key) {
        Connection connection = connectionConfig.getConnection();
        try{
            String sql = "update COLLEGE.STUDENTS set FIRST_NAME=?, LAST_NAME=?, AGE=?, GROUP_ID=? where ID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setInt(3, entity.getAge());
            statement.setInt(4, entity.getGroupId());
            statement.setInt(5, key);
            return statement.executeUpdate() == SUCCESS;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionConfig.close();
        }
    }

    @Override
    public boolean delete(Integer key) {
        return false;
    }
}
