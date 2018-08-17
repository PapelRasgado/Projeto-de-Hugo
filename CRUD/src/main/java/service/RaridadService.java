package service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import dao.RaridadDAO;
import entity.Raridade;
import util.TransacionalCdi;

@ApplicationScoped
public class RaridadService implements Serializable, Service<Raridade> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6664326866399002263L;
	
	@Inject
	private RaridadDAO raridadeDAO;
	
	@Override
	@TransacionalCdi
	public void save(Raridade raridade) {
		raridadeDAO.save(raridade);
	}

	@Override
	@TransacionalCdi
	public void update(Raridade raridade)  {
			raridadeDAO.update(raridade);
	}

	@Override
	@TransacionalCdi
	public void remove(Raridade raridade) {
		raridadeDAO.remove(raridade);
	}

	@Override
	public Raridade getByID(long raridadeId)  {
			return raridadeDAO.getByID(raridadeId);
	}

	@Override
	public List<Raridade> getAll() {
			return raridadeDAO.getAll();
	}
		
}


