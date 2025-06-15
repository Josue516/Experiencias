package ventanas;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class AdmiOperaciones extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable tablaOperaciones;
	private JTable tablaRutas;

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
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(150, 12, 140, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(150, 44, 140, 20);
		getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("Agregar Operación");
		btnNewButton.setBounds(350, 11, 160, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnAgregarOperacin = new JButton("Agregar Ruta");
		btnAgregarOperacin.setBounds(350, 43, 160, 23);
		getContentPane().add(btnAgregarOperacin);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(350, 77, 160, 23);
		getContentPane().add(btnEliminar);
		
		JButton btnNewButton_1 = new JButton("Aceptar");
		btnNewButton_1.setBounds(40, 90, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Cancelar");
		btnNewButton_1_1.setBounds(150, 90, 89, 23);
		getContentPane().add(btnNewButton_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 150, 220, 180);
		getContentPane().add(scrollPane);
		
		tablaOperaciones = new JTable();
		scrollPane.setViewportView(tablaOperaciones);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(304, 150, 220, 180);
		getContentPane().add(scrollPane_1);
		
		tablaRutas = new JTable();
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

	}
}
