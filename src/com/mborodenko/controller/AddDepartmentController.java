package com.mborodenko.controller;

import com.mborodenko.model.Department;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddDepartmentController extends AbstractDepartmentController {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        view = request.getRequestDispatcher(INSERT_OR_EDIT_DEPARTMENT);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Department department = new Department();
        department.setName(request.getParameter("name"));

        String departmentId = request.getParameter("departmentId");
        if (departmentId == null || departmentId.isEmpty()) {
            dao.addDepartment(department);
        } else {
            department.setDepartmentid(Integer.parseInt(departmentId));
            dao.updateDepartment(department);
        }

        request.setAttribute("departments", dao.getAllDepartments());
        view = request.getRequestDispatcher(LIST_DEPARTMENT);
        view.forward(request, response);
    }
}
