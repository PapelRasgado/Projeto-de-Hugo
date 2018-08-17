package bean;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Conjunto;
import service.ConjuntoService;

@ViewScoped
@Named
public class ConjuntoBean implements Serializable {

	@Inject
	private ConjuntoService service;

	protected Conjunto entidade;

	protected Collection<Conjunto> entidades;

	public ConjuntoBean() {
	}
	
	@PostConstruct
	public void init() {
		entidade = newEntidade();
		entidades = getService().getAll();
	}

	public void remove(Conjunto entidade) {
		getService().remove(entidade);
		limpar();
	}

	public Conjunto getEntidade() {
		return entidade;
	}

	public void setEntidade(Conjunto entidade) {
		this.entidade = entidade;
	}

	public Collection<Conjunto> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Conjunto> entidades) {
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

	protected Conjunto newEntidade() {
		return new Conjunto();
	}

	public ConjuntoService getService() {
		return service;
	}

}

//@ManagedBean
//@SessionScoped
//public class ConjuntoBean {
//	private List<Conjunto> conjuntos = new ArrayList<Conjunto>();
//
//	private Conjunto conjunto;
//
//	private boolean edit;
//
//	private SalvarBD sbd;
//
//	private Conjunto editconjunto;
//
//	public ConjuntoBean() {
//		edit = false;
//		conjunto = new Conjunto();
//		sbd = new SalvarBD();
//		conjuntos.addAll(sbd.pegarVarias(Conjunto.class));
//	}
//
//	public List<Conjunto> getConjuntos() {
//		return conjuntos;
//	}
//
//	public Conjunto getconjunto() {
//		return conjunto;
//	}
//
//	public void salvar() {
//		if (conjunto.getId() == 0) {
//			sbd.salvar(conjunto);
//			conjuntos.add(conjunto);
//			conjunto = new Conjunto();
//		} else {
//			conjuntos.set(conjuntos.indexOf(editconjunto), conjunto);
//			sbd.set(conjunto);
//			edit = false;
//			conjunto = new Conjunto();
//			editconjunto = null;
//		}
//	}
//
//	public void remove(Conjunto conjunto) {
//		conjuntos.remove(conjunto);
//		sbd.remover(conjunto);
//
//	}
//
//	public void editar(Conjunto conjunto) {
//		this.editconjunto = conjunto;
//		this.conjunto = conjunto.clone();
//		edit = true;
//	}
//
//	public void cancel() {
//		editconjunto = null;
//		edit = false;
//		conjunto = new Conjunto();
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
//	public void setconjuntos(ArrayList<Conjunto> conjuntos) {
//		this.conjuntos = conjuntos;
//	}
//
//}
