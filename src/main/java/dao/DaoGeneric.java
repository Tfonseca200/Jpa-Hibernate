package dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.thi.main.HibernateUtil;
import model.UsuarioPessoa;

public class DaoGeneric<E> {

	private EntityManager entityManager = HibernateUtil.getEntityManager();
	
	public void save(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.persist(entidade);
		transaction.commit();
	}
	
	public E updateMerge(E entidade) { //salvar ou atualizar
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		E entidadeSalva = entityManager.merge(entidade);
		transaction.commit();
		
		return entidadeSalva;
	}
	
	
	  public E pesquisar(Object id, Class<E> classe) {
	        E e = (E) entityManager.find(classe, id);
	        return e;
	    }
	  
	  public void deletarPorId(E entidade) {
		  
		  Object id = HibernateUtil.getPrimaryKey(entidade);
		  
		  EntityTransaction transaction = entityManager.getTransaction();
		  transaction.begin();
		  
		  entityManager.createNativeQuery("DELETE FROM " + entidade.getClass().getSimpleName()
				  + " WHERE ID = " + id).executeUpdate(); //faz delete
		  
		  transaction.commit();
		  
	  }
	  
	  public List<E> listar(Class<E> entidade) {
		  EntityTransaction transaction = entityManager.getTransaction();
		  transaction.begin();
		  
		  List<E> lista = entityManager.createQuery("FROM " + entidade.getName()).getResultList();
		  
		  transaction.commit();
		  
		  return lista;
	  }
	  
	  public EntityManager getEntityManager() {
		  return entityManager;
	  }
}
