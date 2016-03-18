package com.mborodenko.controller;

import com.mborodenko.dao.DepartmentDao;
import com.mborodenko.dao.impl.DepartmentDaoImpl;
import com.mborodenko.model.Employee;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddOrEditEmployeeController extends AbstractEmployeeController {

    private DepartmentDao departmentDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        view = request.getRequestDispatcher(INSERT_OR_EDIT_EMPLOYEE);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Employee employee = new Employee();
        employee.setFirstName(request.getParameter("firstName"));
        employee.setLastName(request.getParameter("lastName"));

        try {
            Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
            employee.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee.setSalary(Integer.parseInt(request.getParameter("salary")));
        employee.setEmail(request.getParameter("email"));

        int id_department = Integer.parseInt(request.getParameter("id_department"));
        employee.setId_department(id_department);
        String id = request.getParameter("id");

        if(id == null || id.isEmpty()) {
            dao.addEmployee(employee);
        }
        else {
            employee.setId(Integer.parseInt(id));
            dao.updateEmployee(employee);
        }

        departmentDao = new DepartmentDaoImpl();

        view = request.getRequestDispatcher(LIST_EMPLOYEE);
        request.setAttribute("employees", dao.getEmployeeByDepartmentId(id_department));
        request.setAttribute("id_department", id_department);
        request.setAttribute("department_name", departmentDao.getDepartmentById(id_department).getName());


        view.forward(request, response);
    }
}
