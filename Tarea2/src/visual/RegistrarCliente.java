package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import com.sun.javafx.embed.swing.Disposer;

import logico.Biblioteca;
import logico.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textF_Nombre_C;
	private JTextField textF_Cedula;
	private JTextField textF_Direccion;
	private JTextField textF_Telefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarCliente dialog = new RegistrarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarCliente() {
		setResizable(false);
		setBounds(5, 50, 500, 300);
		setTitle("Registrar Cliente");

		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 36, 57, 14);
			panel.add(lblNombre);
			
			textF_Nombre_C = new JTextField();
			textF_Nombre_C.setBounds(77, 33, 86, 20);
			panel.add(textF_Nombre_C);
			textF_Nombre_C.setColumns(10);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setBounds(10, 61, 46, 14);
			panel.add(lblCedula);
			
			textF_Cedula = new JTextField();
			textF_Cedula.setBounds(77, 61, 86, 20);
			panel.add(textF_Cedula);
			textF_Cedula.setColumns(10);
			
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setBounds(10, 92, 68, 14);
			panel.add(lblDireccion);
			
			textF_Direccion = new JTextField();
			textF_Direccion.setBounds(77, 89, 86, 20);
			panel.add(textF_Direccion);
			textF_Direccion.setColumns(10);
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(10, 123, 68, 14);
			panel.add(lblTelefono);
			
			textF_Telefono = new JTextField();
			textF_Telefono.setBounds(77, 117, 86, 20);
			panel.add(textF_Telefono);
			textF_Telefono.setColumns(10);
			
	
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Cliente auxCli=null;
						String nombre= textF_Nombre_C.getText();
						String	cedula=textF_Cedula.getText();
						String direccion= textF_Direccion.getText();
						String	telefono =textF_Telefono.getText();
						
						
						if(!textF_Nombre_C.getText().equals("") && !textF_Cedula.getText().equals("") &&
								!textF_Direccion.getText().equals("")&&!textF_Telefono.getText().equals("") ) {
							auxCli = new Cliente(cedula, nombre, direccion, telefono);
							Biblioteca.getInstance().setMisClientes(auxCli);
						
							JOptionPane.showMessageDialog(okButton, "Cliente Registrado", "Conrirmacion",
									JOptionPane.INFORMATION_MESSAGE);
							for (Cliente ux : Biblioteca.getInstance().getMisClientes()) {
								JOptionPane.showMessageDialog(null, "ns", ux.getNombre(), JOptionPane.CANCEL_OPTION);
								CleartexFi();
							}
						}else {
							JOptionPane.showMessageDialog(okButton, "Verificar Campos", "Error",JOptionPane.ERROR_MESSAGE );
						}
						
						
						

						
						
					}

					private void CleartexFi() {
						// TODO Auto-generated method stub
						 textF_Nombre_C.setText("");
						textF_Cedula.setText("");
						textF_Direccion.setText("");
						textF_Telefono.setText("");
						
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
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
}
