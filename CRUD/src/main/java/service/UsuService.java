package service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import dao.UsuDAO;
import entity.Usuario;
import util.TransacionalCdi;

public class UsuService implements Serializable, Service<Usuario> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6209874963823981781L;
	
	
	@Inject
	private UsuDAO raridadeDAO;
	
	@Override
	@TransacionalCdi
	public void save(Usuario raridade) {
		raridadeDAO.save(raridade);
	}

	@Override
	@TransacionalCdi
	public void update(Usuario raridade)  {
			raridadeDAO.update(raridade);
	}

	@Override
	@TransacionalCdi
	public void remove(Usuario raridade) {
		raridadeDAO.remove(raridade);
	}

	@Override
	public Usuario getByID(long raridadeId)  {
			return raridadeDAO.getByID(raridadeId);
	}

	@Override
	public List<Usuario> getAll() {
			return raridadeDAO.getAll();
	}
		
}


