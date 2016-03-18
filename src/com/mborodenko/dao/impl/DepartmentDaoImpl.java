package com.mborodenko.dao.impl;

import com.mborodenko.dao.DepartmentDao;
import com.mborodenko.model.Department;
import com.mborodenko.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DepartmentDaoImpl implements DepartmentDao {

    private final String INSERT_QUERY = "INSERT INTO departments(name) VALUES (?)";
    private final String DELETE_QUERY = "DELETE FROM departments WHERE id=?";
    private final String UPDATE_QUERY = "UPDATE departments SET name=? WHERE id=?";
    private final String SELECT_QUERY = "SELECT * FROM departments";
    private final String SELECT_WHERE_QUERY = "SELECT * FROM departments WHERE id=?";

    @Override
    public void addDepartment(Department department) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, department.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDepartment(int departmentId) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)) {
            preparedStatement.setInt(1, departmentId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDepartment(Department department) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setString(1, department.getName());
            preparedStatement.setInt(2, department.getDepartmentid());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<Department>();
        try (Connection connection = DbUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(SELECT_QUERY)) {
            while (rs.next()) {
                Department department = new Department();
                department.setDepartmentid(rs.getInt("id"));
                department.setName(rs.getString("name"));
                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departments;
    }

    @Override
    public Department getDepartmentById(int departmentId) {
        Department department = new Department();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(SELECT_WHERE_QUERY)) {
            preparedStatement.setInt(1, departmentId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                department.setDepartmentid(rs.getInt("id"));
                department.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return department;
    }
}

