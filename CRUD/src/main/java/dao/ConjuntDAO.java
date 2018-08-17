package dao;

import java.util.List;

import entity.Conjunto;
import filtros.ConjuntFiltro;

public class ConjuntDAO extends DAO<Conjunto> {
	
	public ConjuntDAO() {
		super(Conjunto.class);
	}

	public List<Conjunto> findBy(ConjuntFiltro filtro) {
		return null;
	}
	
}
