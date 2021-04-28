package excepciones;

public class CamposVaciosException extends Exception {

	public CamposVaciosException(String campo) {
		super("EL "+campo+" NO PUEDE ESTAR VACIO");
	}

}
