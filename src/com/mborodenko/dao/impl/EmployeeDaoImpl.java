package com.mborodenko.dao.impl;

import com.mborodenko.dao.EmployeeDao;
import com.mborodenko.model.Employee;
import com.mborodenko.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private final String INSERT_QUERY = "INSERT INTO employees(first_name, last_name, dob, salary, email, id_department) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
    private final String DELETE_QUERY = "DELETE FROM employees WHERE id=?";
    private final String UPDATE_QUERY = "UPDATE employees SET first_name=?, last_name=?, dob=?, salary=?, email=?, id_department=?" +
            " WHERE id=?";
    private final String SELECT_ALL_QUERY = "SELECT * FROM employees";
    private final String SELECT_WHERE_QUERY = "SELECT * FROM employees WHERE id_department=?";
    private final String SELECT_BY_ID_QUERY = "SELECT * FROM employees WHERE id=?";

    @Override
    public void addEmployee(Employee employee) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            fillPreparedStatement(employee, preparedStatement, false);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void fillPreparedStatement(Employee employee, PreparedStatement preparedStatement, boolean isUpdating)
            throws SQLException {

        preparedStatement.setString(1, employee.getFirstName());
        preparedStatement.setString(2, employee.getLastName());
        preparedStatement.setDate(3, new Date(employee.getDob().getTime()));
        preparedStatement.setInt(4, employee.getSalary());
        preparedStatement.setString(5, employee.getEmail());
        preparedStatement.setInt(6, employee.getId_department());
        if (isUpdating) {
            preparedStatement.setInt(7, employee.getId());
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY))
        {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY))
        {
            fillPreparedStatement(employee, preparedStatement, true);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<Employee>();

        try (Connection connection = DbUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(SELECT_ALL_QUERY)) {
            while (rs.next()) {
                employees.add(getEmployeeFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(SELECT_BY_ID_QUERY)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                employee = getEmployeeFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }

    @Override
    public List<Employee> getEmployeeByDepartmentId(int id_department) {
        List<Employee> employees = new ArrayList<Employee>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(SELECT_WHERE_QUERY)) {
            preparedStatement.setInt(1, id_department);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                employees.add(getEmployeeFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    private Employee getEmployeeFromResultSet(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setDob(rs.getDate("dob"));
        employee.setSalary(rs.getInt("salary"));
        employee.setEmail(rs.getString("email"));
        employee.setId_department(rs.getInt("id_department"));
        return employee;
    }
}

