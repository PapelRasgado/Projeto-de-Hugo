import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="jogoBean")
@SessionScoped
public class JogoBean {

	private List<Jogo> jogos = new ArrayList<Jogo>();

	private SalvarBD sbd;

	private Jogo jogo;
	
	private Jogo editJogo;

	private boolean edit;
	
	private String teste;

	public JogoBean() {
		edit = false;
		jogo = new Jogo();
		sbd = new SalvarBD();
		jogos.addAll(sbd.pegarVarias(Jogo.class));
		
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void salvar() {
		
		if (jogo.getId() == 0) {
			sbd.salvar(jogo);
			jogos.add(jogo);
			jogo = new Jogo();
		} else {
			jogos.set(jogos.indexOf(editJogo), jogo);
			sbd.set(jogo);
			edit = false;
			jogo = new Jogo();
			editJogo = null;
		}
	}

	public void remove(Jogo jogo) {
		jogos.remove(jogo);
		sbd.remover(jogo);

	}

	public void editar(Jogo jogo) {
		this.editJogo = jogo;
		this.jogo = jogo.clone();
		edit = true;
	}

	public void cancel() {
		editJogo = null;
		edit = false;
		jogo = new Jogo();
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public void setJogos(ArrayList<Jogo> jogos) {
		this.jogos = jogos;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
	
	public String getTeste() {
		return teste;
	}
	
	public void setTeste(String teste) {
		this.teste = teste;
	}

}
