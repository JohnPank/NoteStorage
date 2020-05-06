<%--
  Created by IntelliJ IDEA.
  User: JohnPank
  Date: 23.04.2020
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Note list</title>
</head>
<body>
<div align="center">

    <H3>Список заметок</H3>

    <table border="1">

        <tr>
            <td>ID</td>
            <td>ID Пользователя</td>
            <td>Заметка</td>
            <td>Дата создания</td>
            <td>Дата изменения</td>
        </tr>
        <c:forEach items="${noteList}" var="note">
            <tr>
                <td>${note.note_id}</td>
                <td>${note.user_id}</td>
                <td>${note.content}</td>
                <td>${note.creation_date}</td>
                <td>${note.edit_date}</td>
            </tr>
        </c:forEach>
    </table>
</div>



</body>
</html>
