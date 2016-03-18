package com.mborodenko.controller;

import com.mborodenko.dao.DepartmentDao;
import com.mborodenko.dao.impl.DepartmentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListEmployeeOfDepartmentController extends AbstractEmployeeController {

    private DepartmentDao departmentDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        departmentDao = new DepartmentDaoImpl();

        int id_department = Integer.parseInt(request.getParameter("departmentId"));

        request.setAttribute("employees", dao.getEmployeeByDepartmentId(id_department));
        request.setAttribute("id_department", id_department);
        request.setAttribute("department_name", departmentDao.getDepartmentById(id_department).getName());

        view = request.getRequestDispatcher(LIST_EMPLOYEE);
        view.forward(request, response);
    }
}
