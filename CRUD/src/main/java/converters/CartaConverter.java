package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import dao.CardDAO;
import entity.Carta;
import entity.Identificavel;

@FacesConverter(forClass=Carta.class)
public class CartaConverter implements Converter{

	@Inject
	private CardDAO cardDAO;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		return cardDAO.getByID(Long.parseLong(id));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object entidade) {
		return ((Identificavel)entidade).getId().toString();
	}

	
	
}

