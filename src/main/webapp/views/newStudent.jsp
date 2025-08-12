<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/12/2025
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Student</title>
</head>
<body>
<h3>Create a new student</h3>
<%-- map đối tượng student trong model vào form   --%>
<%-- Cơ chế của databinding: tự động ánh và chuyển đổi kiễu dữ liệu   --%>
<form action="<%=request.getContextPath()%>/StudentController/create" method="post">
    <label for="studentName">Student Name</label>
    <input type="text" id="studentName" name="studentName"/><br>
    <%--  request.getParameter("age")--> String --> int --> age --%>
    <label for="age">Age</label>
    <input type="text" id="age" name="age"/><br>
    <input type="submit" value="Create"/>
</form>
</body>
</html>
