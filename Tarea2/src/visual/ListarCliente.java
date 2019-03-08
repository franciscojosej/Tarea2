package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Border;
import logico.Articulo;
import logico.Biblioteca;
import logico.Cliente;
import logico.Libro;
import logico.Publicacion;
import logico.Revista;

import java.awt.Color;

public class ListarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	//private static  Object[][] datofila= new Object[3][4] ;
	private static String columnNombre[] = {"Nombre","Cedula","Numero","Direccion"};

	private static DefaultTableModel tableModel;
	private int code;
	private static JTable table;
	//JTable(Object[][] rowData, Object[] columnNames)
	//Constructs a JTable to display the values in the two dimensional array, rowData, with column names, columnNames.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarCliente dialog = new ListarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarCliente() {
		setBounds(5, 50, 762, 422);
		setTitle("Clientes");
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panelDatos = new JPanel();
				panelDatos.setBorder(new TitledBorder(null, "Datos de los Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel.add(panelDatos, BorderLayout.CENTER);

				
				
				
				

				
				 {
					 /*
					int j=0;
					while(j<4) {
						datofila[1][0]= "nom";//aux.getNombre();
						datofila[1][1]="nom";
						datofila[1][2]="nom";
						datofila[1][3]="nom";
						j++;
					}*/
				panelDatos.setLayout(null);
				//llenararreglo();
			
					
				table = new JTable(llenararreglo(),columnNombre);
				//table.setBounds(2, 2, 600, 300);
				

				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(10, 32, 711, 292);
				panelDatos.add(scrollPane,BorderLayout.CENTER);
				
				}

			
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
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

	private Object[][] llenararreglo() {
		Object[][] datofila=new Object[Biblioteca.getInstance().getMisClientes().size()][4];
		int i=0;
		for(Cliente aux : Biblioteca.getInstance().getMisClientes()) {
			datofila[i][0]=aux.getNombre();
			datofila[i][1]=aux.getCedula();	
			datofila[i][2]=aux.getTelefono();
			datofila[i][3]=aux.getDireccion();
			i++;
		}
		return datofila;
		
		
	}

	
}
