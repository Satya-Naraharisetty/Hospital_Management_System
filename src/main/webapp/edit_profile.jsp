<%--
  Created by IntelliJ IDEA.
  User: siddu
  Date: 10/2/2024
  Time: 11:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <%@include file="Component/allcss.jsp"%>

    <style type="text/css">
        .paint-card {
            box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
        }
    </style>
</head>
<body>
<%@include file="Component/navbar.jsp"%>
<div class="container">
    <div class="row">
        <div class="col-md-4 offset-md-4">
            <div class="card">
                <p class="text-center fs-3">Change Password</p>
                <div class="card-body">
                    <form>
                        <div class="mb-3">
                            <label>Enter New Password</label> <input type="text"
                                                                     name="newPassword" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label>Enter Old Password</label> <input type="text"
                                                                     name="oldPassword" class="form-control" required>
                        </div>
                        <button class="btn btn-success col-md-12">Change
                            Password</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
