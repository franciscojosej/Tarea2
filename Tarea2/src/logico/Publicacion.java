package logico;

import java.io.Serializable;

public class Publicacion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String id;//6 digitos
	protected String autor;
	//private String editorial;
	protected String titulo;
	protected int cantidadEjemplares;
	protected  boolean estado; //Disponible ,agotado
	protected String materia;
	
	public Publicacion(String id, String autor, String titulo, int cantidadEjemplares, boolean estado, String materia) {
		super();
		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.cantidadEjemplares = cantidadEjemplares;
		this.estado = estado;
		this.materia = materia;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getCantidadEjemplares() {
		return cantidadEjemplares;
	}


	public void setCantidadEjemplares(int cantidadEjemplares) {
		if(cantidadEjemplares==0) {
			setEstado(false);
		}else {
			this.cantidadEjemplares= cantidadEjemplares;
		 
		}
		
	}

	
	public boolean isEstado() {
		return estado;
	}
	public boolean isStatus() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	
	
	

}
