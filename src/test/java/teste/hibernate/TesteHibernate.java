package teste.hibernate;

import org.junit.Test;

import br.com.thi.main.HibernateUtil;

public class TesteHibernate {
	
	@Test
	public void testeHibernateUtil() {
		HibernateUtil.getEntityManager();
	}

}
