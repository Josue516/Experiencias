package ventanas;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsulStock extends JDialog implements ActionListener {

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
					ConsulStock dialog = new ConsulStock();
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
	public ConsulStock() {
		setTitle("CONSULTA STOCK");
		setBounds(100, 100, 440, 150);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gasolina total  :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(31, 21, 120, 30);
		getContentPane().add(lblNewLabel);
		
		//LOGO
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Logo.png")); // Ruta desde src
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);
		
		txtGasolina = new JTextField();
		txtGasolina.setEditable(false);
		txtGasolina.setBounds(161, 28, 140, 20);
		getContentPane().add(txtGasolina);
		txtGasolina.setColumns(10);
		txtGasolina.setText(""+Principal.Galones);
		
		JLabel lblGl = new JLabel("GL.");
		lblGl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGl.setBounds(302, 21, 23, 30);
		getContentPane().add(lblGl);
		
		btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(160, 59, 89, 23);
		getContentPane().add(btnNewButton);
		
		//PARA QUE NO APAREZCA SELECCIONADO en txt
		SwingUtilities.invokeLater(() -> {btnNewButton.requestFocusInWindow(); // Puedes cambiar por cualquier otro componente
		});

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	//BOTON CERRAR
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		dispose();
	}
}
