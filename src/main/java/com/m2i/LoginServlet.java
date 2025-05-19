package com.m2i;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {
        // Récupération des paramètres du formulaire
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Création/récupération de la session
        HttpSession session = request.getSession(true);
        session.setAttribute("username", username);
        session.setAttribute("password", password);

        // Redirection vers la page profil
        response.sendRedirect(request.getContextPath() + "/profile");
    }
}