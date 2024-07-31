package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

@Entity
@NamedQueries({
	
	@NamedQuery(name = "listar.todos", query = "SELECT u FROM UsuarioPessoa u"),
	@NamedQuery(name = "listarNome.todos", query = "SELECT u FROM UsuarioPessoa u WHERE u.nome = :nome")
})


public class UsuarioPessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String login;
	private String senha;
	private int idade;
	
	//relacionamento de n telefones para 1 usuário
	//pegando o atributo criado pro relacionameto com a entidade telefone
	
	@OneToMany(mappedBy = "usuario")
	private List<TelefoneUser> telefoneUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade ;
	}

	@Override
	public String toString() {
		return "UsuarioPessoa [id=" + id + ", nome=" + nome + ", login=" + login + ", senha=" + senha + ", idade="
				+ idade + "]";
	}
	

}
