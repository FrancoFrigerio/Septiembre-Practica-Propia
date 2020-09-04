package ar.com.EducacionIT.dao.hibernate;

import org.hibernate.SessionFactory;

public abstract class HibernateBaseRepository {

	protected SessionFactory factory;
	
	public HibernateBaseRepository() {
		factory = HibernateUtils.getSessionFactory();
	}		
	
}
