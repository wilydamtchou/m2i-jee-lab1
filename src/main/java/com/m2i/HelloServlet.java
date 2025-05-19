package com.m2i;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LocalDateTime date;
	public static int var = 1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Hello world ");
	}
	
	@Override
	public void init() throws ServletException {
	    // Code d'initialisation
	    System.out.println("Servlet initialisée !");
	    setDate(LocalDateTime.now());
	}
	
	@Override
	public void destroy() {
	    System.out.println("Servlet détruite !");
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}



}
