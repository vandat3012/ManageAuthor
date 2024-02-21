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

<table class="table" border="1px">
    <thead>
    <form action="/assignment" method="post">
        <input name="action" value="find" hidden="">
        <input name="nameAuthor">
        <button class="btn btn-warning" type="submit">Find</button>
    </form>
    <h1 align="center" class="">LIST ASSIGNMENT</h1>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">DATE START</th>
        <th scope="col">DATE END</th>
        <th scope="col">NOTE</th>
        <th scope="col">NAME POSTS</th>
        <th scope="col">NAME AUTHOR</th>
        <th scope="col">PRICE</th>
        <th scope="col">EDIT</th>
        <th scope="col">DELETE</th>
    </tr>
    </thead>
    <c:forEach items="${dtoAssignment}" var="a">
        <tbody>
        <tr>
            <th >${a.id}</th>
            <td>${a.dateStart}</td>
            <td>${a.dateEnd}</td>
            <td>${a.note}</td>
            <td>${a.namePost}</td>
            <td>${a.nameAuthor}</td>
            <td>${a.price}</td>
            <td>
                <a class="btn btn-warning" href="/assignment?action=edit&id=${a.id}" role="button">Edit</a>
            </td>
            <td>
                <a class="btn btn-warning" href="/assignment?action=delete&id=${a.id}" role="button">Delete</a>
            </td>
        </tr>
        </tbody>
    </c:forEach>

</table>
<div class="row justify-content-center mt-4">
    <a class="btn btn-warning" href="/assignment?action=create" role="button">Create New Assignment</a>
</div>

</body>
</html>
