package listas;

import javax.swing.*;

import logico.Biblioteca;
import logico.Libro;
import logico.Publicacion;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class JListFilterExample {
	  
    public static void main(String[] args) {
 
        Libro dd= new Libro ("dddddd", "mm", "dd", 33, true, "ddd", "dddddd");
        Libro d= new Libro ("a", "aa", "dd", 33, true, "ddd", "dddddd");
       for (int i = 0; i <4; i++) {
        	Biblioteca.getInstance().getMisPublicaciones().add(dd);
        }
       for (int i = 0; i <2; i++) {
       	Biblioteca.getInstance().getMisPublicaciones().add(d);
       }
   	ArrayList<Publicacion> aux=  Biblioteca.getInstance().getMisPublicaciones();
    	List<String> joder =new ArrayList<>();
        for (Publicacion pu : aux) {
     	   joder.add(pu.getAutor()+" "+pu.getTitulo());
 
        	}
    	
	
        List<String> Stringes = joder;//miBiblio();

        
        DefaultListModel<String> model = new DefaultListModel<>();
        Stringes.forEach(model::addElement);
        JList<String> jList = new JList<>(model);
         
        JPanel panel = JListFilterDecorator.decorate(jList, JListFilterExample::employeeFilter);///

        JFrame frame = createFrame();
        frame.getContentPane().add(panel);
        frame.setLocationRelativeTo(null);
      //  frame.setTitle( jList.getFocusTraversalPolicy());
        frame.setVisible(true);
        

    }
/////////////////////////////
    private static boolean employeeFilter(String emp, String str) {
        return emp.toLowerCase().contains(str.toLowerCase());
       
    }

    private static ListCellRenderer<? super String> createListRenderer() {
        return new DefaultListCellRenderer() {
            private Color background = new Color(0, 100, 255, 15);
            private Color defaultBackground = (Color) UIManager.get("List.background");

    
      
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (c instanceof JLabel) {
                    JLabel label = (JLabel) c;
                    String emp = (String) value;
                    label.setText(String.format("%s   kk [%s]", emp, emp));
                    if (!isSelected) {
                        label.setBackground(index % 2 == 0 ? Color.CYAN: Color.BLACK);     
                    }
 
                }
                return c;
            }
            


            
        };
    }
//crea un frame
    private static JFrame createFrame() {
        JFrame frame = new JFrame("JList Example");

   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 300));
        return frame;
    }
    
    
   
}