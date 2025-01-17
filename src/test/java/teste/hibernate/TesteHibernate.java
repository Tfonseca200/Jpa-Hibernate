package teste.hibernate;

import java.util.List;

import org.junit.Test;

import br.com.thi.main.HibernateUtil;
import dao.DaoGeneric;
import model.TelefoneUser;
import model.UsuarioPessoa;

public class TesteHibernate {
	
	@Test
	public void testeHibernateUtil() {
		HibernateUtil.getEntityManager();
	}
	
	 
	public void testeDao() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa usuarioPessoa = new UsuarioPessoa();
		
		usuarioPessoa.setNome("Buddy");
		usuarioPessoa.setLogin("buddyl@gmail.com");
		usuarioPessoa.setSenha("uauauuuu");
		usuarioPessoa.setIdade(7);
		
		daoGeneric.save(usuarioPessoa);
	}
	
	
	
	
	// @Test
	public void testeBuscar () {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		UsuarioPessoa pessoa2 = new UsuarioPessoa();
		
		
		// pessoa = daoGeneric.pesquisar(1L, pessoa);
		System.out.println(pessoa);
		
		// pessoa2 = daoGeneric.pesquisar(2L,pessoa);
		System.out.println(pessoa2);
		
		
	}
	
	
	
	
	// @Test
	public void testeUpdate() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(1L, UsuarioPessoa.class);
		
		pessoa.setNome("Diego Fonseca Claudino");
		pessoa.setLogin("diego.gmail.com");
		pessoa.setSenha("Manchaverde1914");
		pessoa.setIdade(20);
		
		
		pessoa = daoGeneric.updateMerge(pessoa);
		
		System.out.println(pessoa);
	}
	
	
	
	// @Test
	public void testeDeletar() {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar(3L, UsuarioPessoa.class);
		
		System.out.println(pessoa);
		
		daoGeneric.deletarPorId(pessoa);
	}
	
	
	
	// @Test
	public void testeListarUsuario() {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> listarUsuarios = daoGeneric.listar(UsuarioPessoa.class);
		
	}
	
	
	
	
	
	
	// @Test
	public void testQueryList() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		
	List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery("FROM UsuarioPessoa")
			.getResultList();
	
	for (UsuarioPessoa listaPessoas : list) {
		System.out.println("aqui tá rolando o teste: " + listaPessoas.getNome());
		}
	}
	
	
	
	
	//	@Test
		public void testeQueryListaMaxPessoas() {
			DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
			
			List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery
					("FROM UsuarioPessoa ORDER BY id")
					.setMaxResults(2).getResultList();
	
			for (UsuarioPessoa listaPessoas : list) {
				System.out.println (listaPessoas);
				}
	}
		
	
		//@Test
		public void testeListaPorParametro() {
			DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
			List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery("FROM UsuarioPessoa WHERE nome = :nome and nome = :nome")
					.setParameter("nome", "Thiago Fonseca Claudino")
					.setParameter("nome", "buddy").getResultList();
			
			for (UsuarioPessoa listaPessoas : list) {
				System.out.println (listaPessoas);
				}
			
		}
		
		// @Test
		public void testeQuerySomarTodasIdade() {
			DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
			
			long somaIdade =  (Long) daoGeneric.getEntityManager().createQuery(" SELECT SUM(u.idade) FROM UsuarioPessoa u ")
					.getSingleResult();
			
			System.out.println("Soma de todas idades: " + somaIdade);
			
		}
		
		
		// @Test
		public void testeNameQuery() {
		
			DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
			
			List<UsuarioPessoa> list = daoGeneric.getEntityManager().createNamedQuery("listarNome.todos")
					.setParameter("nome", "buddy")
					.getResultList();
			
			for (UsuarioPessoa usuarioPessoa : list) {
				System.out.println(usuarioPessoa);
			}
		}
		
		
		@Test
		public void testeGravarTelefone() {
			
			DaoGeneric daoGeneric = new DaoGeneric();
			
			UsuarioPessoa pessoa = (UsuarioPessoa) daoGeneric.pesquisar(1L, UsuarioPessoa.class);
			
			TelefoneUser telefone = new TelefoneUser();
			
			telefone.setTipo("Celular");
			telefone.setNumero("5002-8922");
			telefone.setUsuario(pessoa);
			
			daoGeneric.save(telefone);
			
		}
}
