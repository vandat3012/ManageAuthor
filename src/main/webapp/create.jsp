<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 21/02/2024
  Time: 9:49 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Create</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<form method="post">
    <div class="mb-3">
        <label for="exampleInputAge" class="form-label">Date Start</label>
        <input type="text" name="dateS"  class="form-control" id="exampleInputAge">
    </div>
    <div class="mb-3">
        <label for="exampleInputAddress" class="form-label">Date End</label>
        <input type="text" name="dateE"  class="form-control" id="exampleInputAddress">
    </div>
    <div class="mb-3">
        <label for="exampleInputPhone" class="form-label">Note</label>
        <input type="text" name="note"  class="form-control" id="exampleInputPhone">
    </div>
    <div class="mb-3">
        <label class="form-select">Name Posts</label>
        <select name="id_post" class="form-select" aria-label="Default select example">
            <option selected>Open this select menu</option>
            <c:forEach items="${post}" var="p">
                <option value="${p.id}">${p.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-select">Author</label>
        <select name="id_author" class="form-select" aria-label="Default select example">
            <option selected>Open this select menu</option>
            <c:forEach items="${authors}" var="a">
                <option value="${a.id}">${a.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label class="form-select">Price</label>
        <select name="id_author" class="form-select" aria-label="Default select example">
            <option selected>Open this select menu</option>
            <c:forEach items="${authors}" var="a">
                <option value="${a.id}">${a.price}</option>
            </c:forEach>
        </select>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
