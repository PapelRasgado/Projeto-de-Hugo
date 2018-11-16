package entity;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Jogo implements Identificavel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogo_seq_gen")
	@SequenceGenerator(name = "jogo_seq_gen", sequenceName = "jogos_id_seq")
	@Column(name = "id_jogo")
	private Long id;
	
	private String nome;
	
	private String descricao;
	
	@OneToMany(mappedBy="jogo")
	private Set<Conjunto> conjuntos;
	
	@OneToMany(mappedBy="jogo")
	private Set<Raridade> raridades;
	
	@OneToMany(mappedBy="jogo")
	private Set<Carta> cartas;
	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Conjunto> getConjuntos() {
		return conjuntos;
	}

	public void setConjuntos(Set<Conjunto> conjuntos) {
		this.conjuntos = conjuntos;
	}

	public Set<Raridade> getRaridades() {
		return raridades;
	}

	public void setRaridades(Set<Raridade> raridades) {
		this.raridades = raridades;
	}

	public Set<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(Set<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public Jogo clone() {
		Jogo jogo = new Jogo(id, nome, descricao, conjuntos, raridades, cartas);
		return jogo;
	}

	public Jogo(Long id, String nome, String descricao, Set<Conjunto> conjuntos, Set<Raridade> raridades,
			Set<Carta> cartas) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.conjuntos = conjuntos;
		this.raridades = raridades;
		this.cartas = cartas;
	}
	
	public Jogo() {
		
	}

}
