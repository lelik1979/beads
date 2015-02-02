package com.beads.web.servlet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by alexey.dranchuk on 14/1/15.
 *
 */
@WebServlet(urlPatterns = "/test")
public class HttpsServlet extends HttpServlet {

    private DataSource dataSource;
    private static final String testSql = "select id from product order by id desc limit 1";

    @Override
    public void init() {
        try {
            dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/MySQLDS");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>I am running</h1>");
        checkDataSource(out);
    }

    private void checkDataSource(PrintWriter out)  {
        try (
                Connection connection = dataSource.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(testSql)
        ) {
            if (connection.isClosed())
                out.println("Connection already closed");
            out.println("Test query '" + testSql + "' was executed ");
        }
        catch (SQLException ex) {
            out.println("SQLException : ");
            ex.printStackTrace(out);
        }
    }
}
