package ventanas;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class TablaResumen extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablaResumen;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TablaResumen dialog = new TablaResumen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TablaResumen() {
		getContentPane().setBackground(new Color(255, 248, 220));
		setTitle("Resumen por Ruta");
		setSize(288, 288);
		setLocationRelativeTo(null);
		setModal(false);
		getContentPane().setLayout(new BorderLayout());

		tablaResumen = new JTable();
		tablaResumen.setBackground(new Color(224, 255, 255));
		scrollPane = new JScrollPane(tablaResumen);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		cargarResumenPorRuta();

	}
	
	private void cargarResumenPorRuta() {
		 DefaultTableModel modelo = new DefaultTableModel(new Object[]{"DESTINO", "GALONAJE"}, 0);

		    try (BufferedReader br = new BufferedReader(new FileReader("datos/tabla.txt"))) {
		        String linea;

		        while ((linea = br.readLine()) != null) {
		            String[] datos = linea.split(",");
		            if (datos.length == 2) {
		                String destino = datos[0].trim();
		                double galonaje = Double.parseDouble(datos[1].trim());
		                modelo.addRow(new Object[]{destino, String.format("%.2f", galonaje)});
		            }
		        }

		        tablaResumen.setModel(modelo);

		    } catch (IOException | NumberFormatException e) {
		        JOptionPane.showMessageDialog(this, "Error al cargar resumen: " + e.getMessage(),
		                "Error", JOptionPane.ERROR_MESSAGE);
		    }
	}

}
