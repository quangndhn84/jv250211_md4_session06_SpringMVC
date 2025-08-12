<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/12/2025
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Students</title>
</head>
<body>
<h3>List Students</h3>
<table border="1">
    <thead>
    <tr>
        <th>No</th>
        <th>Student Id</th>
        <th>Student Name</th>
        <th>Age</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listStudents}" var="student" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${student.studentId}</td>
            <td>${student.studentName}</td>
            <td>${student.age}</td>
            <td>${student.status?"Active":"Inactive"}</td>
            <td>
                <a href="<%=request.getContextPath()%>/StudentController/initUpdate?studentId=${student.studentId}">Update</a>
                <a href="<%=request.getContextPath()%>/StudentController/delete?studentId=${student.studentId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/StudentController/initCreate">Create new student....</a>
</body>
</html>
