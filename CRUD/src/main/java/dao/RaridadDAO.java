package dao;

import java.util.List;

import entity.Raridade;
import filtros.RaridadFiltro;

public class RaridadDAO extends DAO<Raridade> {
	
	public RaridadDAO() {
		super(Raridade.class);
	}

	public List<Raridade> findBy(RaridadFiltro filtro) {
		return null;
	}
	
}