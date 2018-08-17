package service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import dao.ConjuntDAO;
import entity.Conjunto;
import util.TransacionalCdi;

@ApplicationScoped
public class ConjuntoService implements Serializable, Service<Conjunto> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2243893113853036670L;
	
	@Inject
	private ConjuntDAO conjuntDAO;
	
	@Override
	@TransacionalCdi
	public void save(Conjunto conjunt) {
		conjuntDAO.save(conjunt);
	}

	@Override
	@TransacionalCdi
	public void update(Conjunto conjunt)  {
			conjuntDAO.update(conjunt);
	}

	@Override
	@TransacionalCdi
	public void remove(Conjunto conjunt) {
		conjuntDAO.remove(conjunt);
	}

	@Override
	public Conjunto getByID(long conjuntId)  {
			return conjuntDAO.getByID(conjuntId);
	}

	@Override
	public List<Conjunto> getAll() {
			return conjuntDAO.getAll();
	}
		
}


