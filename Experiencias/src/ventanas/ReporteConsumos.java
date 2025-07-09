package ventanas;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clases.ExportarExcel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JTextField;
import java.awt.Color;


public class ReporteConsumos extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btnReporte;
	private JTable tablaReportes;
	private JButton btnExportar;
	private JTextField txtDisponible;
	private JTextField txtFecha;
	private JTextField txtRequerido;
	private JTextField txtRestante;
	private JButton btnActualizar;
	private JLabel lblDisponible;
	private JLabel lblFReporte;
	private JLabel lblRequerido;
	private JLabel lblRestante;
	private JLabel lblTrc;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteConsumos dialog = new ReporteConsumos();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public ReporteConsumos() {
		getContentPane().setBackground(new Color(255, 248, 220));
		setResizable(false);
		setTitle("REPORTE CONSUMOS");
		setBounds(100, 100, 550, 500);
		
		//LOGO
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Logo.png")); // Ruta desde src
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		lblTrc = new JLabel("");
		lblTrc.setBounds(180, 11, 150, 78);
		lblTrc.setIcon(new ImageIcon(ReporteConsumos.class.getResource("/imagenes/LogoCarranza.png")));
		getContentPane().add(lblTrc);
		
		btnReporte = new JButton("Mostrar Datos en Ventana");
		btnReporte.setBackground(new Color(100, 149, 237));
		btnReporte.addActionListener(this);
		btnReporte.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReporte.setBounds(160, 100, 190, 23);
		getContentPane().add(btnReporte);
		
		btnExportar = new JButton("Exportar Datos a Excel");
		btnExportar.setBackground(new Color(143, 188, 143));
		btnExportar.addActionListener(this);
		btnExportar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExportar.setBounds(280, 427, 190, 23);
		getContentPane().add(btnExportar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 140, 514, 195);
		getContentPane().add(scrollPane);
		
		tablaReportes = new JTable();
		tablaReportes.setBackground(new Color(240, 230, 140));
		tablaReportes.setModel(new DefaultTableModel(new Object[][] {},
		new String[] {"OPERACION", "RUTA", "UNIDADES", "GL/UNIDAD", "TOTAL GALONES"}) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablaReportes.getColumnModel().getColumn(4).setPreferredWidth(150);
		scrollPane.setViewportView(tablaReportes);
		
		lblDisponible = new JLabel("Diesel Disponible :");
		lblDisponible.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDisponible.setBounds(10, 346, 130, 23);
		getContentPane().add(lblDisponible);
		
		txtDisponible = new JTextField();
		txtDisponible.setForeground(new Color(50, 205, 50));
		txtDisponible.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtDisponible.setEditable(false);
		txtDisponible.setBounds(139, 348, 110, 20);
		getContentPane().add(txtDisponible);
		txtDisponible.setColumns(10);
		
		lblFReporte = new JLabel("Fecha de Reporte   :");
		lblFReporte.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFReporte.setBounds(10, 388, 130, 23);
		getContentPane().add(lblFReporte);
		
		txtFecha = new JTextField();
		txtFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFecha.setForeground(new Color(50, 205, 50));
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(139, 390, 110, 20);
		getContentPane().add(txtFecha);
		
		btnActualizar = new JButton("Actualizar Stock");
		btnActualizar.setBackground(new Color(100, 149, 237));
		btnActualizar.addActionListener(this);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBounds(55, 427, 190, 23);
		getContentPane().add(btnActualizar);
		
		lblRequerido = new JLabel("Diesel Requerido :");
		lblRequerido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRequerido.setBounds(259, 346, 130, 23);
		getContentPane().add(lblRequerido);
		
		txtRequerido = new JTextField();
		txtRequerido.setForeground(new Color(50, 205, 50));
		txtRequerido.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtRequerido.setEditable(false);
		txtRequerido.setColumns(10);
		txtRequerido.setBounds(395, 348, 129, 20);
		getContentPane().add(txtRequerido);
		
		lblRestante = new JLabel("Diesel Restante  :");
		lblRestante.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRestante.setBounds(259, 388, 130, 23);
		getContentPane().add(lblRestante);
		
		txtRestante = new JTextField();
		txtRestante.setForeground(new Color(50, 205, 50));
		txtRestante.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtRestante.setEditable(false);
		txtRestante.setColumns(10);
		txtRestante.setBounds(395, 390, 129, 20);
		getContentPane().add(txtRestante);
		
		txtDisponible.setText(String.format("%.2f", Principal.Galones));
	}
	private void mostrarReporteEnTabla(JTable tablaReporte, JTextField txtGasolinaRequerida, JTextField txtGasolinaRestante) {
	    String rutaArchivo = "datos/OperacionesProgramadas.txt";
	    DefaultTableModel modelo = (DefaultTableModel) tablaReporte.getModel();
	    modelo.setRowCount(0); // Limpiar filas anteriores

	    double totalGeneral = 0;

	    try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            String[] partes = linea.split(",");
	            if (partes.length == 5) {
	                String operacion = partes[0].trim();
	                String ruta = partes[1].trim();
	                int unidades = Integer.parseInt(partes[2].trim());
	                double galonesPorUnidad = Double.parseDouble(partes[3].trim());
	                double totalGalones = Double.parseDouble(partes[4].trim());

	                modelo.addRow(new Object[] {
	                    operacion, ruta, unidades, galonesPorUnidad, totalGalones
	                });

	                totalGeneral += totalGalones;
	            }
	        }
	      double totalRestante=Principal.Galones-totalGeneral;
	        txtGasolinaRequerida.setText("" + String.format("%.2f", totalGeneral));
	        if (totalRestante <= 0)
	        	JOptionPane.showMessageDialog(
	    	            this,
	    	            "Cantidad Requerida Excede Stock Disponible.",
	    	            "ALERTA",
	    	            JOptionPane.WARNING_MESSAGE);
	        txtGasolinaRestante.setText(""+totalRestante+" GALONES");
	    } catch (IOException | NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Error al leer archivo:\n" + e.getMessage());
	    }
	   
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnExportar) {
			actionPerformedBtnExportar(e);
		}
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}
	//BOTON PARA VER REPORTE
	protected void actionPerformedBtnReporte(ActionEvent e) {
		LocalDate fechaHoy = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		txtDisponible.setText(""+Principal.Galones);
		mostrarReporteEnTabla(tablaReportes,txtRequerido,txtRestante);
		txtFecha.setText(""+fechaHoy.format(formato));
		btnReporte.setEnabled(false);
		
	}
	//BOTON PARA EXPORTAR DATOS A EXCEL
	protected void actionPerformedBtnExportar(ActionEvent e) {
		ExportarExcel.exportar(this);

	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		double Gasolina = Double.parseDouble(txtDisponible.getText());
		double GasolinaGastada = Double.parseDouble(txtRequerido.getText());
		double totalRestante = Gasolina - GasolinaGastada;
		if (totalRestante <= 0) {
			JOptionPane.showMessageDialog(this, "Error al actualizar, Falta Stock disponible.");
			return;}
		txtDisponible.setText(""+totalRestante);
		
		JOptionPane.showMessageDialog(this, "Stock Actualizado con Exito");

	    Principal.Galones=totalRestante;
	    btnActualizar.setEnabled(false);
	}
}
