<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Topics of Algorithms</title>

    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
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
        <div>
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
        </div>
        <br><br>
<center>
        <div class="border1">
            <label path="groups">Generate Groups of</label>
            <input path="groups" type="text"/>
            <button style="background-color: #691489" class="btn btn-primary" style="color: white">Go</button>
        <br><br>

        <form:form action="/algorithms/new" method="post" modelAttribute="algorithm">

        <form:label path="topic">Topic</form:label>
        <form:select  path="topic">
            <c:forEach items="${allTopics}" var="tpc">
                <option value="${tpc.id}"><c:out value="${tpc.title}"/></option>
            </c:forEach>
        </form:select>
<%--            <br/>--%>
        <button style="background-color: #691489" class="btn btn-primary"><a href="/addTopic" style="color: white" >Add a Topic</a></button>
<%--        <br><br>--%>

        Upload Files
        <form:label path="title">Algorithm title</form:label>
        <form:input path="title" type="text"/>
<%--<br/>--%>
        <form:label path="question">Algorithm</form:label>
        <form:input path="question" type="text"/>
<%--            <br/>--%>
        <form:label path="answer">Answer</form:label>
        <form:input path="answer" type="text"/>
            <br/><br/>
        <button style="background-color: #691489" class="btn btn-primary">Add Algorithm</button>
        </form:form>

        </div>

        <br><br>


        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">Title</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${allTopics}" var="t">
            <tr>
                <td><a href="/algorithms/${t.id}">${t.title}</a></td>
                <td><a href="/algorithms/${t.id}/delete">Delete</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
</center>
<br><br><br>
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
