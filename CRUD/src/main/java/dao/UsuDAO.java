package dao;

import java.util.List;

import entity.Usuario;
import filtros.UsuFiltro;

public class UsuDAO extends DAO<Usuario> {
	
	public UsuDAO() {
		super(Usuario.class);
	}

	public List<Usuario> findBy(UsuFiltro filtro) {
		return null;
	}
	
}