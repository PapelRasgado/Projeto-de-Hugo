
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=Jogo.class)
public class JogoConverter implements Converter{

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		int id = Integer.parseInt(arg2);
		// achar o jogo
		Jogo jogo = null;
		JogoBean jogoBean = arg0.getApplication().evaluateExpressionGet(arg0, "#{jogoBean}", JogoBean.class);
		for (Jogo jog : jogoBean.getJogos()) {
			if(jog.getId() == id) {
				jogo = jog;
			}
		}
		return jogo;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Jogo jogo = (Jogo) arg2;
		return Integer.toString(jogo.getId());
	}

}
