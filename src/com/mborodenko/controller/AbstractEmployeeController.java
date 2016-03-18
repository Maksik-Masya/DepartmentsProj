package com.mborodenko.controller;

import com.mborodenko.dao.EmployeeDao;
import com.mborodenko.dao.impl.EmployeeDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;

public abstract class AbstractEmployeeController extends HttpServlet {
    protected static String INSERT_OR_EDIT_EMPLOYEE = "/jsp/employee.jsp";
    protected static String LIST_EMPLOYEE = "/jsp/listEmployee.jsp";
    protected RequestDispatcher view = null;
    protected EmployeeDao dao;

    @Override
    public void init() {
        dao = new EmployeeDaoImpl();
    }
}
