package ventanas;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class ActualizarStock extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtGasolina;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActualizarStock dialog = new ActualizarStock();
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
	public ActualizarStock() {
		setTitle("ACTUALIZAR STOCK");
		setBounds(100, 100, 440, 150);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Actualizar Gasolina :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 25, 149, 25);
		getContentPane().add(lblNewLabel);
		
		//LOGO
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Logo.png")); // Ruta desde src
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);
		
		txtGasolina = new JTextField();
		txtGasolina.setBounds(179, 29, 130, 20);
		getContentPane().add(txtGasolina);
		txtGasolina.setColumns(10);
		txtGasolina.setText(Principal.Galones+"");
		
		JLabel lblGl = new JLabel("GL.");
		lblGl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGl.setBounds(313, 25, 31, 25);
		getContentPane().add(lblGl);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(221, 61, 100, 23);
		getContentPane().add(btnCancelar);
		
		btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(90, 62, 100, 23);
		getContentPane().add(btnNewButton);
		//PARA QUE EL TXT NO APAREZCA SELECCIONADO AUTOMATICAMENTE
		SwingUtilities.invokeLater(() -> {btnNewButton.requestFocusInWindow(); // Puedes cambiar por cualquier otro componente
		});
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	//METODO PARA GUARDAR LOS DATOS CAMBIADOS
	private void guardarDato(int gasolina) {
		Principal.Galones=gasolina;
	}
	//PATRON PARA EVITAR QUE INTRODUZCAN PALABRAS Y SIMBOLOS
	private static final Pattern NUM_PATTERN = Pattern.compile("^[0-9]+(\\.[0-9]+)?$");
	private JButton btnCancelar;
	//MENSAJE QUE APARECE EN CASO DE ERROR
	private void mostrarError(String msg) {
	    JOptionPane.showMessageDialog(this, msg, "Error de formato", JOptionPane.ERROR_MESSAGE);
		}
	//MENSAJE DE ADVERTENCIA
	private void mostrarAdventencia(String msg) {
	    JOptionPane.showMessageDialog(this, msg, "Valor invalido", JOptionPane.WARNING_MESSAGE);
	}
	//BOTON GUARDAR
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		String galones = txtGasolina.getText().trim();
		if (!NUM_PATTERN.matcher(galones).matches()) {
			mostrarError("Debe ingresar un numero valido.");
			return;
		}
		int gasolina = Integer.parseInt(galones);
		if (gasolina <= 0) {
        	//Si el numero es igual o menor a cero se muestra el siguiente mensaje
            mostrarAdventencia("El campo debe ser mayor que 0.");
            return;//DETIENE LA EJECUCION DEL CODIGO Y NO SE GUARDA NADA
        }
		guardarDato(gasolina);
		JOptionPane.showMessageDialog(this,
		        "Datos guardados correctamente.",
		        "Ventana correcta",
		        JOptionPane.INFORMATION_MESSAGE);
		dispose();
	}
	//BOTON CANCELAR
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
}
