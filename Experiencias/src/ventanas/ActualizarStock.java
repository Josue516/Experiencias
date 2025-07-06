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
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class ActualizarStock extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JButton btnActualizar;
	private JButton btnCerrar;
	private JTextField txtTotal;
	private JTextField txtStockInicial;
	private JTextField txtRecepcionado;
	private JComboBox<String> cboDescarga;
	private JComboBox<String> cboProveedor;

	private JLabel lblGl_1;
	private JLabel lblTotal;
	private JLabel lblDescargaProgramada;
	private JLabel lblGl_2;
	private JLabel lblStockInicial;
	private JLabel lblGl;

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
		setResizable(false);
		getContentPane().setBackground(new Color(255, 248, 220));
		setTitle("ACTUALIZAR STOCK");
		setBounds(100, 100, 517, 289);
		getContentPane().setLayout(null);
		
		//LOGO
		ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Logo.png")); // Ruta desde src
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);
		
		lblStockInicial = new JLabel("Stock Inicial :");
		lblStockInicial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStockInicial.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStockInicial.setBounds(10, 11, 117, 25);
		getContentPane().add(lblStockInicial);
		
		txtStockInicial = new JTextField();
		txtStockInicial.setForeground(new Color(0, 0, 255));
		txtStockInicial.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtStockInicial.setEditable(false);
		txtStockInicial.setBounds(137, 15, 130, 20);
		getContentPane().add(txtStockInicial);
		txtStockInicial.setColumns(10);
		txtStockInicial.setText(Principal.Galones+"");
		
		lblGl = new JLabel("GL.");
		lblGl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGl.setBounds(271, 11, 31, 25);
		getContentPane().add(lblGl);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(new Color(240, 128, 128));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(248, 144, 100, 23);
		getContentPane().add(btnCerrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(new Color(100, 149, 237));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(100, 144, 100, 23);
		getContentPane().add(btnActualizar);
		
		lblDescargaProgramada = new JLabel("Descarga :");
		lblDescargaProgramada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescargaProgramada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescargaProgramada.setBounds(10, 47, 117, 25);
		getContentPane().add(lblDescargaProgramada);
		
		cboDescarga = new JComboBox<>();
		cboDescarga.setFont(new Font("Tahoma", Font.BOLD, 11));
		cboDescarga.setForeground(new Color(34, 139, 34));
		cboDescarga.setBounds(137, 51, 130, 22);
		cboDescarga.addItem("0");
		cboDescarga.addItem("500");
		cboDescarga.addItem("1000");
		cboDescarga.addItem("3000");
		cboDescarga.addItem("5000");
		cboDescarga.addItem("7000");
		cboDescarga.addItem("9000");
		getContentPane().add(cboDescarga);
		
		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setHorizontalAlignment(SwingConstants.LEFT);
		lblProveedor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProveedor.setBounds(339, 11, 117, 25);
		getContentPane().add(lblProveedor);

		cboProveedor = new JComboBox<>();
		cboProveedor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboProveedor.setBounds(339, 37, 130, 22);
		cboProveedor.addItem("PETROPERÚ");
		cboProveedor.addItem("REPSOL");
		cboProveedor.addItem("NUMAY");
		cboProveedor.addItem("PRIMAX");
		getContentPane().add(cboProveedor);

		JLabel lblRecepcion = new JLabel("Recepcionado :");
		lblRecepcion.setHorizontalAlignment(SwingConstants.LEFT);
		lblRecepcion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRecepcion.setBounds(339, 70, 130, 25);
		getContentPane().add(lblRecepcion);

		txtRecepcionado = new JTextField();
		txtRecepcionado.setBounds(339, 98, 130, 20);
		getContentPane().add(txtRecepcionado);
		txtRecepcionado.setColumns(10);
		
		lblGl_1 = new JLabel("GL.");
		lblGl_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGl_1.setBounds(271, 47, 31, 25);
		getContentPane().add(lblGl_1);
		
		lblTotal = new JLabel("TOTAL :");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotal.setBounds(20, 93, 107, 25);
		getContentPane().add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setForeground(new Color(0, 0, 0));
		txtTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTotal.setText("3000.00");
		txtTotal.setColumns(10);
		txtTotal.setBounds(137, 97, 130, 20);
		getContentPane().add(txtTotal);
		txtTotal.setText(""+Principal.Galones);
		
		lblGl_2 = new JLabel("GL.");
		lblGl_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGl_2.setBounds(271, 93, 31, 25);
		getContentPane().add(lblGl_2);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ActualizarStock.class.getResource("/imagenes/logoTrc.png")));
		lblNewLabel.setBounds(203, 178, 76, 72);
		getContentPane().add(lblNewLabel);
		
		//PARA QUE EL TXT NO APAREZCA SELECCIONADO AUTOMATICAMENTE
		SwingUtilities.invokeLater(() -> {btnActualizar.requestFocusInWindow(); // Puedes cambiar por cualquier otro componente
		});
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
	}
	//METODO PARA GUARDAR LOS DATOS CAMBIADOS
	private void guardarDato(double diesel) {
		Principal.Galones=diesel;
	}
	private JLabel lblNewLabel;

	//MENSAJE QUE APARECE EN CASO DE ERROR
	private void mostrarError(String msg) {
	    JOptionPane.showMessageDialog(this, msg, "Error de formato", JOptionPane.ERROR_MESSAGE);
		}
	//MENSAJE DE ADVERTENCIA
	private void mostrarAdventencia(String msg) {
	    JOptionPane.showMessageDialog(this, msg, "Valor invalido", JOptionPane.WARNING_MESSAGE);
	}
	//METODO PARA OBTENER INDEX CBODESCARGA
	private int indexCbo() {
		return (Integer) cboDescarga.getSelectedIndex();
	}
	//PATRON PARA TXTRECEPCIONADO
	private static final Pattern NOMBRE_PATTERN = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$");
	//BOTON GUARDAR
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		String descarga = (String) cboDescarga.getSelectedItem();
		int cantidad = indexCbo();
		if (cantidad == 0) {
			 JOptionPane.showMessageDialog(this, "La cantidad no puede ser 0.");
			 return;
		}
		
		double galonesStock=0;
		double galonesDescarga = Double.parseDouble(descarga);
		double totalActual = Double.parseDouble(txtTotal.getText().trim());
		if (galonesStock < 0) {
			mostrarAdventencia("El stock inicial no puede ser negativo.");
			return;
		}else {
			galonesStock = totalActual;
		}
		
		double total = galonesStock + galonesDescarga;
		
		
		String proveedor = (String) cboProveedor.getSelectedItem();
		String recepcionado = txtRecepcionado.getText().trim().toUpperCase();
		
		if (recepcionado.isEmpty()) {
			mostrarAdventencia("Debe ingresar el nombre de quien recepcionó.");
			return;
		}
		if (!NOMBRE_PATTERN.matcher(recepcionado).matches()) {
		    mostrarError("El nombre solo puede contener letras y espacios.");
		    return;
		}
		guardarDato(total);
		guardarDescargaEnArchivo(galonesDescarga, proveedor, recepcionado);
		txtTotal.setText(String.format("%.2f", total));
		JOptionPane.showMessageDialog(this,"Stock actualizado correctamente.","Confirmación",JOptionPane.INFORMATION_MESSAGE);
	}
	
	//BOTON CANCELAR
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	private void guardarDescargaEnArchivo(double cantidad, String proveedor, String recepcionado) {
	    // Formatear la fecha al formato dd/MM/yyyy
	    java.time.LocalDate fechaActual = java.time.LocalDate.now();
	    java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String fecha = fechaActual.format(formatter);
	    // Formatear el número para evitar decimales innecesarios
	    String cantidadStr;
	    if (cantidad == (int) cantidad) {
	        cantidadStr = String.valueOf((int) cantidad); // Sin decimales si es entero
	    } else {
	        cantidadStr = String.valueOf(cantidad); // Con decimales si los tiene
	    }
	    String linea = fecha + "," + cantidadStr + "," + proveedor + "," + recepcionado;
	    try (java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter("datos/descargas.txt", true))) {
	        pw.println(linea);
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(this, "No se pudo guardar el registro de descarga.");
	    }
	}
}
