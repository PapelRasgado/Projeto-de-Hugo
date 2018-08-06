import javax.persistence.*;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usu_seq_gen")
	@SequenceGenerator(name = "usu_seq_gen", sequenceName = "usu_id_seq")
	@Column(name = "id_usu")
	private int id;
	
	private String email;
	
	private String senha;
	
	private String nick;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Usuario(int id, String email, String senha, String nick) {
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
