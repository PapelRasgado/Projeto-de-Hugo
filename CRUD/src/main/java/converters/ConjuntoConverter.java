package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import dao.ConjuntDAO;
import entity.Conjunto;
import entity.Identificavel;


@FacesConverter(forClass=Conjunto.class)
public class ConjuntoConverter implements Converter {

	@Inject
	private ConjuntDAO conjuntoDAO;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		return conjuntoDAO.getByID(Long.parseLong(id));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object entidade) {
		return entidade.toString();
	}

	
	
}

