<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</head>
<body class="container">

<%@include file="/WEB-INF/view/footer/header.jsp"%>
<h3>NhanVien</h3>
<section class="add">
    <%--@elvariable id="nv" type=""--%>
    <form:form action="/nhan-vien/add" method="post" modelAttribute="nv"
               cssStyle="width: 60%;margin-left: 50px;">
        Ma:<form:input path="ma" class="form-control" readonly="false"/>
        <form:errors path="ma"/>
        <br>
        Ho:<form:input path="ho" class="form-control"/>
        <form:errors path="ho"/>
        <br>
        Ten Dem:<form:input path="tenDem" class="form-control"/>
        <form:errors path="tenDem"/>
        <br>
        Ten:<form:input path="ten" class="form-control"/>
        <form:errors path="ten"/>
        <br>
       Gioi Tinh:
        <form:radiobutton path="gioiTinh" value="Nam" checked="true"/>Nam
        <form:radiobutton path="gioiTinh" value="Nu"/>Nu
        <br>
        <br>

        <div class="mb-3">
            <label class="form-label">ChucVu:</label>
            <form:select path="chucVu" class="form-select">
                <c:forEach items="${chucVu}" var="chucVu">
                    <form:option value="${chucVu.id}">${chucVu.ten}</form:option>
                </c:forEach>
            </form:select>
        </div>

        <div class="mb-3">
            <label class="form-label">CuaHang</label>
            <form:select path="cuaHang" class="form-select">
                <c:forEach items="${cuaHang}" var="cuaHang">
                    <form:option value="${cuaHang.id}">${cuaHang.ten}</form:option>
                </c:forEach>
            </form:select>
        </div>
        <br>
        Năm Sinh:
        <form:select path="ngaySinh" class="form-control">
            <c:forEach begin="2000" end="2030" var="nhanVien">
                <form:option value="${nhanVien}">${nhanVien}</form:option>
            </c:forEach>
        </form:select>
        <br>
        <br>
        <form:button type="submit" class="btn btn-success">Add</form:button>
    </form:form>
    <br>
</section>
<table class="table" style="width: 80%">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Ma</th>
        <th scope="col">HoVaTen</th>
        <th scope="col">GioiTinh</th>
        <th scope="col">Tuoi</th>
        <th scope="col">ChucVu</th>
        <th scope="col">CuaHang</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach varStatus="index" var="nv" items="${lophocPage.content}">
        <tr>
            <td>${index.index}</td>
            <td>${nv.ma}</td>
            <td>${nv.ho} ${nv.tenDem} ${nv.ten}</td>
            <td>${nv.gioiTinh}</td>
            <td>${2023-nv.namSinh()}</td>
            <td>${nv.chucVu.ten}</td>
            <td>${nv.cuaHang.ten}</td>
            <td>
                <a href="/nhan-vien/view-update/${nv.id}" class="btn btn-success">Update</a>
                <a href="/nhan-vien/remove/${nv.id}"  class="btn btn-success">Remove</a>
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
                <a href="?page=${status.index}&size=${lophocPage.size}" class="btn btn-primary active">${status.index}</a>
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