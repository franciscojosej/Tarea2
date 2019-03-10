package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionListener;

import listas.Modelolista;

import javax.swing.event.ListSelectionEvent;

public class GestionarPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JList <String> lista;
	//private JPanel laminaDeLista, laminaDeTexto;
	//private  JLabel rotulo;
	
	JLabel label_prueba;
	private String[] meses ={"Enero","Febrero","Marzp","abril"};
	

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
		setBounds(100, 100, 751, 476);
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
			panelListaPrestamos.setBounds(10, 45, 252, 338);
			panel.add(panelListaPrestamos);
			panelListaPrestamos.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 11, 232, 316);
				panelListaPrestamos.add(scrollPane);
				{
					
					Modelolista list_model = new Modelolista();
					
					JList<Publicacion> list = new JList();//meses
					
					for (Publicacion aux : Biblioteca.getInstance().getMisPublicaciones()) {
						list_model.addPersona(aux);
					}
					list.setModel(list_model);
					
					list.addListSelectionListener(new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent e) {
							List<Publicacion> valores= list.getSelectedValuesList();
							
							//StringBuilder texto = new StringBuilder("Valor selecionao");
							

							
							
						
						//	label_prueba.setText(texto.toString());
						}
					});
					scrollPane.setViewportView(list);
				}
			}
			
			label_prueba = new JLabel("New label");
			
			label_prueba.setBounds(295, 45, 237, 38);
			panel.add(label_prueba);
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
}
