package service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import dao.JogDAO;
import entity.Jogo;
import util.TransacionalCdi;

@ApplicationScoped
public class JogService implements Serializable, Service<Jogo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7790154446410608349L;
	
	@Inject
	private JogDAO jogoDAO;
	
	@Override
	@TransacionalCdi
	public void save(Jogo jogo) {
		jogoDAO.save(jogo);
	}

	@Override
	@TransacionalCdi
	public void update(Jogo jogo)  {
			jogoDAO.update(jogo);
	}

	@Override
	@TransacionalCdi
	public void remove(Jogo jogo) {
		jogoDAO.remove(jogo);
	}

	@Override
	public Jogo getByID(long jogoId)  {
			return jogoDAO.getByID(jogoId);
	}

	@Override
	public List<Jogo> getAll() {
			return jogoDAO.getAll();
	}
		
}

