<%--
  Created by IntelliJ IDEA.
  User: siddu
  Date: 10/2/2024
  Time: 9:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.hms.entity.Appointment"%>
<%@page import="com.hms.DBConnection"%>
<%@page import="com.hms.dao.AppointmentDao"%>
<%@ page import="com.hms.DBConnection" %>
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

    .backImg {
      background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
      url("../images/img1.jpg");
      height: 20vh;
      width: 100%;
      background-size: cover;
      background-repeat: no-repeat;
    }
  </style>
  <%@include file="../Component/allcss.jsp"%>
</head>
<body>

<%
  Object doctObj = session.getAttribute("DoctorObj");
  if (doctObj == null) {
    response.sendRedirect("../doctor_login.jsp");
    return;
  }
%>

<%@include file="../Component/navbar.jsp"%>
<div class="container-fluid backImg p-5">
  <p class="text-center fs-2 text-white"></p>
</div>
<div class="container p-3">
  <div class="row">

    <div class="col-md-6 offset-md-3">
      <div class="card paint-card">
        <div class="card-body">
          <p class="text-center fs-4">Patient Comment</p>

          <%
            int id = Integer.parseInt(request.getParameter("id"));
            AppointmentDao dao = new AppointmentDao(DBConnection.getDBConnection());
            Appointment ap = dao.getAppointmentById(id);
          %>
          <form class="row" action="../updateStatus" method="post">
            <div class="col-md-6">
              <label>Patient Name</label>
              <input type="text" readonly value="<%=ap.getFullName()%>" class="form-control">
            </div>

            <div class="col-md-6">
              <label>Age</label>
              <input type="text" value="<%=ap.getAge()%>" readonly class="form-control">
            </div>

            <div class="col-md-6">
              <br>
              <label>Mob No</label>
              <input type="text" readonly value="<%=ap.getPhNo()%>" class="form-control">
            </div>

            <div class="col-md-6">
              <br>
              <label>Diseases</label>
              <input type="text" readonly value="<%=ap.getDiseases()%>" class="form-control">
            </div>

            <div class="col-md-12">
              <br>
              <label>Comment</label>
              <textarea required name="comm" class="form-control" rows="3"></textarea>
            </div>

            <input type="hidden" name="id" value="<%=ap.getId()%>">
            <input type="hidden" name="did" value="<%=ap.getDoctorId()%>">

            <button class="mt-3 btn btn-primary col-md-6 offset-md-3">Submit</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
