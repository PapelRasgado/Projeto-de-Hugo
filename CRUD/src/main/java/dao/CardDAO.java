package dao;

import java.util.List;

import entity.Carta;
import filtros.CardFiltro;

public class CardDAO extends DAO<Carta> {
	
	public CardDAO() {
		super(Carta.class);
	}

	public List<Carta> findBy(CardFiltro filtro) {
		return null;
	}
	
}
