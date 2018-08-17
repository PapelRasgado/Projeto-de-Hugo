package entity;
import javax.persistence.*;

import bean.Identificavel;

@Entity
public class Usuario implements Identificavel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usu_seq_gen")
	@SequenceGenerator(name = "usu_seq_gen", sequenceName = "usu_id_seq")
	@Column(name = "id_usu")
	private Long id;
	
	private String email;
	
	private String senha;
	
	private String nick;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Usuario(Long id, String email, String senha, String nick) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nick = nick;
	}
	
	public Usuario() {
		
	}
	
	public Usuario clone() {
		return new Usuario(id, email, senha, nick);
	}
	
}
