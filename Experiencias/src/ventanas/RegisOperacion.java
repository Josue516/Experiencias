package ventanas;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class RegisOperacion extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtUnidades;
	private JTextField txtGalonesPorUnidad;
	private JTable tablaOperaciones;
	private JComboBox<String> cboRutas;
	private JButton btnAñadir;
	private JButton btnEliminarOperacion;
	private JComboBox<String> cboOperacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisOperacion dialog = new RegisOperacion();
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
	public RegisOperacion() {
		setTitle("REGISTRAR OPERACIONES");
		setBounds(100, 100, 630, 400);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Operacion   :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 21, 100, 25);
		getContentPane().add(lblNewLabel);
		
		JLabel lblRuta = new JLabel("Ruta            :");
		lblRuta.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRuta.setBounds(10, 56, 100, 25);
		getContentPane().add(lblRuta);
		
		cboRutas = new JComboBox<String>();
		cboRutas.addActionListener(this);
		cboRutas.setBounds(110, 57, 130, 22);
		getContentPane().add(cboRutas);
		
		//LOGO
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Logo.png")); // Ruta desde src
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);
		
		JLabel lblUnidades = new JLabel("Unidades     :");
		lblUnidades.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUnidades.setBounds(10, 92, 100, 25);
		getContentPane().add(lblUnidades);
		
		txtUnidades = new JTextField();
		txtUnidades.setColumns(10);
		txtUnidades.setBounds(110, 95, 130, 20);
		getContentPane().add(txtUnidades);
		
		
		
		JLabel lblGlunidad = new JLabel("GL/Unidad   :");
		lblGlunidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGlunidad.setBounds(10, 129, 100, 25);
		getContentPane().add(lblGlunidad);
		
		txtGalonesPorUnidad = new JTextField();
		txtGalonesPorUnidad.setColumns(10);
		txtGalonesPorUnidad.setBounds(110, 132, 130, 20);
		getContentPane().add(txtGalonesPorUnidad);
		
		cboOperacion = new JComboBox<String>();
		cboOperacion.addActionListener(this);
		cboOperacion.setBounds(110, 23, 130, 22);
		getContentPane().add(cboOperacion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 180, 594, 170);
		getContentPane().add(scrollPane);
		
		//LOS JTABLE YA NO SERAN EDITABLES
		tablaOperaciones = new JTable();
		tablaOperaciones.setModel(new DefaultTableModel(new Object[][] {},
		new String[] {"OPERACI\u00D3N", "UNIDADES", "RUTAS", "GL/UNIDAD", "GALONES TOTALES"}) {
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
		scrollPane.setViewportView(tablaOperaciones);
		
		btnAñadir = new JButton("Añadir operación");
		btnAñadir.addActionListener(this);
		btnAñadir.setBounds(449, 21, 140, 25);
		getContentPane().add(btnAñadir);
		
		btnEliminarOperacion = new JButton("Eliminar operación");
		btnEliminarOperacion.addActionListener(this);
		btnEliminarOperacion.setBounds(449, 67, 140, 25);
		getContentPane().add(btnEliminarOperacion);
		
		//CODIGO PARA QUE LOS DATOS DE LOS TXT SEAN LEIDOS POR LOS COMBOBOX
		cargarOperacionesDesdeArchivo();
		cargarOpcionesDesdeRecurso("datos/Rutas.txt", cboRutas);
		cargarOpcionesDesdeRecurso("datos/Operaciones.txt", cboOperacion);
	}
	//METODO PARA QUE LO QUE ESTE ESCRITO EN LOS TXT SEA BUSCADO Y LEIDO CORRECTAMENTE
	private void cargarOpcionesDesdeRecurso(String ruta, JComboBox<String> combo) {
        try (BufferedReader br = new BufferedReader(
                new FileReader((ruta)))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                combo.addItem(linea.trim());
            }

        } catch (IOException | NullPointerException e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar el archivo: " + ruta,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminarOperacion) {
			actionPerformedBtnEliminarOperacion(e);
		}
		if (e.getSource() == btnAñadir) {
			actionPerformedBtnAñadir(e);
		}
	}
	//BOTON AÑADIR
	protected void actionPerformedBtnAñadir(ActionEvent e) {
		agregarFilaTabla();
		guardarOperacionesEnArchivo();
	}
	//METODO PARA AGREGAR FILAS A LA TABLA
	private void agregarFilaTabla() {
	    try {
	        String ruta = (String) cboRutas.getSelectedItem();
	        String operacion = (String) cboOperacion.getSelectedItem();

	        int unidades = Integer.parseInt(txtUnidades.getText().trim());
	        double galonesUnidad = Double.parseDouble(txtGalonesPorUnidad.getText().trim());
	        double totalGalones = unidades * galonesUnidad;
	        //VALIDACION DE NUMEROS NEGATIVOS
	        if (unidades <= 0) {
	        	JOptionPane.showMessageDialog(this, "Las unidades deben ser mayores a 0.", "Valor inválido", JOptionPane.WARNING_MESSAGE);
                return;
	        }
	        if (galonesUnidad <= 0) {
                JOptionPane.showMessageDialog(this, "Los galones por unidad deben ser mayores a 0.", "Valor inválido", JOptionPane.WARNING_MESSAGE);
                return;
            }
	        DefaultTableModel modelo = (DefaultTableModel) tablaOperaciones.getModel();
	        Object[] fila = {operacion, ruta, unidades, galonesUnidad, totalGalones};
	        modelo.addRow(fila);
	        JOptionPane.showMessageDialog(this, "Operación agregada con exito.",
	                "Confirmación", JOptionPane.INFORMATION_MESSAGE);
	        // LIMPIAR LOS TXT LUEGO DE AGREGAR LA FILA
	        txtUnidades.setText("");
	        txtGalonesPorUnidad.setText("");
	        cboRutas.setSelectedIndex(0);
	        cboOperacion.setSelectedIndex(0);
	        txtUnidades.requestFocus();

	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Por favor ingresa números válidos para unidades y galones.",
	                "Error de formato", JOptionPane.ERROR_MESSAGE);
	    }
	}
	private void cargarOperacionesDesdeArchivo() {
	    DefaultTableModel modelo = (DefaultTableModel) tablaOperaciones.getModel();
	    try (BufferedReader br = new BufferedReader(new FileReader("datos/OperacionesProgramadas.txt"))) {
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            String[] datos = linea.split(",");
	            if (datos.length == 5) {
	                modelo.addRow(datos);
	            }
	        }
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Error al leer Operaciones.txt: " + e.getMessage());
	    }
	}
	//METODO PARA GUARDAR OPERACIONES EN ARCHIVO
	private void guardarOperacionesEnArchivo() {
	    DefaultTableModel modelo = (DefaultTableModel) tablaOperaciones.getModel();
	    try (PrintWriter pw = new PrintWriter(new FileWriter("datos/OperacionesProgramadas.txt", false))) {
	        for (int i = 0; i < modelo.getRowCount(); i++) {
	            StringBuilder linea = new StringBuilder();
	            for (int j = 0; j < modelo.getColumnCount(); j++) {
	                linea.append(modelo.getValueAt(i, j));
	                if (j < modelo.getColumnCount() - 1)
	                    linea.append(",");
	            }
	            pw.println(linea.toString());
	        }
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Error al guardar en Operaciones.txt: " + e.getMessage());
	    }
	}
	//BOTON PARA ELIMINAR OPERACION
	protected void actionPerformedBtnEliminarOperacion(ActionEvent e) {
		eliminarFilaSeleccionada();
		guardarOperacionesEnArchivo();
	}
	//METODO PARA ELIMINAR FILAS SELECCIONADAS
	private void eliminarFilaSeleccionada() {
	    int fila = tablaOperaciones.getSelectedRow(); // obtiene el índice de la fila seleccionada
	    if (fila != -1) { // si hay una fila seleccionada
	        int confirmacion = JOptionPane.showConfirmDialog(
	            this,
	            "¿Estás seguro de que deseas eliminar esta operación?",
	            "Confirmar eliminación",
	            JOptionPane.YES_NO_OPTION
	        );
	        if (confirmacion == JOptionPane.YES_OPTION) {
	            DefaultTableModel modelo = (DefaultTableModel) tablaOperaciones.getModel();
	            modelo.removeRow(fila); // elimina la fila
	            JOptionPane.showMessageDialog(this, "Operación eliminada con exito.",
		                "Confirmación", JOptionPane.INFORMATION_MESSAGE);
	        }
	    } else {
	        JOptionPane.showMessageDialog(
	            this,
	            "Por favor, selecciona una fila para eliminar.",
	            "Ninguna fila seleccionada",
	            JOptionPane.WARNING_MESSAGE
	        );
	    }
	}
}
