package modelo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import excepciones.CamposVaciosException;
import excepciones.CodigoBarrasException;

public class Ofertas {
	
	private String id;
	private java.sql.Date fechaPublicacion;
	private String nombre;
	private String descripcion;
	private String detalle;
	private int salario;
	private boolean activa;
	
	
	
	
	
	public Ofertas(String id, String fechaPublicacion, String nombre, String descripcion, String detalle, String salario,
			String activa) throws NumberFormatException, CamposVaciosException, CodigoBarrasException, ParseException {
		super();
		this.setId(id);
		this.setFechaPublicacion(fechaPublicacion);
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setDetalle(detalle);
		this.setSalario(salario);
		this.setActiva(activa);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) throws CamposVaciosException, CodigoBarrasException,NumberFormatException {
		
		if (id.equals("")) {
			throw new CamposVaciosException("ID");
		}
		
		
		if (id.length()!=13) {
			throw new CodigoBarrasException();
		}else {
			String codigoBarras=id.substring(0,12);
			int DC =Integer.parseInt(Character.toString(id.charAt(12)));
			
			boolean impar=true;
			int suma=0;
			
			for (int x = 0; x < codigoBarras.length(); x++) {
				
				if (impar) {
					suma+=Integer.parseInt(Character.toString(codigoBarras.charAt(x)))*1;
					impar=false;
				}else {
					suma+=Integer.parseInt(Character.toString(codigoBarras.charAt(x)))*3;
					impar=true;
				}
				
				
			}
			
			int resto= suma%10;
			
			int dc=10-resto;
			
			if (dc==10) {
				dc=0;
			}
			
			if (DC==dc) {
				this.id = id;
			}else {
				throw new CodigoBarrasException();
			}
			
		}
		
		
		
	}
	public java.sql.Date getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(String fechaPublicacion) throws ParseException, CamposVaciosException {
		
		if (fechaPublicacion.equals("")) {
			throw new CamposVaciosException("FECHA DE PUBLICACION");
		}
		
		java.util.Date fechaUtil;
		SimpleDateFormat formateador=new SimpleDateFormat("yyyy-MM-dd");
		formateador.setLenient(false);
		fechaUtil=formateador.parse(fechaPublicacion);
		this.fechaPublicacion = new java.sql.Date(fechaUtil.getTime());
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) throws CamposVaciosException {
		
		if (nombre.equals("")) {
			throw new CamposVaciosException("NOMBRE");
		}
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) throws CamposVaciosException {
		if (descripcion.equals("")) {
			throw new CamposVaciosException("DESCRIPCION");
		}
		this.descripcion = descripcion;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) throws CamposVaciosException {
		if (detalle.equals("")) {
			throw new CamposVaciosException("DETALLE");
		}
		this.detalle = detalle;
	}
	public int getSalario() {
		return salario;
	}
	public void setSalario(String salario)throws NumberFormatException, CamposVaciosException {
		
		if (salario.equals("")) {
			throw new CamposVaciosException("SALARIO");
		}
		int salario2=Integer.parseInt(salario);
		
		this.salario = salario2;
	}
	public boolean isActiva() {
		return activa;
	}
	public void setActiva(String activa) throws CamposVaciosException {
		if (activa.equals("")) {
			throw new CamposVaciosException("ACTIVA");
		}
		boolean activa2=Boolean.parseBoolean(activa);
		this.activa = activa2;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ofertas other = (Ofertas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return id + "," + fechaPublicacion + "," + nombre + ","
				+ descripcion + "," + detalle + "," + salario + "," + activa;
	}
	
	
	
	

	

}
