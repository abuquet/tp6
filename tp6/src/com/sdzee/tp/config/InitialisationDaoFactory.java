package com.sdzee.tp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sdzee.tp.dao.DAOFactory;

public class InitialisationDaoFactory implements ServletContextListener{
	private static final String ATT_DAO_FACTORY = "daofactory";
	private DAOFactory daoFactory;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		// Récup du ServletContext lors du chargement de l'app
		ServletContext servletContext = event.getServletContext();
		//Instanciation de noter DAOFactory
		this.daoFactory = DAOFactory.getInstance();
		// Enregistrement dans un attribut ayant pour portée toute l'app
		servletContext.setAttribute(ATT_DAO_FACTORY, this.daoFactory);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// Rien à réaliser à la fermeture
	}
}
