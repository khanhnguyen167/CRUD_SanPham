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
<h3>ChiTietSP</h3>
<section class="add">
    <%--@elvariable id="cv" type=""--%>
    <form:form action="/chitietsp/update" method="post" modelAttribute="cts">
        <form:input path="id" type="hidden"/>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">sanPham</label>
            <div class="col-sm-10">

                <form:select path="sanPham" class="form-control">
                    <c:forEach items="${sanpham}" var="sp">
                        <form:option value="  ${sp.id}"> ${sp.ma}</form:option>
                    </c:forEach>
                </form:select>
            </div>
        </div>

        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">nsx</label>
            <div class="col-sm-10">

                <form:select path="nsx" class="form-control">
                    <c:forEach items="${nsx}" var="sp">
                        <form:option value="  ${sp.id}"> ${sp.ma}</form:option>
                    </c:forEach>
                </form:select>
            </div>
        </div>

        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">mau</label>
            <div class="col-sm-10">

                <form:select path="mauSac" class="form-control">
                    <c:forEach items="${mau}" var="sp">
                        <form:option value="  ${sp.id}"> ${sp.ma}</form:option>
                    </c:forEach>
                </form:select>
            </div>
        </div>

        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">dongsp</label>
            <div class="col-sm-10">

                <form:select path="dongSp" class="form-control">
                    <c:forEach items="${dongsp}" var="sp">
                        <form:option value="  ${sp.id}"> ${sp.ma}</form:option>
                    </c:forEach>
                </form:select>
            </div>
        </div>

        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">namBh</label>
            <div class="col-sm-10">
                <form:input path="namBh" class="form-control"/>
                <form:errors path="namBh" class="error-message"/>
            </div>
        </div>

        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">moTa</label>
            <div class="col-sm-10">
                <form:input path="moTa" class="form-control"/>
                <form:errors path="moTa"/>
            </div>
        </div>

        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">soLuongTon</label>
            <div class="col-sm-10">
                <form:input path="soLuongTon" class="form-control"/>
                <form:errors path="soLuongTon"/>
            </div>
        </div>


        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">giaNhap</label>
            <div class="col-sm-10">
                <form:input path="giaNhap" class="form-control"/>
                <form:errors path="giaNhap"/>
            </div>
        </div>

        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">giaBan</label>
            <div class="col-sm-10">
                <form:input path="giaBan" class="form-control"/>
                <form:errors path="giaBan"/>
            </div>
        </div>
        <form:button type="submit" class="btn btn-success">update</form:button>
    </form:form>


</section>


</body>
</html>