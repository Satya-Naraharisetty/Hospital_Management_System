<%--
  Created by IntelliJ IDEA.
  User: siddu
  Date: 10/2/2024
  Time: 6:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.hms.dao.*"%>
<%@page import="com.hms.entity.*"%>
<%@page import="java.util.List"%>
<%@page import="com.hms.DBConnection"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<%@include file="navbar.jsp"%>
<div class="container-fluid p-3">
    <div class="row">


        <div class="col-md-12">
            <div class="card paint-card">
                <div class="card-body">
                    <p class="fs-3 text-center">Doctor Details</p>
                    <c:if test="${not empty errorMsg}">
                        <p class="fs-3 text-center text-danger">${errorMsg}</p>
                        <c:remove var="errorMsg" scope="session" />
                    </c:if>
                    <c:if test="${not empty successMsg}">
                        <div class="fs-3 text-center text-success" role="alert">${successMsg}</div>
                        <c:remove var="successMsg" scope="session" />
                    </c:if>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">Full Name</th>
                            <th scope="col">DOB</th>
                            <th scope="col">Qualification</th>
                            <th scope="col">Specialist</th>
                            <th scope="col">Email</th>
                            <th scope="col">Mob No</th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            DoctorDao dao2 = new DoctorDao(DBConnection.getDBConnection());
                            List<Doctor> list2 = dao2.getAllDoctor();
                            for (Doctor d : list2) {
                        %>
                        <tr>
                            <td><%=d.getFull_Name()%></td>
                            <td><%=d.getDob()%></td>
                            <td><%=d.getQualification()%></td>
                            <td><%=d.getSpecialist()%></td>
                            <td><%=d.getEmail()%></td>
                            <td><%=d.getMobNo()%></td>
                            <td><a href="edit_doctor.jsp?id=<%=d.getId()%>"
                                   class="btn btn-sm btn-primary">Edit</a>

                                <a
                                        href="../deleteDoctor?id=<%=d.getId()%>"
                                        class="btn btn-sm btn-danger">Delete</a></td>
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