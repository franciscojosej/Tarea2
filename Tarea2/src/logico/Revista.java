package logico;

public class Revista extends Publicacion {
	private String anno;
	private String numero;
	
	
	public Revista(String id, String autor, String titulo, int cantidadEjemplares, boolean estado, String materia,
			String anno, String numero) {
		super(id, autor, titulo, cantidadEjemplares, estado, materia);
		this.anno = anno;
		this.numero = numero;
	}


	public String getAnno() {
		return anno;
	}


	public void setAnno(String anno) {
		this.anno = anno;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
	
	

}
