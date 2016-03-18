package com.mborodenko.controller;

import com.mborodenko.dao.DepartmentDao;
import com.mborodenko.dao.impl.DepartmentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewEmployeeController extends AbstractEmployeeController {

    private DepartmentDao departmentDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        departmentDao = new DepartmentDaoImpl();
        request.setAttribute("departments", departmentDao.getAllDepartments());

        int id_department = Integer.parseInt(request.getParameter("id_dep"));
        request.setAttribute("id_dep", id_department);

        view = request.getRequestDispatcher(INSERT_OR_EDIT_EMPLOYEE);
        view.forward(request, response);
    }
}
