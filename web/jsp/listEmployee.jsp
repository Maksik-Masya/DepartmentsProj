<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <link type="text/css" rel="stylesheet" href="/css/myStyle.css"/>
    <title>All Employees</title>
</head>
<body>
<div class="employee-table-form">
    <H1 id="department-tittle">Department: <c:out value="${department_name}"/></H1>
    <table border=1 class="employee-table-container">
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>DOB</th>
            <th>Salary</th>
            <th>Email</th>
            <th colspan=2>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td><c:out value="${employee.firstName}"/></td>
                <td><c:out value="${employee.lastName}"/></td>
                <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${employee.dob}"/></td>
                <td><c:out value="${employee.salary}"/></td>
                <td><c:out value="${employee.email}"/></td>
                <td>
                    <a href="Update-Employee?id=<c:out value="${employee.id}"/>&id_department=<c:out value="${employee.id_department}"/>">Update</a>
                </td>
                <td>
                    <a href="Delete-Employee?id=<c:out value="${employee.id}"/>&id_department=<c:out value="${employee.id_department}"/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a class="my-link" href="/New-Employee-Form?id_dep=<c:out value="${id_department}"/>">Add Employee</a>
    <a class="my-link" href="/List-Departments">All Departments</a>

</div>
</body>
</html>