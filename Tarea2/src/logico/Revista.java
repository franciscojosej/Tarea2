package logico;

public class Revista extends Publicacion {
	private int anno;
	private int numero;
	
	
	
	public Revista(String id, String autor, String titulo, int cantidadEjemplares, boolean estado, String materia,
			int anno, int numero) {
		super(id, autor, titulo, cantidadEjemplares, estado, materia);
		this.anno = anno;
		this.numero = numero;
	}



	public int getAnno() {
		return anno;
	}



	public void setAnno(int anno) {
		this.anno = anno;
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	

}
