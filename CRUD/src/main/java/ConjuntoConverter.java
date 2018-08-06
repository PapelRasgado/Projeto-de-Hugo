
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=Conjunto.class)
public class ConjuntoConverter implements Converter{

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		int id = Integer.parseInt(arg2);
		// achar o conjunto
		Conjunto conjunto = null;
		ConjuntoBean conjuntoBean = arg0.getApplication().evaluateExpressionGet(arg0, "#{conjuntoBean}", ConjuntoBean.class);
		for (Conjunto conjunt : conjuntoBean.getConjuntos()) {
			if(conjunt.getId() == id) {
				conjunto = conjunt;
			}
		}
		return conjunto;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Conjunto conjunto = (Conjunto) arg2;
		return Integer.toString(conjunto.getId());
	}

}

