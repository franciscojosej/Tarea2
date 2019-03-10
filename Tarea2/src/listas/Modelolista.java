package listas;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

import logico.Publicacion;

public class Modelolista extends AbstractListModel{
	private ArrayList<Publicacion> lista =new ArrayList<>();
	

	@Override
	 public Object getElementAt(int index) {
		Publicacion p = lista.get(index);
	   return p.getTitulo();
	 }
    
    @Override
    public int getSize() {
       return lista.size();
    }
    
    /*notifica al jay list sobre un nuevo elemento*/
    public void addPersona(Publicacion p){
    	  lista.add(p);
    	  this.fireIntervalAdded(this, getSize(), getSize()+1);
    	 }
    
    //Elina un elemento de la lista
    public void eliminarPersona(int index0){
    	   lista.remove(index0);
    	   this.fireIntervalRemoved(index0, getSize(), getSize()+1);
    	 }
    //Se le pasa como paramentro el indice y retorna el ojeto completo
    public Publicacion getPersona(int index){
    	  return lista.get(index);
    	}
    
 
	

}
