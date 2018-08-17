package bean;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Carta;
import service.CardService;

@ViewScoped
@Named
public class CartaBean implements Serializable {

	@Inject
	private CardService service;

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
