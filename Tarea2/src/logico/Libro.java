package logico;

import java.io.Serializable;

public class Libro extends Publicacion implements Serializable{
	private String editorial;

	public Libro(String id, String autor, String titulo, int cantidadEjemplares, boolean estado, String materia,
			String editorial) {
		super(id, autor, titulo, cantidadEjemplares, estado, materia);
		this.editorial = editorial;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	
	

}
