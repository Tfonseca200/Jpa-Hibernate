package teste.hibernate;

import org.junit.Test;

import br.com.thi.main.HibernateUtil;
import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {
	
	@Test
	public void testeHibernateUtil() {
		HibernateUtil.getEntityManager();
	}
	
	@Test
	public void testeDao() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa usuarioPessoa = new UsuarioPessoa();
		
		usuarioPessoa.setNome("Thiago Fonseca Claudino");
		usuarioPessoa.setLogin("thiago.gmail.com");
		usuarioPessoa.setSenha("chavepix");
		usuarioPessoa.setIdade(22);
		
		daoGeneric.save(usuarioPessoa);
	}
}
