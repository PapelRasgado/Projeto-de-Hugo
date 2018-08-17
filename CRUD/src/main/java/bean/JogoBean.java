package bean;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Jogo;
import service.JogService;

@ViewScoped
@Named
public class JogoBean implements Serializable {

	@Inject
	private JogService service;

	protected Jogo entidade;

	protected Collection<Jogo> entidades;

	public JogoBean() {
	}
	
	@PostConstruct
	public void init() {
		entidade = newEntidade();
		entidades = getService().getAll();
	}

	public void remove(Jogo entidade) {
		getService().remove(entidade);
		limpar();
	}

	public Jogo getEntidade() {
		return entidade;
	}

	public void setEntidade(Jogo entidade) {
		this.entidade = entidade;
	}

	public Collection<Jogo> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Jogo> entidades) {
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

	protected Jogo newEntidade() {
		return new Jogo();
	}

	public JogService getService() {
		return service;
	}

}
//@ManagedBean(name="jogoBean")
//@SessionScoped
//public class JogoBean {
//
//	private List<Jogo> jogos = new ArrayList<Jogo>();
//
//	private SalvarBD sbd;
//
//	private Jogo jogo;
//	
//	private Jogo editJogo;
//
//	private boolean edit;
//	
//	private String teste;
//
//	public JogoBean() {
//		edit = false;
//		jogo = new Jogo();
//		sbd = new SalvarBD();
//		jogos.addAll(sbd.pegarVarias(Jogo.class));
//		
//	}
//
//	public List<Jogo> getJogos() {
//		return jogos;
//	}
//
//	public Jogo getJogo() {
//		return jogo;
//	}
//
//	public void salvar() {
//		
//		if (jogo.getId() == 0) {
//			sbd.salvar(jogo);
//			jogos.add(jogo);
//			jogo = new Jogo();
//		} else {
//			jogos.set(jogos.indexOf(editJogo), jogo);
//			sbd.set(jogo);
//			edit = false;
//			jogo = new Jogo();
//			editJogo = null;
//		}
//	}
//
//	public void remove(Jogo jogo) {
//		jogos.remove(jogo);
//		sbd.remover(jogo);
//
//	}
//
//	public void editar(Jogo jogo) {
//		this.editJogo = jogo;
//		this.jogo = jogo.clone();
//		edit = true;
//	}
//
//	public void cancel() {
//		editJogo = null;
//		edit = false;
//		jogo = new Jogo();
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
//	public void setJogos(ArrayList<Jogo> jogos) {
//		this.jogos = jogos;
//	}
//
//	public void setJogo(Jogo jogo) {
//		this.jogo = jogo;
//	}
//	
//	public String getTeste() {
//		return teste;
//	}
//	
//	public void setTeste(String teste) {
//		this.teste = teste;
//	}
//
//}
