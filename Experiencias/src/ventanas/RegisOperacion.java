package ventanas;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RegisOperacion extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable tablaOperaciones;

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
		setBounds(100, 100, 580, 400);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Operacion   :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 21, 100, 25);
		getContentPane().add(lblNewLabel);
		
		JLabel lblRuta = new JLabel("Ruta            :");
		lblRuta.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRuta.setBounds(10, 56, 100, 25);
		getContentPane().add(lblRuta);
		
		JComboBox<String> cboRutas = new JComboBox<String>();
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(110, 95, 130, 20);
		getContentPane().add(textField);
		
		
		
		JLabel lblGlunidad = new JLabel("GL/Unidad   :");
		lblGlunidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGlunidad.setBounds(10, 129, 100, 25);
		getContentPane().add(lblGlunidad);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 132, 130, 20);
		getContentPane().add(textField_1);
		
		JComboBox<String> cboRutas_1 = new JComboBox<String>();
		cboRutas_1.setBounds(110, 23, 130, 22);
		getContentPane().add(cboRutas_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 180, 544, 170);
		getContentPane().add(scrollPane);
		
		tablaOperaciones = new JTable();
		scrollPane.setViewportView(tablaOperaciones);
		
		JButton btnNewButton = new JButton("Añadir operación");
		btnNewButton.setBounds(379, 23, 140, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnEliminarOperacin = new JButton("Eliminar operación");
		btnEliminarOperacin.setBounds(379, 69, 140, 25);
		getContentPane().add(btnEliminarOperacin);

	}
}
