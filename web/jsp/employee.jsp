<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <link type="text/css" rel="stylesheet" href="/css/myStyle.css"/>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="/resources/demos/style.css">

    <title>Add new user</title>
</head>
<body>
<script>
    $(function () {
        $('input[name=dob]').datepicker();
    });
</script>

<form method="POST" class="form-container" action='Add-Employee' name="frmAddEmployee">

    <input type="hidden" readonly="readonly" name="id"
           value="<c:out value="${employee.id}" />"/> <br/>

    <div class="tittle-field">First Name :</div>

    <div class="form-field">
        <input class="input-field" type="text" name="firstName"
               value="<c:out value="${employee.firstName}" />"/> <br/>
    </div>

    <div class="tittle-field">Last Name :</div>

    <div class="form-field">
        <input class="input-field" type="text" name="lastName"
               value="<c:out value="${employee.lastName}" />"/> <br/>
    </div>

    <div class="tittle-field">Day Of Birthday :</div>

    <div class="form-field">
        <input class="input-field" type="text" name="dob"
               value="<fmt:formatDate pattern="MM/dd/yyyy" value="${employee.dob}" />"/> <br/>
    </div>

    <div class="tittle-field">Salary :</div>

    <div class="form-field">
        <input class="input-field" type="text" name="salary"
               value="<c:out value="${employee.salary}" />"/> <br/>
    </div>

    <div class="tittle-field">Email :</div>

    <div class="form-field">
        <input class="input-field" type="text" name="email"
               value="<c:out value="${employee.email}" />"/> <br/>
    </div>

    <div class="tittle-field">Department ID :</div>

    <div class="form-field">
        <select class="select-field" name="id_department">
            <c:forEach items="${departments}" var="department">
                <option value="${department.departmentid}" ${department.departmentid == id_dep ? 'selected' : ''}>${department.name}</option>
            </c:forEach>
        </select>
    </div>

    <div class="submit-container">
        <input class="submit-button" type="submit" value="Submit"/>
    </div>
</form>
</body>
</html>
