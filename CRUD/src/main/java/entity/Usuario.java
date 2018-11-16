package entity;
import javax.persistence.*;

@Entity
public class Usuario implements Identificavel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usu_seq_gen")
	@SequenceGenerator(name = "usu_seq_gen", sequenceName = "usu_id_seq")
	@Column(name = "id_usu")
	private Long id;
	
	private String email;
	
	private byte[] senha;
	
	private String nick;
	
	private String grupo;

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

	public byte[] getSenha() {
		return senha;
	}

	public void setSenha(byte[] senha) {
		this.senha = senha;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getGrupo() {
		return grupo;
	}
	
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Usuario(Long id, String email, byte[] senha, String nick, String grupo) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nick = nick;
		this.grupo = grupo;
	}
	
	public Usuario() {
		
	}
	
	public Usuario clone() {
		return new Usuario(id, email, senha, nick, grupo);
	}
	
}
