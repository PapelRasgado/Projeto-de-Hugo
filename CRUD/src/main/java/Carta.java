import javax.persistence.*;

@Entity
public class Carta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carta_seq_gen")
	@SequenceGenerator(name = "carta_seq_gen", sequenceName = "carta_id_seq")
	@Column(name = "id_carta")
	private int id;
	
	@Column(name = "id_usu_vende")
	private int idUsuarioVende;

	@Column(name = "id_usu_compra")
	private int idUsuarioCompra;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="id_conjunto")
	private Conjunto conjunto;
	
	@ManyToOne
	@JoinColumn(name="id_raridade")
	private Raridade raridade;
	
	@ManyToOne
	@JoinColumn(name="id_jogo")
	private Jogo jogo;
	
	private String imagem;
	
	private String descricao;
	
	private Integer ataque;
	
	private Integer defesa;
	
	private Integer custo;
	
	private Integer preco;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Conjunto getConjunto() {
		return conjunto;
	}
	
	public void setConjunto(Conjunto conjunto) {
		this.conjunto = conjunto;
	}
	
	public Raridade getRaridade() {
		return raridade;
	}
	
	public void setRaridade(Raridade raridade) {
		this.raridade = raridade;
	}
	
	public String getImagem() {
		return imagem;
	}
	
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getAtaque() {
		return ataque;
	}
	
	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}
	
	public Integer getDefesa() {
		return defesa;
	}
	
	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}
	
	public Integer getCusto() {
		return custo;
	}
	
	public void setCusto(Integer custo) {
		this.custo = custo;
	}
	
	public Integer getPreco() {
		return preco;
	}
	
	public void setPreco(Integer preco) {
		this.preco = preco;
	}
	
	public Carta() {
		
	}

	public int getIdUsuarioVende() {
		return idUsuarioVende;
	}

	public void setIdUsuarioVende(int idUsuarioVende) {
		this.idUsuarioVende = idUsuarioVende;
	}

	public int getIdUsuarioCompra() {
		return idUsuarioCompra;
	}

	public void setIdUsuarioCompra(int idUsuarioCompra) {
		this.idUsuarioCompra = idUsuarioCompra;
	}
	
	

	public Carta(int idUsuarioVende, int idUsuarioCompra, String nome, Conjunto conjunto, Raridade raridade,
			Jogo jogo, String imagem, String descricao, Integer ataque, Integer defesa, Integer custo, Integer preco) {
		super();
		this.idUsuarioVende = idUsuarioVende;
		this.idUsuarioCompra = idUsuarioCompra;
		this.nome = nome;
		this.conjunto = conjunto;
		this.raridade = raridade;
		this.jogo = jogo;
		this.imagem = imagem;
		this.descricao = descricao;
		this.ataque = ataque;
		this.defesa = defesa;
		this.custo = custo;
		this.preco = preco;
	}

	public Carta(String nome, Conjunto conjunto, Raridade raridade,Jogo jogo, String imagem, String descricao, Integer ataque, Integer defesa,
			Integer custo, Integer preco) {
		super();
		this.nome = nome;
		this.conjunto = conjunto;
		this.raridade = raridade;
		this.imagem = imagem;
		this.descricao = descricao;
		this.ataque = ataque;
		this.defesa = defesa;
		this.custo = custo;
		this.preco = preco;
	}
	
	public Carta clone() {
		Carta card = new Carta(idUsuarioVende, idUsuarioCompra, nome, conjunto, raridade, jogo, imagem, descricao, ataque, defesa, custo, preco);
		card.setId(id);
		return card;
	}

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
	
	
	

}
