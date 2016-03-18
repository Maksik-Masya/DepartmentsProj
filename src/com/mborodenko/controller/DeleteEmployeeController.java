package com.mborodenko.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteEmployeeController extends AbstractEmployeeController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        int id_department = Integer.parseInt(request.getParameter("id_department"));
        dao.deleteEmployee(id);
        request.setAttribute("employees", dao.getEmployeeByDepartmentId(id_department));

        view = request.getRequestDispatcher(LIST_EMPLOYEE);
        view.forward(request, response);
    }
}
