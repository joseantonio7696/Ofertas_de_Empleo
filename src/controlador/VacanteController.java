package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import excepciones.CamposVaciosException;
import excepciones.CodigoBarrasException;
import modelo.Ofertas;

public class VacanteController {
	
	private List<Ofertas>listaOferta =new ArrayList<Ofertas>();
	
	public VacanteController() throws IOException, NumberFormatException, CamposVaciosException, CodigoBarrasException, ParseException {
		
		File file=new File("ofertas.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileReader fr=new FileReader("ofertas.txt");
		BufferedReader br=new BufferedReader(fr);
		
		String linea=" ";
		String [] datos=null;
		
		String id;
		 String fechaPublicacion;
		 String nombre;
		 String descripcion;
		 String detalle;
		 String salario;
		 String activa;
		 
		 while ((linea=br.readLine())!=null) {
			
			 datos=linea.split(",");
			 
			 id=datos[0];
			 fechaPublicacion=datos[1];
			 nombre=datos[2];
			 descripcion=datos[3];
			 detalle=datos[4];
			 salario=datos[5];
			 activa=datos[6];
			 
			 Ofertas oferta=new Ofertas(id, fechaPublicacion, nombre, descripcion, detalle, salario, activa);
			 
			 listaOferta.add(oferta);
			 
			 oferta=null;
			 
			 
		}
		 
		 br.close();br=null;
		 fr.close();fr=null;
		
	}

	public List<Ofertas> getListaOferta() {
		return listaOferta;
	}
	
	

}
