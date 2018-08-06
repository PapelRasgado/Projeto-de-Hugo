import java.util.Set;

import javax.persistence.*;

@Entity
public class Raridade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rar_seq_gen")
	@SequenceGenerator(name = "rar_seq_gen", sequenceName = "rar_id_seq")
	@Column(name = "id_raridade")
	private int id;

	@ManyToOne
	@JoinColumn(name="id_jogo")
	private Jogo jogo;

	private String nome;
	
	@OneToMany(mappedBy="raridade")
	private Set<Carta> cartas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Set<Carta> getCartas() {
		return cartas;
	}
	
	public void setCartas(Set<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public Raridade() {

	}

	public Raridade(int id, Jogo jogo, String nome, Set<Carta> cartas) {
		super();
		this.id = id;
		this.jogo = jogo;
		this.nome = nome;
		this.cartas = cartas;
	}
	
	public Raridade clone() {
		Raridade rar = new Raridade(id, jogo, nome, cartas);
		return rar;
	}

}
