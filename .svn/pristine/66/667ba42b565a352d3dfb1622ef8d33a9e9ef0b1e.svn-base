package tds.um.utils;

import java.util.logging.Level;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private final static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		try {

			/*
			 * Configuration configuration = new Configuration(); configuration.configure();
			 * ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
			 * .applySettings(configuration.getProperties()).build(); return
			 * configuration.buildSessionFactory(serviceRegistry);
			 */

			java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			return new Configuration().buildSessionFactory(registry);
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed: " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
