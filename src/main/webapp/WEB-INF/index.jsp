<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login & Registration</title>
    <link rel="stylesheet" href="css/style.css">
    <script defer src="https://use.fontawesome.com/releases/v5.1.0/js/all.js"></script>
</head>
<body style="background-image: url('/img/bgd.jpg');">


        <p><form:errors path="user.*"/></p>
        <c:out value="${error}"/>

<%--         registr form--%>
    <div class="container" id="container">
        <div class="form-container sign-up-container">

            <form:form method="POST" action="/registration" modelAttribute="user">
                <form:label path="name"></form:label>
                <form:input path="name"  placeholder="Name" />

                <form:label path="email"></form:label>
                <form:input path="email" placeholder="Email" />

                <form:label path="password"></form:label>
                <form:input path="password" type="password" placeholder="Password" />

                <form:label path="passwordConfirmation" ></form:label>
                <form:input path="passwordConfirmation" type="password" placeholder="Password Confirmation" />
                <br>
                <button input type="submit" value="Register!">Sign Up</button>
            </form:form>
        </div>


<%--        login form--%>
        <div class="form-container sign-in-container">
            <form method="post" action="/login">
                <h1>Sign in</h1>
                <div class="social-container">
                    <a href="https://www.facebook.com/AXSOSAcademy" class="social"><i class="fab fa-facebook-f"></i></a>
                    <a href="https://www.linkedin.com/school/axsos-academy/" class="social"><i class="fab fa-linkedin-in"></i></a>
                    <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                </div>

<%--                <span>or use your account</span>--%>

                <label type="email" for="email" ></label>
                <input type="text" id="email" name="email" placeholder="Email"/>

                <label for="password"></label>
                <input type="password" id="password" name="password" placeholder="Password" />
                <br>
                <button type="submit" value="Login">Sign In</button>
            </form>
        </div>


        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1>Welcome Back!</h1>
                    <p>To keep connected with us please login with your personal info</p>
                    <button class="ghost" id="signIn">Sign In</button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h1>Hello, Friend!</h1>
                    <p>Enter your personal details and start journey with us</p>
                    <button class="ghost" id="signUp">Sign Up</button>
                </div>
            </div>
        </div>
    </div>



<%--                code javascript--%>
    <script>

        const signUpButton = document.getElementById('signUp');
        const signInButton = document.getElementById('signIn');
        const container = document.getElementById('container');

        signUpButton.addEventListener('click', () => {
            container.classList.add("right-panel-active");
        });

        signInButton.addEventListener('click', () => {
            container.classList.remove("right-panel-active");
        });

    </script>

</body>
</html>