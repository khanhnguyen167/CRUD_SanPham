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
<h3>Nsx</h3>
<section class="add">

    <%--@elvariable id="nsx" type=""--%>
    <form:form action="/nsx/add" method="post" modelAttribute="nsx">
        <form:input path="id" type="hidden"/>
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
        <form:button type="submit" class="btn btn-success">update</form:button>
    </form:form>
</section>
</body>
</html>