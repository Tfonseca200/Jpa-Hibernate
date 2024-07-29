package dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.thi.main.HibernateUtil;

public class DaoGeneric<E> {

	private EntityManager entityManager = HibernateUtil.getEntityManager();
	
	public void save(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.persist(entidade);
		transaction.commit();
	}
}
