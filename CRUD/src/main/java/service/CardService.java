package service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import dao.CardDAO;
import entity.Carta;
import util.TransacionalCdi;

@ApplicationScoped
public class CardService implements Serializable, Service<Carta> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7930633216172781845L;
	
	@Inject
	private CardDAO cardDAO;
	
	@Override
	@TransacionalCdi
	public void save(Carta card) {
		cardDAO.save(card);
	}

	@Override
	@TransacionalCdi
	public void update(Carta card)  {
			cardDAO.update(card);
	}

	@Override
	@TransacionalCdi
	public void remove(Carta card) {
		cardDAO.remove(card);
	}

	@Override
	public Carta getByID(long cardId)  {
			return cardDAO.getByID(cardId);
	}

	/* (non-Javadoc)
	 * @see br.edu.ifpb.esperanca.daw2.services.Service#getAll()
	 */
	@Override
	public List<Carta> getAll() {
			return cardDAO.getAll();
	}
		
}

