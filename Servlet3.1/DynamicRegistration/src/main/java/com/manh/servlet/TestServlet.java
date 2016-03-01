package com.manh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet
{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        // Test if dynamic registration of a servlet with init parameters is
        // done correctly.
        if (!"servletInitValue".equals(getServletConfig().getInitParameter(
                "servletInitName"))) {
            throw new ServletException("Missing servlet init param");
        }

        // Test if dynamic registration of a filter with init parameters is
        // done correctly.
        if (!"filterInitValue".equals(req.getAttribute("filterInitName"))) {
            throw new ServletException("Missing request attribute that was "
                    + "supposed to have been set by programmtically registered "
                    + "Filter");
        }

        // Test if dynamic registration of a ServletRequestListener is
        // done correctly.
        if (!"listenerAttributeValue".equals(req.getAttribute(
                "listenerAttributeName"))) {
            throw new ServletException("Missing request attribute that was "
                    + "supposed to have been set by programmtically registered "
                    + "ServletRequestListener");
        }

        res.getWriter().println("HELLO WORLD!\n");
    }
}
