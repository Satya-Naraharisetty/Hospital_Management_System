<%--
  Created by IntelliJ IDEA.
  User: siddu
  Date: 10/2/2024
  Time: 11:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.hms.DBConnection"%>
<%@page import="com.hms.dao.DoctorDao"%>
<%@page import="com.hms.entity.Doctor"%>
<%@page import="java.util.List"%>
<%
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);

    // Fetch success and error messages from the session
    String errorMsg = (String) session.getAttribute("errorMsg");
    String succMsg = (String) session.getAttribute("succMsg");
    session.removeAttribute("errorMsg");
    session.removeAttribute("succMsg");

    // Check if user is logged in
    Object userObj = session.getAttribute("userObj");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Appointment</title>
    <%@include file="Component/allcss.jsp"%>
    <style type="text/css">
        .paint-card {
            box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
        }

        .backImg {
            background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
            url("images/img5.jpg");
            height: 20vh;
            width: 100%;
            background-size: cover;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
<%@include file="Component/navbar.jsp"%>

<div class="container-fulid backImg p-5">
    <p class="text-center fs-2 text-white"></p>
</div>
<div class="container p-3">
    <div class="row">
        <div class="col-md-6 p-5">
            <img alt="" src="images/img6.jpg">
        </div>

        <div class="col-md-6">
            <div class="card paint-card">
                <div class="card-body">
                    <p class="text-center fs-3">User Appointment</p>

                    <% if (errorMsg != null) { %>
                    <p class="fs-4 text-center text-danger"><%= errorMsg %></p>
                    <% } %>
                    <% if (succMsg != null) { %>
                    <p class="fs-4 text-center text-success"><%= succMsg %></p>
                    <% } %>

                    <form class="row g-3" action="appAppointment" method="post">

                        <input type="hidden" name="userid" value="<%= userObj != null ? ((com.hms.entity.User)userObj).getId() : "" %>">

                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Full Name</label>
                            <input required type="text" class="form-control" name="fullname">
                        </div>

                        <div class="col-md-6">
                            <label>Gender</label>
                            <select class="form-control" name="gender" required>
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                            </select>
                        </div>

                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Age</label>
                            <input required type="number" class="form-control" name="age">
                        </div>

                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Appointment Date</label>
                            <input type="date" class="form-control" required name="appoint_date">
                        </div>

                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Email</label>
                            <input required type="email" class="form-control" name="email">
                        </div>

                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Phone No</label>
                            <input maxlength="10" required type="number" class="form-control" name="phno">
                        </div>

                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Diseases</label>
                            <input required type="text" class="form-control" name="diseases">
                        </div>

                        <div class="col-md-6">
                            <label for="inputPassword4" class="form-label">Doctor</label>
                            <select required class="form-control" name="doct">
                                <option value="">--select--</option>
                                <%
                                    DoctorDao dao = new DoctorDao(DBConnection.getDBConnection());
                                    List<Doctor> list = dao.getAllDoctor();
                                    for (Doctor d : list) {
                                %>
                                <option value="<%= d.getId() %>"><%= d.getFull_Name() %> (<%= d.getSpecialist() %>)</option>
                                <%
                                    }
                                %>
                            </select>
                        </div>

                        <div class="col-md-12">
                            <label>Full Address</label>
                            <textarea required name="address" class="form-control" rows="3"></textarea>
                        </div>

                        <% if (userObj == null) { %>
                        <a href="user_login.jsp" class="col-md-6 offset-md-3 btn btn-success">Submit</a>
                        <% } else { %>
                        <button class="col-md-6 offset-md-3 btn btn-success">Submit</button>
                        <% } %>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
<%@include file="Component/footer.jsp"%>

</body>
</html>
