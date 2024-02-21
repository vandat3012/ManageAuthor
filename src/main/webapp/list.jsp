<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 21/02/2024
  Time: 9:55 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">NAME</th>
        <th scope="col">AGE</th>
        <th scope="col">ADDRESS</th>
        <th scope="col">PHONE NUMBER</th>
        <th scope="col">NAME POSTS</th>
        <th scope="col">DATES</th>
        <th scope="col">PRICE</th>
        <th scope="col">EDIT</th>
        <th scope="col">DELETE</th>
    </tr>
    </thead>
    <c:forEach items="assignment" var="a">
        <tbody>
        <tr>
            <th scope="row">${a.id}</th>
            <td>${a.name}</td>
            <td>${a.age}</td>
            <td>${a.address}</td>
            <td>${a.phoneNumber}</td>
            <td>${a.namePost}</td>
            <td>${a.date}</td>
            <td>${a.price}</td>
            <td></td>
            <td></td>
        </tr>
        </tbody>
    </c:forEach>

</table>
</body>
</html>
