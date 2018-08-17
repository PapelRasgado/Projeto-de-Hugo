package dao;

import java.util.List;

import entity.Jogo;
import filtros.JogFiltro;

public class JogDAO extends DAO<Jogo> {
	
	public JogDAO() {
		super(Jogo.class);
	}

	public List<Jogo> findBy(JogFiltro filtro) {
		return null;
	}
	
}