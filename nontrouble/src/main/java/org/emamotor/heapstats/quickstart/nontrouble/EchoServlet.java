package org.emamotor.heapstats.quickstart.nontrouble;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/echo")
public class EchoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LoggerFactory.getLogger(EchoServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        String message = request.getParameter("message");
        if (message == null || "".equals(message))
            message = "No Message...";

        LOGGER.info("Request message is: " + message);
        response.getWriter().println("Request message is: " + message);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        throw new UnsupportedOperationException("POST is not supported.");

    }

}
