import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RaridadeBean {
	private List<Raridade> raridades = new ArrayList<Raridade>();

	private Raridade raridade;

	private boolean edit;

	private SalvarBD sbd;
	
	private Raridade editRaridade;

	public RaridadeBean() {
		edit = false;
		raridade = new Raridade();
		sbd = new SalvarBD();
		raridades.addAll(sbd.pegarVarias(Raridade.class));
	}

	public List<Raridade> getRaridades() {
		return raridades;
	}

	public Raridade getRaridade() {
		return raridade;
	}

	public void salvar() {
		if (raridade.getId() == 0) {
			sbd.salvar(raridade);
			raridades.add(raridade);
			raridade = new Raridade();
		} else {
			raridades.set(raridades.indexOf(editRaridade), raridade);
			sbd.set(raridade);
			edit = false;
			raridade = new Raridade();
			editRaridade = null;
		}
	}

	public void remove(Raridade raridade) {
		raridades.remove(raridade);
		sbd.remover(raridade);

	}

	public void editar(Raridade raridade) {
		this.editRaridade = raridade;
		this.raridade = raridade.clone();
		edit = true;
	}

	public void cancel() {
		editRaridade = null;
		edit = false;
		raridade = new Raridade();
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public void setRaridades(ArrayList<Raridade> raridades) {
		this.raridades = raridades;
	}

}
