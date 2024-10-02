<%--
  Created by IntelliJ IDEA.
  User: siddu
  Date: 10/2/2024
  Time: 11:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.hms.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Change Password</title>
    <%@include file="Component/allcss.jsp"%>
    <style type="text/css">
        .paint-card {
            box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
        }
    </style>
</head>
<body>

<%@include file="Component/navbar.jsp"%>

<%
    // Check if userObj is in the session, if not redirect to login page
    if (session.getAttribute("userObj") == null) {
        response.sendRedirect("user_login.jsp");
        return;
    }

    // Get success and error messages if they exist
    String successMsg = (String) session.getAttribute("successMsg");
    String errorMsg = (String) session.getAttribute("errorMsg");
    session.removeAttribute("successMsg");
    session.removeAttribute("errorMsg");

    // Get user object from session
    User user = (User) session.getAttribute("userObj");
%>

<div class="container p-4">
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <div class="card paint-card">
                <p class="text-center fs-3">Change Password</p>

                <% if (successMsg != null) { %>
                <p class="text-center text-success fs-3"><%= successMsg %></p>
                <% } %>

                <% if (errorMsg != null) { %>
                <p class="text-center text-danger fs-5"><%= errorMsg %></p>
                <% } %>

                <div class="card-body">
                    <form action="userChangePassword" method="post">
                        <div class="mb-3">
                            <label>Enter New Password</label>
                            <input type="text" name="newPassword" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label>Enter Old Password</label>
                            <input type="text" name="oldPassword" class="form-control" required>
                        </div>

                        <input type="hidden" value="<%= user.getId() %>" name="uid">

                        <button class="btn btn-success col-md-12">Change Password</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
