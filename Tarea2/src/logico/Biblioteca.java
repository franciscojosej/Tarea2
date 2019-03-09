package logico;

import java.util.ArrayList;
import java.util.Date;

import logico.Articulo;
import logico.Cliente;
import logico.Libro;
import logico.Prestamo;
import logico.Publicacion;
import logico.Revista;

public class Biblioteca {
	private ArrayList<Publicacion> misPublicaciones;
	private ArrayList<Prestamo> misPrestamo;
	private ArrayList<Cliente>misClientes;
	private static Biblioteca biblio=null;
	
	
	public Biblioteca() {
		super();
		this.misPublicaciones = new ArrayList<>();
		this.misPrestamo = new ArrayList<>();
		this.misClientes = new ArrayList<>();
	}


	public ArrayList<Publicacion> getMisPublicaciones() {
		return misPublicaciones;
	}


	public void setMisPublicaciones(ArrayList<Publicacion> misPublicaciones) {
		this.misPublicaciones = misPublicaciones;
	}


	public ArrayList<Prestamo> getMisPrestamo() {
		return misPrestamo;
	}


	public void setMisPrestamo(ArrayList<Prestamo> misPrestamo) {
		this.misPrestamo = misPrestamo;
	}


	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}


	public void setMisClientes(Cliente nuevoCliente) {
		this.misClientes.add(nuevoCliente);
	}




	public static Biblioteca getInstance() {
		if(biblio==null) {
			Biblioteca.biblio = new Biblioteca();
		}
		 return  biblio;
	}
	
	//incertar un libro
	
	public void incertarLibro(Libro nuevoLibro) {
		misPublicaciones.add(nuevoLibro);
		
	}
	//Registro general de las  publicaciones
	public void insertarPublicacion(Publicacion nuevaPublicacion) {
		misPublicaciones.add(nuevaPublicacion);
	}
	
	/*busca por el codigo un titulo de una publicacion*/
	public String getPublicacionById(String code){
		String titulo="";
		boolean find = false;
		int i=0;
		while (i<misPublicaciones.size()&&!find) {
			if(misPublicaciones.get(i).getId().equalsIgnoreCase(code)){
				titulo = misPublicaciones.get(i).getTitulo();
				find = true;
			}
			i++;
		}
		return titulo;
	}
	//inciso c , calcula la cantidad total de materia (libro , revista,articulo)
	public int cantByMateria(String materia){
		int cant = 0;
		for (Publicacion aux : misPublicaciones) {
			if(aux.getMateria().equalsIgnoreCase(materia))
				cant++;
		}
		return cant;
	}
	
	//inciso d 
	public boolean doPrestamo(String id, String cedula,Date retorno){
		boolean doPrestamo = false;
		Cliente client = findClienteByCedula(cedula);
		Publicacion publi = findPublicacionById(id);
		if(client.getMisPrestamo().size()<5 && publi.isStatus()){
			Prestamo nuevoPrestamo = new Prestamo(new Date(), retorno,publi, client.getCedula());
			misPrestamo.add(nuevoPrestamo);
			client.getMisPrestamo().add(nuevoPrestamo);
			doPrestamo = true;
			publi.setCantidadEjemplares(publi.getCantidadEjemplares()-1);;
		}
		
		return doPrestamo;
	}
	
	
	//////////////////////////////

private Publicacion findPublicacionById(String id) {
	Publicacion publicacion=null;
	boolean find = false;
	int i=0;
	while (i<misPublicaciones.size()&&!find) {
		if(misPublicaciones.get(i).getId().equalsIgnoreCase(id)){
			publicacion = misPublicaciones.get(i);
			find = true;
		}
		i++;
	}
	return publicacion;
}

private Cliente findClienteByCedula(String cedula) {
	Cliente client=null;
	boolean find = false;
	int i=0;
	while (i<misClientes.size()&&!find) {
		if(misClientes.get(i).getCedula().equalsIgnoreCase(cedula)){
			client = misClientes.get(i);
			find = true;
		}
		i++;
	}
	return client;
}

public int[] prestamosByType(String cedula){
	int[] cant = new int[3];
	for (int i = 0; i < cant.length; i++) {
		cant[i]=0;
	}
	
	for (Prestamo aux : misPrestamo) {
	   if(aux.getCedula().equalsIgnoreCase(cedula)){
		   if(aux.getPrestamo() instanceof Libro){
			   cant[0]++;
		   }
		   if(aux.getPrestamo() instanceof Revista){
			   cant[1]++;
		   }
		   if(aux.getPrestamo() instanceof Articulo){
			   cant[2]++;
		   }
	   }
	}
	return cant;
	
}

 public Cliente findClient(String cedula){
	 Cliente aux = null;
	 boolean find = false;
	 int i = 0;
	 while( i < misClientes.size() && !find){
		 if(misClientes.get(i).getCedula().equalsIgnoreCase(cedula))
		 {
			 find = true;
			 aux = misClientes.get(i);
		  }
		 i++;
		 }
	 return aux;
 }
 
 public boolean removeClient(String cedula){
	 boolean iCanRemove = false;
	 if(findClient(cedula)!=null){
		 if(findClient(cedula).getMisPrestamo().size()==0){
		 misClientes.remove(findClient(cedula));
		 iCanRemove = true;
		 }
	 }	 
	 return iCanRemove;
 }
	

}
