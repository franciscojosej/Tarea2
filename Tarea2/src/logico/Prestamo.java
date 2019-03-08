package logico;

import java.util.Date;

public class Prestamo {
	private Date fechaInicioPrestamo;
	private Date fechaDeEntrega;
	private Publicacion prestamo;
	private boolean status;
	private int prorroga;
	private String cedula;
	
	
	public Prestamo(Date fechaInicioPrestamo, Date fechaDeEntrega, Publicacion prestamo,
			String cedula) {
		super();
		this.fechaInicioPrestamo = fechaInicioPrestamo;
		this.fechaDeEntrega = fechaDeEntrega;
		this.prestamo = prestamo;
		this.status = true;
		this.prorroga = 0;
		this.cedula = cedula;
	}


	public Date getFechaInicioPrestamo() {
		return fechaInicioPrestamo;
	}


	public void setFechaInicioPrestamo(Date fechaInicioPrestamo) {
		this.fechaInicioPrestamo = fechaInicioPrestamo;
	}


	public Date getFechaDeEntrega() {
		return fechaDeEntrega;
	}


	public void setFechaDeEntrega(Date fechaDeEntrega) {
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
