import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ConjuntoBean {
	private List<Conjunto> conjuntos = new ArrayList<Conjunto>();

	private Conjunto conjunto;

	private boolean edit;

	private SalvarBD sbd;

	private Conjunto editconjunto;

	public ConjuntoBean() {
		edit = false;
		conjunto = new Conjunto();
		sbd = new SalvarBD();
		conjuntos.addAll(sbd.pegarVarias(Conjunto.class));
	}

	public List<Conjunto> getConjuntos() {
		return conjuntos;
	}

	public Conjunto getconjunto() {
		return conjunto;
	}

	public void salvar() {
		if (conjunto.getId() == 0) {
			sbd.salvar(conjunto);
			conjuntos.add(conjunto);
			conjunto = new Conjunto();
		} else {
			conjuntos.set(conjuntos.indexOf(editconjunto), conjunto);
			sbd.set(conjunto);
			edit = false;
			conjunto = new Conjunto();
			editconjunto = null;
		}
	}

	public void remove(Conjunto conjunto) {
		conjuntos.remove(conjunto);
		sbd.remover(conjunto);

	}

	public void editar(Conjunto conjunto) {
		this.editconjunto = conjunto;
		this.conjunto = conjunto.clone();
		edit = true;
	}

	public void cancel() {
		editconjunto = null;
		edit = false;
		conjunto = new Conjunto();
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public void setconjuntos(ArrayList<Conjunto> conjuntos) {
		this.conjuntos = conjuntos;
	}

}
