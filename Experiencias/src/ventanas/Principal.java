package ventanas;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;

public class Principal extends JFrame implements ActionListener {
	
	FondoPanel fondo = new FondoPanel();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmActualizar;
	private JMenuItem mntmRegistrarOperacion;
	private JMenuItem mntmDescargaProgramada;
<<<<<<< HEAD
	private JMenuItem mntmConsumoProyectado;
	private JMenuItem mntmDescargasCombust;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaDe;
	
	public static double Galones = 3000.0;
=======
	
	//DATOS PUBLICOS PARA LOS DEMAS JDIALOG
	public static double Galones = 8000.0;
	private JMenuItem mntmGenerarReportes;
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee

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
		//ESTO PARA EL FONDO
		this.setContentPane(fondo);
		fondo.setLayout(null);
		//ACABO EL FONDO
		
		setTitle("SIPROC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 390);
		setExtendedState(JFrame.MAXIMIZED_BOTH);//PARA MAXIMIZAR
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//PARA CENTRAR TENEMOS QUE PRIMERO DARLE UN TAMAÑO AL JFRAME
		setLocationRelativeTo(null);
		//LOGO
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Logo.png")); // Ruta desde src
		setIconImage(icon.getImage());
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);

		mnArchivo.add(mntmSalir);
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));
		
		JMenu mnInventario = new JMenu("Inventario");
		menuBar.add(mnInventario);
		
		mntmConsultar = new JMenuItem("Consultar Stock");
		mntmConsultar.addActionListener(this);
		mnInventario.add(mntmConsultar);
		
		mntmActualizar = new JMenuItem("Actualizar Stock");
		mntmActualizar.addActionListener(this);
		mnInventario.add(mntmActualizar);
		
		JMenu mnOperaciones = new JMenu("Operaciones");
		menuBar.add(mnOperaciones);
		
		mntmRegistrarOperacion = new JMenuItem("Registrar por Operación");
		mntmRegistrarOperacion.addActionListener(this);
		mnOperaciones.add(mntmRegistrarOperacion);
		
		mntmDescargaProgramada = new JMenuItem("Administar Operaciones/Rutas");
		mntmDescargaProgramada.addActionListener(this);
		mnOperaciones.add(mntmDescargaProgramada);
		
		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
<<<<<<< HEAD
		mntmConsumoProyectado = new JMenuItem("Consumo Proyectado");
		mntmConsumoProyectado.addActionListener(this);
		mnReportes.add(mntmConsumoProyectado);
		
		mntmDescargasCombust = new JMenuItem("Descargas de combustible");
		mntmDescargasCombust.addActionListener(this);
		mnReportes.add(mntmDescargasCombust);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.addActionListener(this);
		mnAyuda.add(mntmAcercaDe);
=======
		mntmGenerarReportes = new JMenuItem("Generar reportes");
		mntmGenerarReportes.addActionListener(this);
		mnReportes.add(mntmGenerarReportes);
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee
	}
	//FONDO
	public class FondoPanel extends JPanel{
		private static final long serialVersionUID = 1L;
		private Image imagen; //DECLARA LA VARIABLE IMAGEN
		//CONSTRUCTOR DEL FONDO
		public FondoPanel() {
			ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/Fondo.png"));
			imagen = icono.getImage();
		}
		
		@Override
	    protected void paintComponent(Graphics g) {
	        if (imagen != null) {
	            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
	        }//SI LA IMAGEN SE CARGA ESTA SE DIBUJA DESDE LA ESQUINA SUPERIOR (0,0)
	        //Y LA ESTIRA AL TAMA�O COMPLETO DEL PANEL (GETWIDTG, GETHWIGHT)

	        setOpaque(false); //HACE QUE EL PANEL SEA TRANSPARENTE Y SOLO SE VEA LA IMAGEN
	        super.paintComponent(g);//PARA EVITAR FALLAS VISUALES/PARPADEOS Y MANTIENE LOS COMPONENTES
	    }
	}

	public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
		if (e.getSource() == mntmAcercaDe) {
			actionPerformedMntmAcercaDe(e);
		}
		if (e.getSource() == mntmDescargasCombust) {
			actionPerformedReporteDescargas(e);
		}
		if (e.getSource() == mntmConsumoProyectado) {
			actionPerformedMntmReporteConsumos(e);
=======
		if (e.getSource() == mntmGenerarReportes) {
			actionPerformedMntmGenerarReportes(e);
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee
		}
		if (e.getSource() == mntmDescargaProgramada) {
			actionPerformedMntmDescargaProgramada(e);
		}
		if (e.getSource() == mntmRegistrarOperacion) {
			actionPerformedMntmRegistrarOperacion(e);
		}
		if (e.getSource() == mntmActualizar) {
			actionPerformedMntmActualizar(e);
		}
		if (e.getSource() == mntmConsultar) {
			actionPerformedMntmConsultar(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
			int valor = JOptionPane.showOptionDialog(null, "¿Estas seguro de cerrar el programa?","Confirmar",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, null);
			if (valor == 0) System.exit(0);
		}
	//CONSULTAR STOCK GASOLINA
	protected void actionPerformedMntmConsultar(ActionEvent e) {
		ConsulStock dc = new ConsulStock();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}
	//ACTUALIZAR STOCK GASOLINA
	protected void actionPerformedMntmActualizar(ActionEvent e) {
		ActualizarStock dc = new ActualizarStock();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}
	//REGISTRO DE OPERACIONES
	protected void actionPerformedMntmRegistrarOperacion(ActionEvent e) {
		RegisOperacion dc = new RegisOperacion();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}
	//ADMINISTRAR OPERACIONES/RUTAS
	protected void actionPerformedMntmDescargaProgramada(ActionEvent e) {
		AdmiOperaciones dc = new AdmiOperaciones();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}
	//GENERAR REPORTES
<<<<<<< HEAD
	protected void actionPerformedMntmReporteConsumos(ActionEvent e) {
		ReporteConsumos rc = new ReporteConsumos();
		rc.setLocationRelativeTo(this);
		rc.setVisible(true);
	}
	protected void actionPerformedReporteDescargas(ActionEvent e) {
		ReporteDescargas rd = new ReporteDescargas();
		rd.setLocationRelativeTo(this);
		rd.setVisible(true);
	}
	protected void actionPerformedMntmAcercaDe(ActionEvent e) {
		AcercaDe ad = new AcercaDe();
		ad.setLocationRelativeTo(this);
		ad.setVisible(true);
=======
	protected void actionPerformedMntmGenerarReportes(ActionEvent e) {
		GenerarReportes dc = new GenerarReportes();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee
	}
}
