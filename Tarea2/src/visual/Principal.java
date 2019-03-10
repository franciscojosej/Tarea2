package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Biblioteca");
		setResizable(false);
	//	setLocationRelativeTo(1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(200, 200, 571, 417);
		dm= getToolkit().getScreenSize();
		JMenuBar menuBar = new JMenuBar();
		super.setSize(dm.width-50,dm.height-100);
		
		setJMenuBar(menuBar);
		
		JMenu mnRegistrar = new JMenu("Registrar");
		menuBar.add(mnRegistrar);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarCliente reg =new RegistrarCliente();
				reg.setModal(true);
				reg.setVisible(true);
				
				//reg.setLocationRelativeTo(contentPane);
			}
		});
		mntmCliente.addMouseListener(new MouseAdapter() {

		});
		mnRegistrar.add(mntmCliente);
		
		JMenuItem mntmPublicacin = new JMenuItem("Publicaci\u00F3n");
		mntmPublicacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPublicacion miPublicacion =new RegistrarPublicacion("Registrar Publicaciones", 0);
				miPublicacion.setModal(true);
				//miPublicacion.setLocationRelativeTo(null);
				miPublicacion.setVisible(true);
			}
		});
		mnRegistrar.add(mntmPublicacin);
		
		JMenu mnPrestamo = new JMenu("Prestamo");
		menuBar.add(mnPrestamo);
		  
		JMenuItem mntmNuevoPrestamo = new JMenuItem("Gestionar Prestamo");
		mntmNuevoPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionarPrestamo mipres = new GestionarPrestamo();
				mipres.setModal(true);
				mipres.setVisible(true);
			}
		});
		mnPrestamo.add(mntmNuevoPrestamo);
		
		JMenu mnListar = new JMenu("Listar");
		menuBar.add(mnListar);
		
		JMenuItem mntmPublicaciones = new JMenuItem("Publicaciones");
		mntmPublicaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarPublicaciones list = new ListarPublicaciones();
				list.setModal(true);
				list.setLocationRelativeTo(null);
				list.setVisible(true);
			}
		});
		mnListar.add(mntmPublicaciones);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarCliente lisClien =new ListarCliente();
				lisClien.setModal(false);
				lisClien.setVisible(true);
				
			}
		});
		mnListar.add(mntmClientes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
	
	}



	
}
