<%--
  Created by IntelliJ IDEA.
  User: siddu
  Date: 10/2/2024
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.hms.entity.Doctor"%>
<%@page import="com.hms.DBConnection"%>
<%@page import="com.hms.dao.DoctorDao"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Doctor Dashboard</title>
    <style type="text/css">
        .paint-card {
            box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
        }
    </style>
    <%@include file="../Component/allcss.jsp"%>
</head>
<body>

<%
    // Check if the doctor is logged in, otherwise redirect to login page
    Doctor doctor = (Doctor) session.getAttribute("DoctorObj");
    if (doctor == null) {
        response.sendRedirect("../doctor_login.jsp");
        return;
    }

    // Get doctor and appointment data from DoctorDao
    DoctorDao doctorDao = new DoctorDao(DBConnection.getDBConnection());
    int totalDoctors = doctorDao.countDoctor();
    int totalAppointments = doctorDao.countAppointmentByDoctorId(doctor.getId());
%>

<%@include file="navbar.jsp"%>

<p class="text-center fs-3">Doctor Dashboard</p>

<div class="container p-5">
    <div class="row">
        <div class="col-md-4 offset-md-2">
            <div class="card paint-card">
                <div class="card-body text-center text-success">
                    <i class="fas fa-user-md fa-3x"></i><br>
                    <p class="fs-4 text-center">
                        Doctor <br><%= totalDoctors %>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card paint-card">
                <div class="card-body text-center text-success">
                    <i class="far fa-calendar-check fa-3x"></i><br>
                    <p class="fs-4 text-center">
                        Total Appointment <br>
                        <%= totalAppointments %>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
