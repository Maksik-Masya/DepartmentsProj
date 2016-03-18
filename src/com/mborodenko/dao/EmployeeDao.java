package com.mborodenko.dao;

import com.mborodenko.model.Employee;

import java.util.List;

public interface EmployeeDao {

    public void addEmployee(Employee employee);

    public void deleteEmployee(int id);

    public void updateEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(int id);

    public List<Employee> getEmployeeByDepartmentId(int id_department);
}
