package logico;

import java.util.Date;

public class Prestamo {
	private String fechaInicioPrestamo;
	private String fechaDeEntrega;
	private Publicacion prestamo;
	private boolean status;
	private int prorroga;
	private String cedula;
	
	
	public Prestamo(String fechaInicioPrestamo, String fechaDeEntrega, Publicacion prestamo,
			String cedula) {
		super();
		this.fechaInicioPrestamo = fechaInicioPrestamo;
		this.fechaDeEntrega = fechaDeEntrega;
		this.prestamo = prestamo;
		this.status = true;
		this.prorroga = 0;
		this.cedula = cedula;
	}
	



	public String getFechaInicioPrestamo() {
		return fechaInicioPrestamo;
	}




	public void setFechaInicioPrestamo(String fechaInicioPrestamo) {
		this.fechaInicioPrestamo = fechaInicioPrestamo;
	}




	public String getFechaDeEntrega() {
		return fechaDeEntrega;
	}




	public void setFechaDeEntrega(String fechaDeEntrega) {
		this.fechaDeEntrega = fechaDeEntrega;
	}




	public Publicacion getPrestamo() {
		return prestamo;
	}


	public void setPrestamo(Publicacion prestamo) {
		this.prestamo = prestamo;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public int getProrroga() {
		return prorroga;
	}


	public void setProrroga(int prorroga) {
		this.prorroga = prorroga;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	
	
	
	
	

}
