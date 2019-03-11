package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.sun.javafx.embed.swing.Disposer;

import logico.Biblioteca;

import logico.Libro;
import logico.Publicacion;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;



import listas.JListFilterDecorator;

import listas.Modelolista;


import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GestionarPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
//	private JList <String> lista;

	private JTextField textFNombreLibro=new JTextField();;
	private JTextField textF_ID;
	private JPanel panelListaPrestamos ;
	private DefaultListModel<String> model;
	private Modelolista modelo;
    Color background ;
    Color defaultBackground ;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionarPrestamo dialog = new GestionarPrestamo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestionarPrestamo() {
		setBounds(100, 100, 756, 584);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
	///////////
		/*
	        Libro d= new Libro ("222", "Jose", "Rojas", 33, true, "ddd", "dddddd");
	
	       for (int i = 0; i <5; i++) {
	       	Biblioteca.getInstance().getMisPublicaciones().add(d);
	       }
	       Libro b= new Libro ("Mujer", "pablo", "Gomez", 33, true, "ddd", "dddddd");
	   	
	       for (int i = 0; i <5; i++) {
	       	Biblioteca.getInstance().getMisPublicaciones().add(b);
	       }
	       */
	    	ArrayList<Publicacion> aux=  Biblioteca.getInstance().getMisPublicaciones();
	    	List<String> joder =new ArrayList<>();
	        for (Publicacion pu : aux) {///
	     	   joder.add(pu.getTitulo()+". "+pu.getCantidadEjemplares()+" ");
	        	}
	        List<String> pList = joder;//miBiblio();
	         model = new DefaultListModel<>();
	        pList .forEach(model::addElement);
	        JList<String> jList = new JList<>(model);
	        		///// 
	        
	        
	        
			JPanel panel = new JPanel();
			panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			
			panel.setLayout(null);
			

			panelListaPrestamos =JListFilterDecorator.decorate(jList, GestionarPrestamo::employeeFilter,textFNombreLibro);// new JPanel();
			
			panelListaPrestamos.setBounds(24, 115, 252, 309);
			panel.add(panelListaPrestamos);
			//panelListaPrestamos.setLayout(null);
			
		//	JScrollPane scrollPane_1 = new JScrollPane();
		//	scrollPane_1.setBounds(10, 11, 232, 287);
		//	panelListaPrestamos.add(scrollPane_1);
			
			
		//	JList<Publicacion> list = new JList();
			
			//scrollPane_1.setViewportView(jList);
			
			// list_model = new Modelolista();
			
	          //  background = new Color(0, 100, 255, 15);
	       //    defaultBackground = (Color) UIManager.get("List.background");
	           
	           

				
			

		
			
	/*
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					List<Publicacion> valores= list.getSelectedValuesList();
					
					//StringBuilder texto = new StringBuilder("Valor selecionao");
					

					
					
				
				//	label_prueba.setText(texto.toString());
				}
			});
	*/
			////
			//textFNombreLibro = 

			textFNombreLibro.setBounds(126, 85, 159, 20);
			panel.add(textFNombreLibro);
			textFNombreLibro.setColumns(10);
			///

			
			JLabel lblNombreDelLibro = new JLabel("Nombre Del Libro:");
			lblNombreDelLibro.setBounds(24, 87, 123, 17);
			panel.add(lblNombreDelLibro);
			
			JLabel lblId = new JLabel("ID:");
			lblId.setBounds(24, 52, 46, 14);
			panel.add(lblId);
			{
				textF_ID = new JTextField();
				textF_ID.setBounds(126, 49, 160, 20);
				panel.add(textF_ID);
				textF_ID.setColumns(10);
			}
			
			
			Button button = new Button(">");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				Publicacion aux =Biblioteca.getInstance().findPublicacionById(textF_ID.getText());
				
					if(aux!=null&& !textFNombreLibro.getText().equalsIgnoreCase("")&& aux.getTitulo().equalsIgnoreCase(textFNombreLibro.getText())&&
							jList.getSelectedIndex()!=-1) {
						RealizarPrestamo nuevoPrestamo = new  RealizarPrestamo(jList.getSelectedIndex(),aux);
						nuevoPrestamo.setModal(true);
						nuevoPrestamo.setVisible(true);
					//jList.getSelectedIndex());
						
					
					}else {
						JOptionPane.showMessageDialog(null, "Verificar, Campos y Seleccion", ":(", JOptionPane.WARNING_MESSAGE, null);
					}
						
					
					
				}
			});
			button.setFont(new Font("Dialog", Font.BOLD, 18));
			button.setBounds(298, 187, 70, 22);
			panel.add(button);
			{
				Button button_1 = new Button("<");
				button_1.setFont(new Font("Calibri", Font.BOLD, 18));
				button_1.setBounds(298, 238, 70, 22);
				panel.add(button_1);
			}
			
			JPanel panePrestamos = new JPanel();
			panePrestamos.setBounds(391, 103, 276, 329);
			panel.add(panePrestamos);
			panePrestamos.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 256, 307);
			panePrestamos.add(scrollPane);
			
			JList list_prestamo = new JList();
			
			modelo = new Modelolista();
		//	modelo.addPersona(d);
			list_prestamo.setModel(modelo);
			
			scrollPane.setViewportView(list_prestamo);
			
			//JList list_1 = new JList();
		//	scrollPane.setViewportView(list_1);
			//panelListaPrestamos.list(new lisSeletionLisene());
				
			
			
			/*
			lista=new JList<String>(meses);
			lista.setVisibleRowCount(4);//cuantos elementos se desea hacer vicible antes del scr

			JScrollPane barraDeDesplazamiento = new JScrollPane(lista);// agregar a el JScrollPa la lista de desplazamiento
			laminaDeLista = new JPanel();
			
			laminaDeLista.add(barraDeDesplazamiento);//se agrega al panel el JScrollPa
			
			laminaDeTexto = new JPanel();
			
			rotulo= new JLabel("Mes selecionado");
			laminaDeTexto.add(rotulo);
			add(laminaDeLista);//,BorderLayout.NORTH);
			add(laminaDeTexto);//,BorderLayout.SOUTH);
			laminaDeLista.setBounds(52, 32, 254, 289);
			laminaDeTexto.setBounds(52, 32, 254, 289);
			*/
		//	panel.add(lista);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
		}
		
        
        
    	
	
      
		
	}




	////////////////////////////////////////////////////////////
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

	

	}


