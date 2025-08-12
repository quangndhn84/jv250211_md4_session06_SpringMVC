<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/12/2025
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
</head>
<body>
<h3>Update Student</h3>
<form action="<%=request.getContextPath()%>/StudentController/update" method="post">
    <label for="studentId">Student Id</label>
    <input type="text" id="studentId" name="studentId" value="${student.studentId}" readonly/><br>
    <label for="studentName">Student Name</label>
    <input type="text" id="studentName" name="studentName" value="${student.studentName}"/><br>
    <%--  request.getParameter("age")--> String --> int --> age --%>
    <label for="age">Age</label>
    <input type="text" id="age" name="age" value="${student.age}"/><br>
    <label for="active">Status</label>
    <input type="radio" id="active" name="status" value="true" ${student.status?"checked":""}/><label for="active">Active</label>
    <input type="radio" id="Inactive" name="status" value="false" ${student.status?"":"checked"}/><label for="Inactive">Inactive</label><br>
    <input type="submit" value="Update"/>
</form>
</body>
</html>
