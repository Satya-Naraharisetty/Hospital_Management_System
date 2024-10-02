<%--
  Created by IntelliJ IDEA.
  User: siddu
  Date: 10/2/2024
  Time: 11:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.hms.entity.User"%>
<%@page import="com.hms.entity.Doctor"%>
<%@page import="com.hms.dao.DoctorDao"%>
<%@page import="com.hms.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.hms.DBConnection"%>
<%@page import="com.hms.dao.AppointmentDao"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Appointment List</title>
    <%@include file="Component/allcss.jsp"%>
    <style type="text/css">
        .paint-card {
            box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
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
<%
    // Redirect to login page if the user is not logged in
    Object userObj = session.getAttribute("userObj");
    if (userObj == null) {
        response.sendRedirect("user_login.jsp");
        return;
    }

    User user = (User) userObj;
    AppointmentDao appointmentDao = new AppointmentDao(DBConnection.getDBConnection());
    DoctorDao doctorDao = new DoctorDao(DBConnection.getDBConnection());
    List<Appointment> appointmentList = appointmentDao.getAllAppointmentByLoginUser(user.getId());
%>

<%@include file="Component/navbar.jsp"%>

<div class="container-fulid backImg p-5">
    <p class="text-center fs-2 text-white"></p>
</div>
<div class="container p-3">
    <div class="row">
        <div class="col-md-9">
            <div class="card paint-card">
                <div class="card-body">
                    <p class="fs-4 fw-bold text-center text-success">Appointment List</p>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">Full Name</th>
                            <th scope="col">Gender</th>
                            <th scope="col">Age</th>
                            <th scope="col">Appoint Date</th>
                            <th scope="col">Diseases</th>
                            <th scope="col">Doctor Name</th>
                            <th scope="col">Status</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (Appointment appointment : appointmentList) {
                                Doctor doctor = doctorDao.getDoctorById(appointment.getDoctor_Id());
                        %>
                        <tr>
                            <th><%=appointment.getFull_Name()%></th>
                            <td><%=appointment.getGender()%></td>
                            <td><%=appointment.getAge()%></td>
                            <td><%=appointment.getAppoint_date()%></td>
                            <td><%=appointment.getDisease()%></td>
                            <td><%=doctor.getFull_Name()%></td>
                            <td>
                                <%
                                    if ("Pending".equals(appointment.getStatus())) {
                                %>
                                <a href="#" class="btn btn-sm btn-warning">Pending</a>
                                <%
                                } else {
                                %>
                                <%=appointment.getStatus()%>
                                <%
                                    }
                                %>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-md-3 p-3">
            <img alt="" src="img/doct.jpg">
        </div>
    </div>
</div>
</body>
</html>
