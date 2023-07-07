<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <style>
        form {
            width: 50%;
            margin: auto;
            padding-top: 15px;
        }
    </style>
</head>
<body  class="container">
<%@include file="/WEB-INF/view/footer/header.jsp"%>
<h3>ChucVu</h3>
<section class="add">
    <%--@elvariable id="cv" type=""--%>
    <form:form action="/chuc-vu/add" method="post" modelAttribute="cv">

        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Ma</label>
            <div class="col-sm-10">
                <form:input path="ma"  class="form-control"/>
                <form:errors path="ma"/>
            </div>
        </div>

        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Ten</label>
            <div class="col-sm-10">
                <form:input path="ten"  class="form-control"/>
                <form:errors path="ten"/>
            </div>
        </div>
        <form:button type="submit" class="btn btn-success">add</form:button>
    </form:form>
</section>
<table class="table">
    <thead>
    <tr>
        <th scope="col">stt</th>
        <th scope="col">id</th>
        <th scope="col">ma</th>
        <th scope="col">ten</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${lophocPage.content}" var="cv" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${cv.id}</td>
            <td>${cv.ma}</td>
            <td>${cv.ten}</td>

            <td>
                <a href="/chuc-vu/update/${cv.id}" class="btn btn-success">update</a>
                <a href="/chuc-vu/delete/${cv.id}" class="btn btn-success">delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div>
    <c:choose>
        <c:when test="${lophocPage.number > 0}">
            <a href="?page=${lophocPage.number - 1}&size=${lophocPage.size}" class="btn btn-primary">Previous</a>
        </c:when>
        <c:otherwise>
            <a class="btn btn-primary disabled">Previous</a>
        </c:otherwise>
    </c:choose>
    <c:forEach begin="1" end="${lophocPage.totalPages}" varStatus="status">
        <c:choose>
            <c:when test="${status.index == lophocPage.number}">
                <a href="?page=${status.index}&size=${lophocPage.size}"
                   class="btn btn-primary active">${status.index}</a>
            </c:when>
            <c:otherwise>
                <a href="?page=${status.index}&size=${lophocPage.size}" class="btn btn-primary">${status.index}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:choose>
        <c:when test="${lophocPage.number < lophocPage.totalPages - 1}">
            <a href="?page=${lophocPage.number + 1}&size=${lophocPage.size}" class="btn btn-primary">Next</a>
        </c:when>
        <c:otherwise>
            <a class="btn btn-primary disabled">Next</a>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>