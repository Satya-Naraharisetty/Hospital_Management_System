<%--
  Created by IntelliJ IDEA.
  User: siddu
  Date: 10/2/2024
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.hms.entity.Specialist"%>
<%@page import="java.util.List"%>
<%@page import="com.hms.DBConnection"%>
<%@page import="com.hms.dao.SpecialistDao"%>
<%@ page import="com.hms.entity.Doctor" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <style type="text/css">
        .paint-card {
            box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
        }
    </style>
    <%@include file="../Component/allcss.jsp"%>
</head>
<body>

<%
    // Handle session object for Doctor
    Object doctorObj = session.getAttribute("DoctorObj");
    if (doctorObj == null) {
        response.sendRedirect("../doctor_login.jsp");
        return;
    }

    // Success and error messages
    String successMsg = (String) session.getAttribute("succMsg");
    session.removeAttribute("succMsg");

    String errorMsg = (String) session.getAttribute("errorMsg");
    session.removeAttribute("errorMsg");

    String succMsgd = (String) session.getAttribute("succMsgd");
    session.removeAttribute("succMsgd");

    String errorMsgd = (String) session.getAttribute("errorMsgd");
    session.removeAttribute("errorMsgd");
%>

<%@include file="navbar.jsp"%>

<div class="container p-4">
    <div class="row">
        <div class="col-md-4">
            <div class="card paint-card">
                <p class="text-center fs-3">Change Password</p>

                <% if (successMsg != null) { %>
                <p class="text-center text-success fs-3"><%= successMsg %></p>
                <% } %>

                <% if (errorMsg != null) { %>
                <p class="text-center text-danger fs-5"><%= errorMsg %></p>
                <% } %>

                <div class="card-body">
                    <form action="../doctChangePassword" method="post">
                        <div class="mb-3">
                            <label>Enter New Password</label>
                            <input type="text" name="newPassword" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label>Enter Old Password</label>
                            <input type="text" name="oldPassword" class="form-control" required>
                        </div>

                        <input type="hidden" value="<%= ((Doctor) doctorObj).getId() %>" name="uid">
                        <button class="btn btn-success col-md-12">Change Password</button>
                    </form>
                </div>
            </div>
        </div>

        <div class="col-md-5 offset-md-2">
            <div class="card paint-card">
                <p class="text-center fs-3">Edit Profile</p>

                <% if (succMsgd != null) { %>
                <p class="text-center text-success fs-3"><%= succMsgd %></p>
                <% } %>

                <% if (errorMsgd != null) { %>
                <p class="text-center text-danger fs-5"><%= errorMsgd %></p>
                <% } %>

                <div class="card-body">
                    <form action="../doctorUpdateProfile" method="post">
                        <div class="mb-3">
                            <label class="form-label">Full Name</label>
                            <input type="text" required name="fullname" class="form-control"
                                   value="<%= ((Doctor) doctorObj).getFull_Name() %>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">DOB</label>
                            <input type="date" required name="dob" class="form-control"
                                   value="<%= ((Doctor) doctorObj).getDob() %>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Qualification</label>
                            <input required name="qualification" type="text" class="form-control"
                                   value="<%= ((Doctor) doctorObj).getQualification() %>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Specialist</label>
                            <select name="Speciality" required class="form-control">
                                <option><%= ((Doctor) doctorObj).getSpecialist() %></option>

                                <%
                                    SpecialistDao dao = new SpecialistDao(DBConnection.getDBConnection());
                                    List<Specialist> list = dao.getAllSpecialist();
                                    for (Specialist s : list) {
                                %>
                                <option><%= s.getSpecialistName() %></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input type="text" readonly required name="Email" class="form-control"
                                   value="<%= ((Doctor) doctorObj).getEmail() %>">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Mob No</label>
                            <input type="text" required name="Mobile_No" class="form-control"
                                   value="<%= ((Doctor) doctorObj).getMobNo() %>">
                        </div>

                        <input type="hidden" name="id" value="<%= ((Doctor) doctorObj).getId() %>">
                        <button type="submit" class="btn btn-primary">Update</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
