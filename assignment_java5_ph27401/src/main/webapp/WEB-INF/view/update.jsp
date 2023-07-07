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
</head>
<body>
<section class="add"  class="container">
    <%--@elvariable id="nv" type=""--%>
    <form:form action="/nhan-vien/update" method="post" modelAttribute="nv"
               cssStyle="width: 60%;margin-left: 50px;">
        <form:hidden path="id" class="form-control"/>
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
        <form:button type="submit" class="btn btn-success">update</form:button>
    </form:form>
    <br>
</section>
</body>
</html>