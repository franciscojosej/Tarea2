package listas;

import java.util.ArrayList;

public class Cliente {
  private String nombre;
  private String cedula;
  private String dir;
 
  
  
  
public Cliente(String nombre, String cedula, String dir) {
	super();
	this.nombre = nombre;
	this.cedula = cedula;
	this.dir = dir;

}

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getCedula() {
	return cedula;
}
public void setCedula(String cedula) {
	this.cedula = cedula;
}
public String getDir() {
	return dir;
}
public void setDir(String dir) {
	this.dir = dir;
}

  
  
}
