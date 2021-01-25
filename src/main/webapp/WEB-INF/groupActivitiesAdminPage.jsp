<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Group Activities Page</title>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/custom.css">
</head>
<style>
    .logo{
        margin-left: 20px;
    }
    .logout{
        margin: 0px 70px;
        color: gray;
        text-decoration: none;
    }

    p{
        margin-top: 0 !important;
        margin-bottom: 0rem !important;
        margin-inline: auto !important;
    }
    .table{
        width: 71% !important;
    }

    a{
        text-decoration: none;
    }

</style>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: rgb(56, 56, 56) !important;">
    <a class="navbar-brand" href="/home"><img class="logo" src="/img/logo.png" width="200px"></a>

    <p class="mini_nav">
        <a style="color: white !important;" class="logout" href="/algorithmsProcess">Morning Algorithm</a>

        <a style="color: white !important;" class="logout" href="/groupActivitiesProcess">Group Activity</a>

        <a style="color: white !important;" class="logout" href="/index.html">Lobby</a>

        <a style="color: white !important;" class="logout" href="/logout">Logout</a>
        <img src="/img/alg7.png" width="45px">

    </p>
</nav>
        <br>
<center>
        <h2>${selectedCategory.name}</h2>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Title</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${categoryGroupActivities}" var="ga">
                <tr>
                    <td>${ga.title}</td>
                    <td><a href="/groupActivity/${ga.id}">View</a></td>
                    <td><a href="/groupActivities/${selectedCategory.id}/${ga.id}/delete">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
</center>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<footer class="bg-light text-center text-lg-start">
    <!-- Copyright -->
    <div class="text-center p-3" style="background-color: rgb(56, 56, 56); color: white;">
        © 2021 Copyright:
        <a class="text-dark" href="https://academy.axsos.ps/" style="color: white !important;">Axsos Acadmy</a>
    </div>
    <!-- Copyright -->
</footer>
</body>
</html>
