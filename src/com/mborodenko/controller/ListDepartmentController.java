package com.mborodenko.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListDepartmentController extends AbstractDepartmentController {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("departments", dao.getAllDepartments());

        view = request.getRequestDispatcher(LIST_DEPARTMENT);
        view.forward(request, response);
    }
}
