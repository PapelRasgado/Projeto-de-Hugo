import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CartaBean {
	private List<Carta> cartas = new ArrayList<Carta>();

	private Carta carta;

	private boolean edit;

	private SalvarBD sbd;

	private Carta editcarta;

	public CartaBean() {
		edit = false;
		carta = new Carta();
		sbd = new SalvarBD();
		cartas.addAll(sbd.pegarVarias(Carta.class));
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public Carta getcarta() {
		return carta;
	}

	public void salvar() {
		if (carta.getId() == 0) {
			sbd.salvar(carta);
			cartas.add(carta);
			carta = new Carta();
		} else {
			cartas.set(cartas.indexOf(editcarta), carta);
			sbd.set(carta);
			edit = false;
			carta = new Carta();
			editcarta = null;
		}
	}

	public void remove(Carta carta) {
		cartas.remove(carta);
		sbd.remover(carta);

	}

	public void editar(Carta carta) {
		this.editcarta = carta;
		this.carta = carta.clone();
		edit = true;
	}

	public void cancel() {
		editcarta = null;
		edit = false;
		carta = new Carta();
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public void setcartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

}
