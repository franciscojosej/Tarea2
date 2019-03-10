package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import logico.Biblioteca;
import logico.Cliente;
import logico.Libro;
import logico.Publicacion;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionListener;
import javax.swing.text.AbstractDocument.BranchElement;

import javafx.scene.control.Cell;
import javafx.scene.layout.Border;
import listas.Modelolista;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;

import java.awt.Button;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GestionarPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JList <String> lista;
	private String[] meses ={"Enero","Febrero","Marzp","abril"};
	private JTextField textFNombreLibro;
	private JTextField textField;
	
	Modelolista list_model ;
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
			JPanel panel = new JPanel();
			panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panelListaPrestamos = new JPanel();
			panelListaPrestamos.setBounds(24, 115, 252, 309);
			panel.add(panelListaPrestamos);
			panelListaPrestamos.setLayout(null);
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(10, 11, 232, 287);
			panelListaPrestamos.add(scrollPane_1);
			
			JList<Publicacion> list = new JList();
			
			scrollPane_1.setViewportView(list);
			 list_model = new Modelolista();
			
	            background = new Color(0, 100, 255, 15);
	           defaultBackground = (Color) UIManager.get("List.background");
	           
	           Libro  dd= new Libro("dddddd", "d", "dd", 33, true, "ddd", "dddddd");
	           for (int i = 0; i <1; i++) {
	        	   Biblioteca.getInstance().getMisPublicaciones().add(dd);
				
			}
	           Libro  d= new Libro("dddddd", "a", "dd", 33, true, "ddd", "dddddd");
	           for (int i = 0; i < 5; i++) {
	        	   Biblioteca.getInstance().getMisPublicaciones().add(d);
				
			}
				
			

		
			
			
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					List<Publicacion> valores= list.getSelectedValuesList();
					
					//StringBuilder texto = new StringBuilder("Valor selecionao");
					

					
					
				
				//	label_prueba.setText(texto.toString());
				}
			});
	
			
			textFNombreLibro = new JTextField();
			textFNombreLibro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					for (Publicacion aux : Biblioteca.getInstance().getMisPublicaciones()) {
						
						if(filtro(textFNombreLibro.getText())!=true) {
							list_model.addPersona(aux);
							list.setForeground(Color.BLUE);
						}
							
					}
					
					
					list.setModel(list_model);
				//	list.removeAll();
					//list_model.clear();
				}
				
			});
		
			
			
			
			
			
		

				
			
			
			
			
		


			textFNombreLibro.setBounds(126, 85, 159, 20);
			panel.add(textFNombreLibro);
			textFNombreLibro.setColumns(10);
			
			JLabel lblNombreDelLibro = new JLabel("Nombre Del Libro:");
			lblNombreDelLibro.setBounds(24, 87, 123, 17);
			panel.add(lblNombreDelLibro);
			
			JLabel lblId = new JLabel("ID:");
			lblId.setBounds(24, 52, 46, 14);
			panel.add(lblId);
			{
				textField = new JTextField();
				textField.setBounds(126, 49, 160, 20);
				panel.add(textField);
				textField.setColumns(10);
			}
			
			
			Button button = new Button(">");
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
			panePrestamos.setBounds(396, 115, 252, 309);
			panel.add(panePrestamos);
			panePrestamos.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 232, 287);
			panePrestamos.add(scrollPane);
			
			JList list_1 = new JList();
			scrollPane.setViewportView(list_1);
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
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
		}
	}

	private boolean filtro(String ss) {
		// TODO Auto-generated method stub
boolean	 filtrar =false;
	 for (Publicacion aux : Biblioteca.getInstance().getMisPublicaciones()) {
		 if(aux.getAutor().equalsIgnoreCase(ss)) {
			  filtrar = true;
			  break;
			
		 }
	
	}
	 return filtrar;
	 


		
	}

	

	}


