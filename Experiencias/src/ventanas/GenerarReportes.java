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


public class GenerarReportes extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btnReporte;
	private JTable tablaReportes;
	private JButton btnExportar;
	private JTextField txtGasolina;
	private JTextField txtFecha;
	private JTextField txtGasolinaRequerida;
	private JTextField txtGasolinaRestante;
	private JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerarReportes dialog = new GenerarReportes();
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
	public GenerarReportes() {
		setResizable(false);
		setTitle("GENERAR REPORTES");
		setBounds(100, 100, 550, 500);
		
		//LOGO
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Logo.png")); // Ruta desde src
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(180, 11, 150, 78);
		lblNewLabel.setIcon(new ImageIcon(GenerarReportes.class.getResource("/imagenes/LogoCarranza.png")));
		getContentPane().add(lblNewLabel);
		
		btnReporte = new JButton("Mostrar Datos en Ventana");
		btnReporte.addActionListener(this);
		btnReporte.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReporte.setBounds(160, 100, 190, 23);
		getContentPane().add(btnReporte);
		
		btnExportar = new JButton("Exportar Datos a Excel");
		btnExportar.addActionListener(this);
		btnExportar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExportar.setBounds(280, 427, 190, 23);
		getContentPane().add(btnExportar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 140, 514, 195);
		getContentPane().add(scrollPane);
		
		tablaReportes = new JTable();
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
		
		JLabel lblNewLabel_1 = new JLabel("Gasolina Disponible :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 346, 130, 23);
		getContentPane().add(lblNewLabel_1);
		
		txtGasolina = new JTextField();
		txtGasolina.setEditable(false);
		txtGasolina.setBounds(139, 348, 110, 20);
		getContentPane().add(txtGasolina);
		txtGasolina.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de Reporte   :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 388, 130, 23);
		getContentPane().add(lblNewLabel_2);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(139, 390, 110, 20);
		getContentPane().add(txtFecha);
		
		btnActualizar = new JButton("Actualizar Stock");
		btnActualizar.addActionListener(this);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBounds(55, 427, 190, 23);
		getContentPane().add(btnActualizar);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gasolina Requerida :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(259, 346, 130, 23);
		getContentPane().add(lblNewLabel_1_1);
		
		txtGasolinaRequerida = new JTextField();
		txtGasolinaRequerida.setEditable(false);
		txtGasolinaRequerida.setColumns(10);
		txtGasolinaRequerida.setBounds(395, 348, 129, 20);
		getContentPane().add(txtGasolinaRequerida);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Gasolina Restante  :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(259, 388, 130, 23);
		getContentPane().add(lblNewLabel_1_1_1);
		
		txtGasolinaRestante = new JTextField();
		txtGasolinaRestante.setEditable(false);
		txtGasolinaRestante.setColumns(10);
		txtGasolinaRestante.setBounds(395, 390, 129, 20);
		getContentPane().add(txtGasolinaRestante);
		

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
		txtGasolina.setText(""+Principal.Galones);
		mostrarReporteEnTabla(tablaReportes,txtGasolinaRequerida,txtGasolinaRestante);
		txtFecha.setText(""+fechaHoy.format(formato));
		btnReporte.setEnabled(false);
		
	}
	//BOTON PARA EXPORTAR DATOS A EXCEL
	protected void actionPerformedBtnExportar(ActionEvent e) {
		ExportarExcel.exportar();
		//JOptionPane.showMessageDialog(this, "Archivo Excel exportado exitosamente!", 
        //        "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		double Gasolina = Double.parseDouble(txtGasolina.getText());
		double GasolinaGastada = Double.parseDouble(txtGasolinaRequerida.getText());
		double totalRestante = Gasolina - GasolinaGastada;
		if (totalRestante <= 0) {
			JOptionPane.showMessageDialog(this, "Error al actualizar, Falta Stock disponible.");
			return;}
		txtGasolina.setText(""+totalRestante);
		
		JOptionPane.showMessageDialog(this, "Stock Actualizado con Exito");

	    Principal.Galones=totalRestante;
	    btnActualizar.setEnabled(false);
	}
}
