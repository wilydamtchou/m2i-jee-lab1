package com.m2i;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {
	public static String DB_CLIENTS = "dbClients";
	public static String DB_ACCOUNTS = "dbAccounts";
	public static String DB_TRANSACTIONS = "dbAccounts";

    /**
     * Default constructor. 
     */
    public ApplicationListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	
    	sce.getServletContext().setAttribute(Constants.DB_CLIENTS, new HashMap<Integer, Object>());
    	sce.getServletContext().setAttribute(Constants.DB_ACCOUNTS, new HashMap<Integer, List<Object>>());
    	sce.getServletContext().setAttribute(Constants.DB_TRANSACTIONS, new HashMap<Integer, List<Object>>());
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
