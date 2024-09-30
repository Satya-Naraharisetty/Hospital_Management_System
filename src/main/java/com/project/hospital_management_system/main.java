package com.project.hospital_management_system;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/hello-servlet")
public class main extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    public void destroy() {
    }
}