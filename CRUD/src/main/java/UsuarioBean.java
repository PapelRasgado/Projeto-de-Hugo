import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UsuarioBean {
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	private Usuario usuario;

	private boolean edit;

	private SalvarBD sbd;

	private Usuario editUsuario;

	public UsuarioBean() {
		edit = false;
		usuario = new Usuario();
		sbd = new SalvarBD();
		usuarios.addAll(sbd.pegarVarias(Usuario.class));
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void salvar() {
		if (usuario.getId() == 0) {
			sbd.salvar(usuario);
			usuarios.add(usuario);
			usuario = new Usuario();
		} else {
			usuarios.set(usuarios.indexOf(editUsuario), usuario);
			sbd.set(usuario);
			edit = false;
			usuario = new Usuario();
			editUsuario = null;
		}
	}

	public void remove(Usuario Usuario) {
		usuarios.remove(Usuario);
		sbd.remover(Usuario);

	}

	public void editar(Usuario Usuario) {
		this.editUsuario = Usuario;
		this.usuario = Usuario.clone();
		edit = true;
	}

	public void cancel() {
		editUsuario = null;
		edit = false;
		usuario = new Usuario();
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public void setUsuarios(ArrayList<Usuario> Usuarios) {
		this.usuarios = Usuarios;
	}

}
