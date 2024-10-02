<%--
  Created by IntelliJ IDEA.
  User: siddu
  Date: 10/1/2024
  Time: 12:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>SignUp</title>
    <%@include file="Component/allcss.jsp"%>
    <style>
        .paint-card{
            box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
        }
    </style>
    <script>
        function validatePassword() {
            let password = document.getElementsByName("password")[0].value;
            let confirmPassword = document.getElementsByName("confirmPassword")[0].value;

            if (password !== confirmPassword) {
                alert("Passwords do not match!");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<%@include file="Component/navbar.jsp"%>

<div class="container p-5">
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <div class="card paint-card">
                <div class="card-body">
                    <p class="fs-4 text-center">Register</p>

                    <% String errorMessage = (String) request.getAttribute("User already exists"); %>
                    <% if (errorMessage != null) { %>
                    <div class="alert alert-danger">
                        <%= errorMessage %>
                    </div>
                    <% } %>

                    <% String errorMessage1 = (String) request.getAttribute("Password Mismatch"); %>
                    <% if (errorMessage1 != null) { %>
                    <div class="alert alert-danger">
                        <%= errorMessage1 %>
                    </div>
                    <% } %>

                    <% String successMessage = (String) request.getAttribute("successMessage"); %>
                    <% if (successMessage != null) { %>
                    <div class="alert alert-success">
                        <%= successMessage %>
                    </div>
                    <% } %>

                    <form action="./Registration" method="post" onsubmit="return validatePassword()">
                        <div class="mb-3">
                            <label class="form-label">Full Name</label>
                            <input required name="Full_Name" type="text" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Select Role</label>
                            <select required name="Role" class="form-select">
                                <option value="" disabled selected>Select your role</option>
                                <option value="patient">Patient</option>
                                <option value="doctor">Doctor</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Email address</label>
                            <input required name="Email" type="email" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Password</label>
                            <input required name="Password" type="password" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Confirm Password</label>
                            <input required name="confirmPassword" type="password" class="form-control">
                        </div>
                        <br>
                        <button type="submit" class="btn bg-success text-white col-md-12">Register</button>
                    </form>
                    Already have an account?, <a href="index.jsp" class="clink text-decoration-none">Login</a>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="Component/footer.jsp"%>
</body>
</html>