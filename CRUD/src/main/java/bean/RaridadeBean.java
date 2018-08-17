package bean;
import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Raridade;
import service.RaridadService;

@ViewScoped
@Named
public class RaridadeBean implements Serializable {

	@Inject
	private RaridadService service;

	protected Raridade entidade;

	protected Collection<Raridade> entidades;

	public RaridadeBean() {
	}
	
	@PostConstruct
	public void init() {
		entidade = newEntidade();
		entidades = getService().getAll();
	}

	public void remove(Raridade entidade) {
		getService().remove(entidade);
		limpar();
	}

	public Raridade getEntidade() {
		return entidade;
	}

	public void setEntidade(Raridade entidade) {
		this.entidade = entidade;
	}

	public Collection<Raridade> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Raridade> entidades) {
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

	protected Raridade newEntidade() {
		return new Raridade();
	}

	public RaridadService getService() {
		return service;
	}

}

//@ManagedBean
//@SessionScoped
//public class RaridadeBean {
//	private List<Raridade> raridades = new ArrayList<Raridade>();
//
//	private Raridade raridade;
//
//	private boolean edit;
//
//	private SalvarBD sbd;
//	
//	private Raridade editRaridade;
//
//	public RaridadeBean() {
//		edit = false;
//		raridade = new Raridade();
//		sbd = new SalvarBD();
//		raridades.addAll(sbd.pegarVarias(Raridade.class));
//	}
//
//	public List<Raridade> getRaridades() {
//		return raridades;
//	}
//
//	public Raridade getRaridade() {
//		return raridade;
//	}
//
//	public void salvar() {
//		if (raridade.getId() == 0) {
//			sbd.salvar(raridade);
//			raridades.add(raridade);
//			raridade = new Raridade();
//		} else {
//			raridades.set(raridades.indexOf(editRaridade), raridade);
//			sbd.set(raridade);
//			edit = false;
//			raridade = new Raridade();
//			editRaridade = null;
//		}
//	}
//
//	public void remove(Raridade raridade) {
//		raridades.remove(raridade);
//		sbd.remover(raridade);
//
//	}
//
//	public void editar(Raridade raridade) {
//		this.editRaridade = raridade;
//		this.raridade = raridade.clone();
//		edit = true;
//	}
//
//	public void cancel() {
//		editRaridade = null;
//		edit = false;
//		raridade = new Raridade();
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
//	public void setRaridades(ArrayList<Raridade> raridades) {
//		this.raridades = raridades;
//	}
//
//}
