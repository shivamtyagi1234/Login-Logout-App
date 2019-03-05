
package my;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
             String e=request.getParameter("email");
              String n=request.getParameter("name");
               String ph=request.getParameter("phone");
                String age=request.getParameter("age");
                 String p=request.getParameter("password");
                 try{
                  Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shivam","shivam");
          Statement st=c.createStatement();
           System.out.println("hello");
          st.executeUpdate("insert into user_info values('"+e+"','"+n+"','"+ph+"','"+age+"','"+p+"')");
          
             System.out.println("hello");
             HttpSession hs=request.getSession();
             hs.setAttribute("username",e);
             hs.setAttribute("name",n);
             hs.setAttribute("phone",ph);
             hs.setAttribute("age",age);
            // hs.setAttribute("password",p);
             response.sendRedirect("Profile");
           }
          catch(java.sql.SQLIntegrityConstraintViolationException ex){
			response.sendRedirect("LoginError.html");
          }
         catch(Exception ex)
              {
               response.sendRedirect("LoginError2.html");
              }

        }
    }
}
