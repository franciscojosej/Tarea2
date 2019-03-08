package logico;

import java.util.ArrayList;

import logico.Prestamo;

public class Cliente {
	private String  cedula;
	private String nombre;
	private String direccion;
	private String Telefono;
	private ArrayList<Prestamo>  misPrestamo;
	
	public Cliente(String cedula, String nombre, String direccion, String telefono) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.direccion = direccion;
		this.Telefono = telefono;
		this.misPrestamo = new ArrayList<Prestamo>();
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public ArrayList<Prestamo> getMisPrestamo() {
		return misPrestamo;
	}
	public void setMisPrestamo(ArrayList<Prestamo> misPrestamo) {
		this.misPrestamo = misPrestamo;
	}
	
	
	

}
