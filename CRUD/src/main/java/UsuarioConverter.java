import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=Usuario.class)
public class UsuarioConverter implements Converter {

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		int id = Integer.parseInt(arg2);
		// achar o conjunto
		Usuario usuario = null;
		UsuarioBean usuarioBean = arg0.getApplication().evaluateExpressionGet(arg0, "#{usuarioBean}", UsuarioBean.class);
		for (Usuario usuari : usuarioBean.getUsuarios()) {
			if(usuari.getId() == id) {
				usuario = usuari;
			}
		}
		return usuario;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Raridade usuario = (Raridade) arg2;
		return Integer.toString(usuario.getId());
	}
	
}
