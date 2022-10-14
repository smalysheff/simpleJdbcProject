package ru.smal.dao.impl;

import ru.smal.configuration.ConnectionConfig;
import ru.smal.dao.GroupDao;
import ru.smal.model.Group;
import ru.smal.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDaoImpl implements GroupDao {

    private final ConnectionConfig connectionConfig;

    public GroupDaoImpl() {
        this.connectionConfig = new ConnectionConfig();
    }

    @Override
    public Group findById(Integer key) {
        Connection connection = connectionConfig.getConnection();
        Group group = new Group();
        try {
            String sql = "select * from COLLEGE.GROUPS where id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, key);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                group.setId(resultSet.getInt(1));
                group.setCode(resultSet.getString(2));
                group.setName(resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionConfig.close();
        }

        return group;
    }

    @Override
    public List<Group> findAll() {
        Connection connection = connectionConfig.getConnection();
        List<Group> groups = new ArrayList<>();
        try {
            String sql = "select * from COLLEGE.GROUPS";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                groups.add(
                        new Group(
                                resultSet.getString(2),
                                resultSet.getString(3)
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionConfig.close();
        }
        return groups;
    }

    @Override
    public boolean save(Group entity) {
        Connection connection = connectionConfig.getConnection();
        try {
            String sql = "insert into COLLEGE.GROUPS (CODE, NAME) values (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getCode());
            statement.setString(2, entity.getName());
            return statement.executeUpdate() == SUCCESS;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionConfig.close();
        }
    }

    @Override
    public boolean update(Group entity, Integer key) {
        Connection connection = connectionConfig.getConnection();
        try {
            String sql = "update COLLEGE.GROUPS set code=?, name=? where id=? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getCode());
            statement.setString(2, entity.getName());
            statement.setInt(3, key);
            return statement.executeUpdate() == SUCCESS;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionConfig.close();
        }
    }

    @Override
    public boolean delete(Integer key) {
        Connection connection = connectionConfig.getConnection();
        try {
            String sql = "delete from COLLEGE.GROUPS where id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, key);
            return statement.executeUpdate() == SUCCESS;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionConfig.close();
        }
    }
}
