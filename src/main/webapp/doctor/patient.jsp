<%--
  Created by IntelliJ IDEA.
  User: siddu
  Date: 10/2/2024
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.hms.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.hms.DBConnection"%>
<%@page import="com.hms.dao.AppointmentDao"%>
<%@page import="com.hms.entity.Doctor"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <%@include file="../Component/allcss.jsp"%>
    <style>
        .paint-card {
            box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
        }
    </style>
</head>
<body>

<%
    // Handle session for Doctor
    Doctor doctor = (Doctor) session.getAttribute("DoctorObj");
    if (doctor == null) {
        response.sendRedirect("../doctor_login.jsp");
        return;
    }

    // Handle success and error messages
    String errorMsg = (String) session.getAttribute("errorMsg");
    session.removeAttribute("errorMsg");

    String successMsg = (String) session.getAttribute("successMsg");
    session.removeAttribute("successMsg");
%>

<%@include file="navbar.jsp"%>

<div class="container p-3">
    <div class="row">
        <div class="col-md-12">
            <div class="card paint-card">
                <div class="card-body">
                    <p class="fs-3 text-center">Patient Details</p>

                    <% if (errorMsg != null) { %>
                    <p class="fs-4 text-center text-danger"><%= errorMsg %></p>
                    <% } %>

                    <% if (successMsg != null) { %>
                    <p class="fs-4 text-center text-success"><%= successMsg %></p>
                    <% } %>

                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">Full Name</th>
                            <th scope="col">Gender</th>
                            <th scope="col">Age</th>
                            <th scope="col">Appointment Date</th>
                            <th scope="col">Email</th>
                            <th scope="col">Mob No</th>
                            <th scope="col">Diseases</th>
                            <th scope="col">Status</th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            // Fetch appointments by Doctor ID
                            AppointmentDao appointmentDao = new AppointmentDao(DBConnection.getDBConnection());
                            List<Appointment> appointmentList = appointmentDao.getAllAppointmentByDoctorLogin(doctor.getId());

                            for (Appointment appointment : appointmentList) {
                        %>
                        <tr>
                            <th><%= appointment.getFullName() %></th>
                            <td><%= appointment.getGender() %></td>
                            <td><%= appointment.getAge() %></td>
                            <td><%= appointment.getAppointDate() %></td>
                            <td><%= appointment.getEmail() %></td>
                            <td><%= appointment.getPhNo() %></td>
                            <td><%= appointment.getDiseases() %></td>
                            <td><%= appointment.getStatus() %></td>
                            <td>
                                <%
                                    if ("Pending".equals(appointment.getStatus())) {
                                %>
                                <a href="comment.jsp?id=<%= appointment.getId() %>" class="btn btn-success btn-sm">Comment</a>
                                <%
                                } else {
                                %>
                                <a href="#" class="btn btn-success btn-sm disabled">Comment</a>
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
    </div>
</div>
</body>
</html>
