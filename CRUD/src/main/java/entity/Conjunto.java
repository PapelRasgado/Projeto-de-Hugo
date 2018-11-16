package entity;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Conjunto implements Identificavel  {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conjunto_seq_gen")
	@SequenceGenerator(name = "conjunto_seq_gen", sequenceName = "conjunto_id_seq")
	@Column(name = "id_conjunto")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_jogo")
	private Jogo jogo;
	
	@OneToMany(mappedBy="conjunto")
	private Set<Carta> cartas;
	
	private String nome;
	
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Set<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(Set<Carta> cartas) {
		this.cartas = cartas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Conjunto clone() {
		Conjunto conjunt = new Conjunto(id, jogo, cartas, nome, descricao);
		return conjunt;
	}

	public Conjunto(Long id, Jogo jogo, Set<Carta> cartas, String nome, String descricao) {
		super();
		this.id = id;
		this.jogo = jogo;
		this.cartas = cartas;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Conjunto() {
		
	}

}
