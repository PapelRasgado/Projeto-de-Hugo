
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=Raridade.class)
public class RaridadeConverter implements Converter{

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		int id = Integer.parseInt(arg2);
		// achar o conjunto
		Raridade raridade = null;
		RaridadeBean raridadeBean = arg0.getApplication().evaluateExpressionGet(arg0, "#{raridadeBean}", RaridadeBean.class);
		for (Raridade raridad : raridadeBean.getRaridades()) {
			if(raridad.getId() == id) {
				raridade = raridad;
			}
		}
		return raridade;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Raridade raridade = (Raridade) arg2;
		return Integer.toString(raridade.getId());
	}

}

