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
<<<<<<< HEAD
import javax.swing.SwingConstants;
import java.awt.Color;
=======
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee

public class ConsulStock extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	private JTextField txtDiesel;
	private JButton btnCerrar;
	private JLabel lblDiesel;
	private JLabel lblGl;
	private JLabel lblNewLabel;
=======
	private JTextField txtGasolina;
	private JButton btnNewButton;
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee

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
<<<<<<< HEAD
		getContentPane().setBackground(new Color(255, 248, 220));
=======
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee
		setTitle("CONSULTA STOCK");
		setBounds(100, 100, 440, 150);
		getContentPane().setLayout(null);
		
<<<<<<< HEAD
		lblDiesel = new JLabel("Diesel total  :");
		lblDiesel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiesel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDiesel.setBounds(60, 21, 120, 30);
		getContentPane().add(lblDiesel);
=======
		JLabel lblNewLabel = new JLabel("Gasolina total  :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(31, 21, 120, 30);
		getContentPane().add(lblNewLabel);
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee
		
		//LOGO
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Logo.png")); // Ruta desde src
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);
		
<<<<<<< HEAD
		txtDiesel = new JTextField();
		txtDiesel.setForeground(new Color(0, 0, 255));
		txtDiesel.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDiesel.setEditable(false);
		txtDiesel.setBounds(190, 28, 140, 20);
		getContentPane().add(txtDiesel);
		txtDiesel.setColumns(10);
		txtDiesel.setText(""+Principal.Galones);
		
		lblGl = new JLabel("GL.");
		lblGl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGl.setBounds(331, 21, 23, 30);
		getContentPane().add(lblGl);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(new Color(100, 149, 237));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(190, 61, 89, 23);
		getContentPane().add(btnCerrar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ConsulStock.class.getResource("/imagenes/logoTrc.png")));
		lblNewLabel.setBounds(10, 28, 79, 72);
		getContentPane().add(lblNewLabel);
		
		//PARA QUE NO APAREZCA SELECCIONADO en txt
		SwingUtilities.invokeLater(() -> {btnCerrar.requestFocusInWindow(); // Puedes cambiar por cualquier otro componente
=======
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
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee
		});

	}
	public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
		if (e.getSource() == btnCerrar) {
=======
		if (e.getSource() == btnNewButton) {
>>>>>>> 3034b0f12cb9d979ab48b15a158b44575bc7c6ee
			actionPerformedBtnNewButton(e);
		}
	}
	//BOTON CERRAR
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		dispose();
	}
}
