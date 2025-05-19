package com.m2i;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProfileServlet", urlPatterns = {"/profile"})
public class ProfileServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Récupération de la session existante (sans en créer une nouvelle)
        HttpSession session = request.getSession(false);
        PrintWriter out = response.getWriter();

        if (session != null &&
            session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            String password = (String) session.getAttribute("password");

            out.println("<h1>Profil utilisateur</h1>");
            out.println("<p>Username : " + username + "</p>");
            out.println("<p>Password : " + password + "</p>");
        } else {
            // Si pas de session, renvoyer au login
            response.sendRedirect(request.getContextPath() + "/index.html");
        }
    }
}
