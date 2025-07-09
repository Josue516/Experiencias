package ventanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.SwingConstants;
import java.awt.Color;

public class ReporteDescargas extends JDialog implements ActionListener{
	private static final long serialVersionUID = 1L;
	private boolean reporteGenerado = false;
	private JButton btnReporte;
	private JTable tablaReportes;
	private JButton btnExportar;
	private JTextField txtPetroperu;
	private JTextField txtRepsol;
	private JTextField txtNumay;
	private JTextField txtPrimax;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lblPetroperu;
	private JLabel lblRepsol;
	private JLabel lblNumay;
	private JLabel lblPrimax;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteDescargas dialog = new ReporteDescargas();
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
	public ReporteDescargas() {
		getContentPane().setBackground(new Color(255, 248, 220));
		setResizable(false);
		setTitle("GENERAR REPORTES");
		setBounds(100, 100, 550, 500);
		
		//LOGO
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Logo.png")); // Ruta desde src
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(180, 11, 150, 78);
		lblNewLabel.setIcon(new ImageIcon(ReporteConsumos.class.getResource("/imagenes/LogoCarranza.png")));
		getContentPane().add(lblNewLabel);
		
		btnReporte = new JButton("Mostrar Reporte en Ventana");
		btnReporte.setBackground(new Color(100, 149, 237));
		btnReporte.setForeground(new Color(0, 0, 0));
		btnReporte.addActionListener(this);
		btnReporte.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReporte.setBounds(149, 100, 207, 23);
		getContentPane().add(btnReporte);
		
		btnExportar = new JButton("Exportar Datos a txt");
		btnExportar.setBackground(new Color(144, 238, 144));
		btnExportar.addActionListener(this);
		btnExportar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExportar.setBounds(160, 421, 190, 23);
		getContentPane().add(btnExportar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 140, 514, 195);
		getContentPane().add(scrollPane);
		
		tablaReportes = new JTable();
		tablaReportes.setBackground(new Color(240, 230, 140));
		tablaReportes.setModel(new DefaultTableModel(new Object[][] {},
		new String[] {"FECHA", "CANTIDAD", "PROVEEDOR", "RECEPCIONO"}) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablaReportes.getColumnModel().getColumn(3).setPreferredWidth(150);
		scrollPane.setViewportView(tablaReportes);
		
		lblPetroperu = new JLabel("PETROPERÚ:");
		lblPetroperu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPetroperu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPetroperu.setBounds(10, 346, 98, 23);
		getContentPane().add(lblPetroperu);
		
		txtPetroperu = new JTextField();
		txtPetroperu.setEditable(false);
		txtPetroperu.setBounds(117, 348, 110, 20);
		getContentPane().add(txtPetroperu);
		txtPetroperu.setColumns(10);
		
		lblRepsol = new JLabel("REPSOL:");
		lblRepsol.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRepsol.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRepsol.setBounds(10, 388, 98, 23);
		getContentPane().add(lblRepsol);
		
		txtRepsol = new JTextField();
		txtRepsol.setEditable(false);
		txtRepsol.setColumns(10);
		txtRepsol.setBounds(117, 390, 110, 20);
		getContentPane().add(txtRepsol);
		
		lblNumay = new JLabel("NUMAY:");
		lblNumay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumay.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumay.setBounds(237, 346, 130, 23);
		getContentPane().add(lblNumay);
		
		txtNumay = new JTextField();
		txtNumay.setEditable(false);
		txtNumay.setColumns(10);
		txtNumay.setBounds(373, 348, 129, 20);
		getContentPane().add(txtNumay);
		
		lblPrimax = new JLabel("PRIMAX:");
		lblPrimax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrimax.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrimax.setBounds(237, 388, 130, 23);
		getContentPane().add(lblPrimax);
		
		txtPrimax = new JTextField();
		txtPrimax.setEditable(false);
		txtPrimax.setColumns(10);
		txtPrimax.setBounds(373, 390, 129, 20);
		getContentPane().add(txtPrimax);
		//btnExportar.setEnabled(false);

	}
	
	private void mostrarReporteDescargas() {
	    String rutaArchivo = "datos/descargas.txt";
	    DefaultTableModel modelo = (DefaultTableModel) tablaReportes.getModel();
	    modelo.setRowCount(0); // Limpiar tabla

	    // Inicializar acumuladores
	    double totalPetroperu = 0, totalRepsol = 0, totalNumay = 0, totalPrimax = 0;

	    try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            String[] datos = linea.split(",");

	            // Ignorar líneas mal formateadas
	            if (datos.length != 4) {
	                System.err.println("Línea ignorada (formato inválido): " + linea);
	                continue;
	            }

	            String fecha = datos[0].trim();
	            String cantidadStr = datos[1].trim();
	            String proveedor = datos[2].trim().toUpperCase(); // Normalizar a mayúsculas
	            String recepciono = datos[3].trim();

	            double cantidad = 0;
	            try {
	                cantidad = Double.parseDouble(cantidadStr);
	            } catch (NumberFormatException ex) {
	                System.err.println("Cantidad inválida en línea: " + linea);
	                continue;
	            }

	            // Agregar a la tabla
	            modelo.addRow(new Object[]{fecha, cantidad, proveedor, recepciono});

	            // Acumular por proveedor
	            switch (proveedor) {
	                case "PETROPERÚ":
	                case "PETROPERU":
	                    totalPetroperu += cantidad;
	                    break;
	                case "REPSOL":
	                    totalRepsol += cantidad;
	                    break;
	                case "NUMAY":
	                    totalNumay += cantidad;
	                    break;
	                case "PRIMAX":
	                    totalPrimax += cantidad;
	                    break;
	                default:
	                    System.err.println("Proveedor desconocido: " + proveedor);
	            }
	        }

	        // Mostrar totales
	        txtPetroperu.setText(String.format("%.2f", totalPetroperu));
	        txtRepsol.setText(String.format("%.2f", totalRepsol));
	        txtNumay.setText(String.format("%.2f", totalNumay));
	        txtPrimax.setText(String.format("%.2f", totalPrimax));

	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(this,
	            "Error al leer el archivo:\n" + e.getMessage(),
	            "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExportar) {
			actionPerformedBtnExportar(e);
		}
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}
	//BOTON PARA VER REPORTE
	protected void actionPerformedBtnReporte(ActionEvent e) {
		mostrarReporteDescargas(); // nuevo método
		btnReporte.setEnabled(false);
		btnExportar.setEnabled(true);
		//reporteGenerado = true;

	}
	
	 protected void actionPerformedBtnExportar(ActionEvent e) {
		 if (!reporteGenerado) {
		        JOptionPane.showMessageDialog(this,
		            "Primero debe generar un reporte antes de exportar.",
		            "Atención", JOptionPane.WARNING_MESSAGE);
		        return;
		    }
		 javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
		    fileChooser.setDialogTitle("Guardar reporte como");
		    fileChooser.setSelectedFile(new java.io.File("ReporteDescargas.txt")); // nombre sugerido

		    int userSelection = fileChooser.showSaveDialog(this);

		    if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
		        java.io.File archivo = fileChooser.getSelectedFile();

		        try (java.io.PrintWriter writer = new java.io.PrintWriter(archivo, "UTF-8")) {

		            // Encabezados de la tabla
		            DefaultTableModel modelo = (DefaultTableModel) tablaReportes.getModel();
		            for (int i = 0; i < modelo.getColumnCount(); i++) {
		                writer.print(modelo.getColumnName(i));
		                if (i < modelo.getColumnCount() - 1) writer.print(" | ");
		            }
		            writer.println();
		            writer.println("------------------------------------------------------------");

		            // Filas de la tabla
		            for (int i = 0; i < modelo.getRowCount(); i++) {
		                for (int j = 0; j < modelo.getColumnCount(); j++) {
		                    writer.print(modelo.getValueAt(i, j));
		                    if (j < modelo.getColumnCount() - 1) writer.print(" | ");
		                }
		                writer.println();
		            }

		            // Totales por proveedor
		            writer.println();
		            writer.println("=== Totales por proveedor ===");
		            writer.println("PETROPERÚ : " + txtPetroperu.getText());
		            writer.println("REPSOL    : " + txtRepsol.getText());
		            writer.println("NUMAY     : " + txtNumay.getText());
		            writer.println("PRIMAX    : " + txtPrimax.getText());

		            writer.flush();

		            JOptionPane.showMessageDialog(this,
		                "Archivo guardado correctamente:\n" + archivo.getAbsolutePath(),
		                "Éxito", JOptionPane.INFORMATION_MESSAGE);

		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(this,
		                "Error al guardar archivo:\n" + ex.getMessage(),
		                "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
	}
}
