package com.mborodenko.controller;

import com.mborodenko.model.Department;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditDepartmentController extends AbstractDepartmentController {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int departmentId = Integer.parseInt(request.getParameter("departmentId"));
        Department department = dao.getDepartmentById(departmentId);
        request.setAttribute("department", department);

        view = request.getRequestDispatcher(INSERT_OR_EDIT_DEPARTMENT);
        view.forward(request, response);
    }
}
