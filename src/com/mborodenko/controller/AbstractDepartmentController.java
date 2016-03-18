package com.mborodenko.controller;

import com.mborodenko.dao.DepartmentDao;
import com.mborodenko.dao.impl.DepartmentDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;

public abstract class AbstractDepartmentController extends HttpServlet{
    protected static String INSERT_OR_EDIT_DEPARTMENT = "/jsp/department.jsp";
    protected static String LIST_DEPARTMENT = "/jsp/listDepartment.jsp";
    protected RequestDispatcher view = null;
    protected DepartmentDao dao;

    @Override
    public void init() {
        dao = new DepartmentDaoImpl();
    }
}
