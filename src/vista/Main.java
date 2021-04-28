package vista;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import controlador.VacanteController;
import excepciones.CamposVaciosException;
import excepciones.CodigoBarrasException;
import modelo.Ofertas;

public class Main {

	public static void main(String[] args) {
		
		
		
		 String id="8412345678905";
		 String fechaPublicacion="2020-12-30";
		 String nombre="Ingeniero";
		 String descripcion="Desarrollo de Aplicaciones en Java";
		 String detalle="Requerimientos Java y PHP";
		 String salario="2500";
		 String activa="false";
		 
		 try {
			Ofertas oferta=new Ofertas(id, fechaPublicacion, nombre, descripcion, detalle, salario, activa);
			
			//System.out.println(oferta);
			
		} catch (NumberFormatException | CamposVaciosException | CodigoBarrasException | ParseException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		 
		 VacanteController vacanteController=null;
		 List<Ofertas> listado=new ArrayList<Ofertas>();
		 
		 try {
			vacanteController=new VacanteController();
			
			listado=vacanteController.getListaOferta();
			
			for (Ofertas ofertas : listado) {
				System.out.println(ofertas);
			}
		} catch (NumberFormatException | IOException | CamposVaciosException | CodigoBarrasException
				| ParseException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}

	}

}
