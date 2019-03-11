package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.time.LocalDateTime;
import java.time.Month;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;



import logico.Biblioteca;
import logico.Cliente;
import logico.Prestamo;
import logico.Publicacion;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RealizarPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textF_Cedula;
    private int index =0;
    private Publicacion miPubli;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public RealizarPrestamo(int index, Publicacion miPubli) {
		this.index=index;
		this.miPubli= miPubli;
		setBounds(100, 100, 500, 396);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblFecha = new JLabel("Fecha:");
			lblFecha.setBounds(10, 275, 46, 14);
			panel.add(lblFecha);
			
			JLabel FechaActual = new JLabel("New label");
			FechaActual.setBounds(55, 275, 71, 14);
			LocalDateTime fecha =LocalDateTime.now();
			LocalDateTime algunDia = LocalDateTime.of(1976, Month.MARCH, 27, 6, 10); 
			
			
			FechaActual.setText(String.valueOf(fecha.getMonthValue())+":"+String.valueOf(fecha.getDayOfMonth()+":"+String.valueOf(fecha.getYear())));
			panel.add(FechaActual);
			
			JLabel lblNewLabel_1 = new JLabel("Cedula:");
			lblNewLabel_1.setBounds(10, 24, 46, 14);
			panel.add(lblNewLabel_1);
			
			textF_Cedula = new JTextField();
			textF_Cedula.setBounds(10, 54, 86, 20);
			panel.add(textF_Cedula);
			textF_Cedula.setColumns(10);
			
			JLabel lblFechaDeEntrega = new JLabel("Fecha De Entrega:");
			lblFechaDeEntrega.setBounds(303, 275, 124, 14);
			lblFechaDeEntrega.setText(String.valueOf(fecha.getMonthValue()+1)+":"+String.valueOf(fecha.getDayOfMonth()+":"
			+String.valueOf(fecha.getYear())));
			
			panel.add(lblFechaDeEntrega);
			
			JLabel lael = new JLabel("Fecha De Entrega");
			lael.setBounds(200, 275, 93, 14);
			panel.add(lael);
			
			JLabel lblIdPublicacion = new JLabel("Id Publicacion:");
			lblIdPublicacion.setBounds(10, 85, 86, 14);
			panel.add(lblIdPublicacion);
			
			JLabel lblTitulo = new JLabel("Titulo:");
			lblTitulo.setBounds(10, 140, 46, 14);
			panel.add(lblTitulo);
			
			JLabel lblIformacionid = new JLabel("IformacionId");
			lblIformacionid.setBounds(10, 110, 116, 19);
			
			lblIformacionid.setText(miPubli.getId());
			panel.add(lblIformacionid);
			
			JLabel TituloPublicacion = new JLabel("titulo");
			TituloPublicacion.setBounds(10, 165, 46, 14);
			TituloPublicacion.setText(miPubli.getTitulo());
			panel.add(TituloPublicacion);
			
			JLabel lblPrecio = new JLabel("Precio:");
			lblPrecio.setBounds(10, 190, 46, 14);
			panel.add(lblPrecio);
			
			JLabel Precio = new JLabel("10$");
			Precio.setBounds(10, 223, 46, 14);
			panel.add(Precio);
			
			JLabel lblTotalAdeudado = new JLabel("Total Adeudado:");
			lblTotalAdeudado.setBounds(261, 223, 93, 14);
			panel.add(lblTotalAdeudado);
			
			JLabel Adeudado = new JLabel("310");
			Adeudado.setBounds(360, 223, 46, 14);
			panel.add(Adeudado);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Prestamo miPrestamo =new Prestamo(FechaActual, fechaDeEntrega, prestamo, cedula)
						//Cliente miCliente =Biblioteca.getInstance().findClient(textF_Cedula.getText())
						//if(!textF_Cedula.getText().equalsIgnoreCase("")&&miCliente!=null) {
							
							//miCliente.setMisPrestamo(misPrestamo);
						//}
					}
				});
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
