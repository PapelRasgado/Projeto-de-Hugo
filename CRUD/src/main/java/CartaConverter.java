
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=Carta.class)
public class CartaConverter implements Converter{

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		int id = Integer.parseInt(arg2);
		// achar o conjunto
		Carta carta = null;
		CartaBean cartaBean = arg0.getApplication().evaluateExpressionGet(arg0, "#{cartaBean}", CartaBean.class);
		for (Carta cart : cartaBean.getCartas()) {
			if(cart.getId() == id) {
				carta = cart;
			}
		}
		return carta;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Carta carta = (Carta) arg2;
		return Integer.toString(carta.getId());
	}

}

