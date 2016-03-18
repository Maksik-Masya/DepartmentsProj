package com.mborodenko.dao;


import com.mborodenko.model.Department;

import java.util.List;

public interface DepartmentDao {

    public void addDepartment(Department department);

    public void deleteDepartment(int departmentId);

    public void updateDepartment(Department department);

    public List<Department> getAllDepartments();

    public Department getDepartmentById(int departmentId);
}