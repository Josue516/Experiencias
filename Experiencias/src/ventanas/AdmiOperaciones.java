package ventanas;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
<<<<<<< HEAD
import java.awt.Color;
=======
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee

public class AdmiOperaciones extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtOperacion;
	private JTextField txtRuta;
	private JTable tablaOperaciones;
	private JTable tablaRutas;
	private JButton btnAgregarOperacion;
	private JButton btnAgregarRuta;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnEliminar;
<<<<<<< HEAD
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
=======
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmiOperaciones dialog = new AdmiOperaciones();
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
	public AdmiOperaciones() {
<<<<<<< HEAD
		getContentPane().setBackground(new Color(255, 248, 220));
=======
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee
		setResizable(false);
		setTitle("ADMINISTRAR OPERACIONES Y RUTAS");
		setBounds(100, 100, 550, 380);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nueva Operación  :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 130, 21);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNuevaRuta = new JLabel("Nueva Ruta           :");
		lblNuevaRuta.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNuevaRuta.setBounds(10, 43, 130, 21);
		getContentPane().add(lblNuevaRuta);
		
		txtOperacion = new JTextField();
		txtOperacion.setEditable(false);
		txtOperacion.setBounds(150, 12, 140, 20);
		getContentPane().add(txtOperacion);
		txtOperacion.setColumns(10);
		
		//LOGO
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Logo.png")); // Ruta desde src
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);
		
		//PARA QUE EL TXT NO APAREZCA SELECCIONADO AUTOMATICAMENTE
		SwingUtilities.invokeLater(() -> {btnAgregarOperacion.requestFocusInWindow(); // Puedes cambiar por cualquier otro componente
		});
		
		txtRuta = new JTextField();
		txtRuta.setEditable(false);
		txtRuta.setColumns(10);
		txtRuta.setBounds(150, 44, 140, 20);
		getContentPane().add(txtRuta);
		
		btnAgregarOperacion = new JButton("Agregar Operación");
<<<<<<< HEAD
		btnAgregarOperacion.setBackground(new Color(100, 149, 237));
=======
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee
		btnAgregarOperacion.addActionListener(this);
		btnAgregarOperacion.setBounds(350, 11, 160, 23);
		getContentPane().add(btnAgregarOperacion);
		
		btnAgregarRuta = new JButton("Agregar Ruta");
<<<<<<< HEAD
		btnAgregarRuta.setBackground(new Color(100, 149, 237));
=======
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee
		btnAgregarRuta.addActionListener(this);
		btnAgregarRuta.setBounds(350, 43, 160, 23);
		getContentPane().add(btnAgregarRuta);
		
		btnEliminar = new JButton("Eliminar");
<<<<<<< HEAD
		btnEliminar.setBackground(new Color(240, 128, 128));
=======
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(350, 77, 160, 23);
		getContentPane().add(btnEliminar);
		
		btnAceptar = new JButton("Aceptar");
<<<<<<< HEAD
		btnAceptar.setBackground(new Color(100, 149, 237));
=======
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(40, 90, 89, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
<<<<<<< HEAD
		btnCancelar.setBackground(new Color(240, 128, 128));
=======
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(150, 90, 89, 23);
		getContentPane().add(btnCancelar);
		
<<<<<<< HEAD
		scrollPane = new JScrollPane();
=======
		JScrollPane scrollPane = new JScrollPane();
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee
		scrollPane.setBounds(40, 150, 220, 180);
		getContentPane().add(scrollPane);
		
		//PARA QUE LOS JTABLE NO SEAN EDITABLES
		tablaOperaciones = new JTable();
<<<<<<< HEAD
		tablaOperaciones.setBackground(new Color(240, 230, 140));
=======
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee
		tablaOperaciones.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"OPERACIONES CREADAS"}) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {false};
			public boolean isCellEditable(int row, int column) {return columnEditables[column];}});
		scrollPane.setViewportView(tablaOperaciones);
		
<<<<<<< HEAD
		scrollPane_1 = new JScrollPane();
=======
		JScrollPane scrollPane_1 = new JScrollPane();
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee
		scrollPane_1.setBounds(304, 150, 220, 180);
		getContentPane().add(scrollPane_1);
		
		tablaRutas = new JTable();
<<<<<<< HEAD
		tablaRutas.setBackground(new Color(240, 230, 140));
=======
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee
		tablaRutas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"RUTAS CREADAS"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(tablaRutas);
		
		JLabel lblNewLabel_1 = new JLabel("Lista de Operaciones");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(70, 124, 154, 21);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Lista de Rutas");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(340, 124, 154, 21);
		getContentPane().add(lblNewLabel_1_1);
		
		cargarOpcionesDesdeArchivo("datos/Operaciones.txt", tablaOperaciones);
		cargarOpcionesDesdeArchivo("datos/Rutas.txt", tablaRutas);
	}
	private void cargarOpcionesDesdeArchivo(String ruta, JTable tabla) {
	    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
	    try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
	        String linea;
	        while ((linea = br.readLine()) != null) {
	        	String[] datos = linea.split(",");
	        	if (datos.length == 1) {
	        	modelo.addRow(datos);
	            }
	        }
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Error al leer Operaciones.txt: " + e.getMessage());}
	    }
	    
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnAgregarRuta) {
			actionPerformedBtnAgregarRuta(e);
		}
		if (e.getSource() == btnAgregarOperacion) {
			actionPerformedBtnAgregarOperacion(e);
		}
	}
	//BOTON PARA AGREGAR OPERACION
	protected void actionPerformedBtnAgregarOperacion(ActionEvent e) {
		 txtOperacion.setEditable(true);//PARA QUE EL CAMPO SE VUELVA EDITABLE
	     txtOperacion.requestFocus();//PARA QUE SE SELECCIONE EL CAMPO TXT
	     txtRuta.setEditable(false);
	     txtRuta.setText("");
	}
	protected void actionPerformedBtnAgregarRuta(ActionEvent e) {
		 txtRuta.setEditable(true);//PARA QUE EL CAMPO SE VUELVA EDITABLE
	     txtRuta.requestFocus();//PARA QUE SE SELECCIONE EL CAMPO TXT
	     txtOperacion.setEditable(false);
	     txtOperacion.setText("");
	}
	//METODO PARA ACTUALIZAR LOR JTABLE
	private void cargarRutasEnTabla(JTable tabla, String ruta) {
	    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
	    modelo.setRowCount(0); // Limpia la tabla antes de cargar

	    try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            modelo.addRow(new Object[]{linea.trim()});
	        }
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, "Error al leer Documento txt: " + e.getMessage());
	    }
	}
	//PATRON DE VALIDACION
	private boolean esTextoValido(String texto) {
	    return texto.matches("^[A-ZÁÉÍÓÚÑ ]+$");
	}
	//BOTON ACEPTAR
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		 if (txtRuta.isEditable()) {
	            String nuevaRuta = txtRuta.getText().trim().toUpperCase();
	            if (!nuevaRuta.isEmpty()) {
	                txtRuta.setText("");
	                txtRuta.setEditable(false);
	            }else {
		            JOptionPane.showMessageDialog(this, "El campo de Ruta está vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		            return;
	            }if (!esTextoValido(nuevaRuta)) {
	                JOptionPane.showMessageDialog(this, "Texto Invalido.", "Entrada inválida", JOptionPane.ERROR_MESSAGE);
	                return;
	            } 
	            
	            guardarEnArchivo("datos/Rutas.txt", nuevaRuta);
	            JOptionPane.showMessageDialog(this, "Ruta guardada con éxito.");
	            cargarRutasEnTabla(tablaRutas, "datos/Rutas.txt");
	        }

	        if (txtOperacion.isEditable()) {
	            String nuevaOperacion = txtOperacion.getText().trim().toUpperCase();
	            if (!nuevaOperacion.isEmpty()) {
	                txtOperacion.setText("");
	                txtOperacion.setEditable(false);
	            }else {
		                JOptionPane.showMessageDialog(this, "El campo de Operación está vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		                return;
	            }if (!esTextoValido(nuevaOperacion)) {
	                JOptionPane.showMessageDialog(this, "Texto Invalido.", "Entrada inválida", JOptionPane.ERROR_MESSAGE);
	                return; 
	            }
	            
	            guardarEnArchivo("datos/Operaciones.txt", nuevaOperacion);
	            JOptionPane.showMessageDialog(this, "Operación guardada con éxito.");
	            cargarRutasEnTabla(tablaOperaciones, "datos/Operaciones.txt");
	        }
	    }
	private void guardarEnArchivo(String rutaArchivo, String linea) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
			bw.write(linea);
			bw.newLine();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, "Error al guardar en " + rutaArchivo + ": " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	//BOTON CANCELAR
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		txtRuta.setEditable(false);
		txtOperacion.setEditable(false);
		txtRuta.setText("");
		txtOperacion.setText("");
	}
	//METODO PARA ELIMINAR LA FILA SELECCIONADA
	private void eliminarFilaSeleccionada(JTable tabla, String rutaArchivo) {
	    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
	    int filaSeleccionada = tabla.getSelectedRow();

	    if (filaSeleccionada != -1) {
	        modelo.removeRow(filaSeleccionada);  // Elimina de la tabla

	        // Guardar el nuevo contenido en el archivo
	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
	            for (int i = 0; i < modelo.getRowCount(); i++) {
	                bw.write(modelo.getValueAt(i, 0).toString());
	                bw.newLine();
	            }
	            JOptionPane.showMessageDialog(this, "Eliminado Exitosamente.");
	        } catch (IOException ex) {
	            JOptionPane.showMessageDialog(this, "Error al guardar cambios: " + ex.getMessage());
	        }
	    }
	}
	//BOTON PARA ELIMINAR
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int filaRutas = tablaRutas.getSelectedRow();
        int filaOperaciones = tablaOperaciones.getSelectedRow();

        if (filaRutas != -1) {
            eliminarFilaSeleccionada(tablaRutas, "datos/Rutas.txt");
        } else if (filaOperaciones != -1) {
            eliminarFilaSeleccionada(tablaOperaciones, "datos/Operaciones.txt");
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
	}
}
