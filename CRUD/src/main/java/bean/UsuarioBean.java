package bean;
import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Usuario;
import service.UsuService;

@ViewScoped
@Named
public class UsuarioBean implements Serializable {

	@Inject
	private UsuService service;

	protected Usuario entidade;

	protected Collection<Usuario> entidades;

	public UsuarioBean() {
	}
	
	@PostConstruct
	public void init() {
		entidade = newEntidade();
		entidades = getService().getAll();
	}

	public void remove(Usuario entidade) {
		getService().remove(entidade);
		limpar();
	}

	public Usuario getEntidade() {
		return entidade;
	}

	public void setEntidade(Usuario entidade) {
		this.entidade = entidade;
	}

	public Collection<Usuario> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Usuario> entidades) {
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

	protected Usuario newEntidade() {
		return new Usuario();
	}

	public UsuService getService() {
		return service;
	}

}

//@ManagedBean
//@SessionScoped
//public class UsuarioBean {
//	private List<Usuario> usuarios = new ArrayList<Usuario>();
//
//	private Usuario usuario;
//
//	private boolean edit;
//
//	private SalvarBD sbd;
//
//	private Usuario editUsuario;
//
//	public UsuarioBean() {
//		edit = false;
//		usuario = new Usuario();
//		sbd = new SalvarBD();
//		usuarios.addAll(sbd.pegarVarias(Usuario.class));
//	}
//
//	public List<Usuario> getUsuarios() {
//		return usuarios;
//	}
//
//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//	public void salvar() {
//		if (usuario.getId() == 0) {
//			sbd.salvar(usuario);
//			usuarios.add(usuario);
//			usuario = new Usuario();
//		} else {
//			usuarios.set(usuarios.indexOf(editUsuario), usuario);
//			sbd.set(usuario);
//			edit = false;
//			usuario = new Usuario();
//			editUsuario = null;
//		}
//	}
//
//	public void remove(Usuario Usuario) {
//		usuarios.remove(Usuario);
//		sbd.remover(Usuario);
//
//	}
//
//	public void editar(Usuario Usuario) {
//		this.editUsuario = Usuario;
//		this.usuario = Usuario.clone();
//		edit = true;
//	}
//
//	public void cancel() {
//		editUsuario = null;
//		edit = false;
//		usuario = new Usuario();
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
//	public void setUsuarios(ArrayList<Usuario> Usuarios) {
//		this.usuarios = Usuarios;
//	}
//
//}
