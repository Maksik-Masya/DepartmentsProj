package com.mborodenko.controller;

import com.mborodenko.dao.DepartmentDao;
import com.mborodenko.dao.impl.DepartmentDaoImpl;
import com.mborodenko.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditEmployeeController extends AbstractEmployeeController {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = dao.getEmployeeById(id);
        request.setAttribute("employee", employee);

        DepartmentDao departmentDao = new DepartmentDaoImpl();
        request.setAttribute("departments", departmentDao.getAllDepartments());

        int id_department = Integer.parseInt(request.getParameter("id_department"));
        request.setAttribute("id_dep", id_department);

        view = request.getRequestDispatcher(INSERT_OR_EDIT_EMPLOYEE);
        view.forward(request, response);
    }
}
