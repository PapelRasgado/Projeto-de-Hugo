package bean;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Carta;
import service.CardService;
import service.ConjuntoService;
import service.JogService;
import service.RaridadService;
import service.UsuService;

@ViewScoped
@Named
public class CartaBean implements Serializable {

	@Inject
	private CardService service;
	
	@Inject
	private JogService jogService;
	
	private Long jogoId;
	
	@Inject
	private RaridadService rarService;
	
	private Long raridadeId;
	
	@Inject
	private ConjuntoService conjService;
	
	private Long conjId;
	
	@Inject
	private UsuService usuService;
	
	private Long usuId;

	protected Carta entidade;

	protected Collection<Carta> entidades;

	public CartaBean() {
	}
	
	@PostConstruct
	public void init() {
		entidade = newEntidade();
		entidades = getService().getAll();
	}

	public void remove(Carta entidade) {
		getService().remove(entidade);
		limpar();
	}

	public Carta getEntidade() {
		return entidade;
	}

	public void setEntidade(Carta entidade) {
		this.entidade = entidade;
	}

	public Collection<Carta> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Carta> entidades) {
		this.entidades = entidades;
	}

	public void save() {
		entidade.setIdUsuarioVende(usuService.getByID(usuId));
		entidade.setJogo(jogService.getByID(jogoId));
		entidade.setRaridade(rarService.getByID(raridadeId));
		entidade.setConjunto(conjService.getByID(conjId));
		getService().save(entidade);
		limpar();
	}

	public void editar(Long id) {
		this.getEntidade().setId(id);
		save();
	}

	public void limpar() {
		entidades = getService().getAll();
		entidade = newEntidade();
	}

	protected Carta newEntidade() {
		return new Carta();
	}

	public CardService getService() {
		return service;
	}

	public Long getJogoId() {
		return jogoId;
	}

	public void setJogoId(Long jogoId) {
		this.jogoId = jogoId;
	}

	public Long getRaridadeId() {
		return raridadeId;
	}

	public void setRaridadeId(Long raridadeId) {
		this.raridadeId = raridadeId;
	}

	public Long getConjId() {
		return conjId;
	}

	public void setConjId(Long conjId) {
		this.conjId = conjId;
	}

	public JogService getJogService() {
		return jogService;
	}

	public RaridadService getRarService() {
		return rarService;
	}

	public ConjuntoService getConjService() {
		return conjService;
	}
	
	public Long getUsuId() {
		return usuId;
	}
	
	public void setUsuId(Long usuId) {
		this.usuId = usuId;
	}
	
	

}


//@ManagedBean
//@SessionScoped
//public class CartaBean {
//	private List<Carta> cartas = new ArrayList<Carta>();
//
//	private Carta carta;
//
//	private boolean edit;
//
//	private SalvarBD sbd;
//
//	private Carta editcarta;
//
//	public CartaBean() {
//		edit = false;
//		carta = new Carta();
//		sbd = new SalvarBD();
//		cartas.addAll(sbd.pegarVarias(Carta.class));
//	}
//
//	public List<Carta> getCartas() {
//		return cartas;
//	}
//
//	public Carta getcarta() {
//		return carta;
//	}
//
//	public void salvar() {
//		if (carta.getId() == 0) {
//			sbd.salvar(carta);
//			cartas.add(carta);
//			carta = new Carta();
//		} else {
//			cartas.set(cartas.indexOf(editcarta), carta);
//			sbd.set(carta);
//			edit = false;
//			carta = new Carta();
//			editcarta = null;
//		}
//	}
//
//	public void remove(Carta carta) {
//		cartas.remove(carta);
//		sbd.remover(carta);
//
//	}
//
//	public void editar(Carta carta) {
//		this.editcarta = carta;
//		this.carta = carta.clone();
//		edit = true;
//	}
//
//	public void cancel() {
//		editcarta = null;
//		edit = false;
//		carta = new Carta();
//	}
//
//	public boolean isEdit() {
//		return edit;
//	}
//
//	public void setEdit(boolean edit) {
//		this.edit = edit;
//	}
//
//	public void setcartas(ArrayList<Carta> cartas) {
//		this.cartas = cartas;
//	}
//
//}
