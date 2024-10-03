<%--
  Created by IntelliJ IDEA.
  User: siddu
  Date: 10/2/2024
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List" %>
<%@page import="com.hms.*" %>
<%@ page import="com.hms.dao.SpecialistDao" %>
<%@ page import="com.hms.entity.Specialist" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <%@include file="../Component/allcss.jsp" %>
    <style>
        .paint-card {
            box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
        }
    </style>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container-fluid p-3">
    <div class="row">

        <div class="col-md-5 offset-md-4">
            <div class="card paint-card">
                <div class="card-body">
                    <p class="fs-3 text-center">Add Doctor</p>
                    <c:if test="${not empty errorMsg}">
                        <p class="fs-3 text-center text-danger">${errorMsg}</p>
                        <c:remove var="errorMsg" scope="session"/>
                    </c:if>
                    <c:if test="${not empty successMsg}">
                        <div class="fs-3 text-center text-success" role="alert">${successMsg}</div>
                        <c:remove var="succMsg" scope="session"/>
                    </c:if>
                    <form action="./addDoctor" method="post">
                        <div class="mb-3">
                            <label class="form-label">Full Name</label> <input type="text"
                                                                               required name="Full_Name"
                                                                               class="form-control">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">DOB</label> <input type="date"
                                                                         required name="DOB" class="form-control">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Qualification</label> <input required
                                                                                   name="Qualification" type="text"
                                                                                   class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Specialist</label> <select name="Speciality"
                                                                                 required class="form-control">
                            <option>--select--</option>

                            <%
                                SpecialistDao dao = null;
                                try {
                                    dao = new SpecialistDao(DBConnection.getDBConnection());
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                                List<Specialist> list = dao.getAllSpecialist();
                                for (Specialist s : list) {
                            %>
                            <option><%=s.getSpecialistName()%>
                            </option>
                            <%
                                }
                            %>


                        </select>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Email</label> <input type="text"
                                                                           required name="Email" class="form-control">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Mob No</label> <input type="text"
                                                                            required name="Mobile_No"
                                                                            class="form-control">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Password</label> <input required
                                                                              name="Password" type="password"
                                                                              class="form-control">
                        </div>

                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>