
package my;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Profile extends HttpServlet {

  
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           HttpSession hs=request.getSession(false); //give a session to a request if there exist a session , otherwise gives null.
           if(hs!=null)
           {
              String n= (String)hs.getAttribute("name");
              String u=(String)hs.getAttribute("username");
                String ph=(String)hs.getAttribute("phone");
                 String age=(String)hs.getAttribute("age");
                 out.println("<html><body>");
                 out.println("name: <b> "+n+"<b><br>");
                  out.println("username: <b> "+u+"<b><br>");
                   out.println("phone: <b> "+ph+"<b><br>");
                    out.println("age: <b> "+age+"<b><br><br>");
                    out.println("<a href='Logout'>Logout</a><br>");
                    out.println("</body></html>");
                    
           }
           else
           {
               response.sendRedirect("LoginError2.html");
           }
           
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
