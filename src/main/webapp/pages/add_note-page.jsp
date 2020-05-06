<%--
  Created by IntelliJ IDEA.
  User: JohnPank
  Date: 25.04.2020
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add note</title>
</head>
<body>

<div align="center">

    <h3>Добавить заметку</h3>

    <spring:form modelAttribute="note" method="post" action="saveNote">
        <spring:textarea path="content" rows="10" cols="50"/>
        <spring:button>Добавить</spring:button>

    </spring:form>


</div>

</body>
</html>
