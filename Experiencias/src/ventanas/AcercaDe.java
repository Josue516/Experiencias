package ventanas;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AcercaDe extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea txt;
    private JLabel iconLabel;
    private JPanel bottom;

    public static void main(String[] args) {
        try {
            AcercaDe dialog = new AcercaDe();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AcercaDe() {
    	setBackground(new Color(255, 248, 220));
        setTitle("Acerca de SIPROC");
        setSize(520, 436);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);

        // Icono de la ventana
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Logo.png"));
        setIconImage(icon.getImage());

        // Panel principal
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(255, 248, 220));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(panel);

        // Encabezado con logo + título
        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT));
        header.setBackground(new Color(255, 248, 220));
        iconLabel = new JLabel(new ImageIcon(getClass().getResource("/imagenes/LogoCarranza.png")));
        iconLabel.setHorizontalAlignment(SwingConstants.LEADING);
        header.add(iconLabel);
        panel.add(header, BorderLayout.NORTH);

        // Área de texto con scroll
        txt = new JTextArea();
        txt.setForeground(new Color(0, 0, 0));
        txt.setEditable(false);
        txt.setBackground(new Color(240, 230, 140));
        txt.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txt.setLineWrap(true);
        txt.setWrapStyleWord(true);
        txt.setText(
            "SISTEMA DE CONTROL DE COMBUSTIBLE - SIPROC\n" +
            "Versión: 1.0.0\n" +
            "Fecha de desarrollo: Julio 2025\n\n" +
            "Descripción del Proyecto:\n" +
            "Sistema desarrollado para registrar, administrar y visualizar operaciones\n" +
            "relacionadas al consumo y abastecimiento de combustible en flotas de transporte de carga pesada.\n\n" +
            "Permite un control eficiente del stock, descargas de combustible y consumo proyectado.\n\n" +
            "Características principales:\n" +
            "- Registro de operaciones por unidad, ruta y galonaje.\n" +
            "- Control del stock inicial y descargas de combustible programadas.\n" +
            "- Reportes detallados por operación y proveedor.\n" +
            "- Exportación de reportes a archivos de texto y Excel.\n" +
            "- Cálculo de diesel requerido y disponible.\n" +
            "- Ventana de resumen por ruta/destino.\n\n" +
            "Desarrollado por:\n" +
            "• JOSUE MEDINA PACHAS\n" +
            "• YANCARLOS CALDERON ESPINOLA\n" +
            "Curso: EFSRT I\n" +
            "Ciclo: 2° ciclo\n" +
            "Carrera: Computación e Informática\n" +
            "Institución: Cibertec – Perú"
        );

        JScrollPane scrollPane = new JScrollPane(txt);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panel.add(scrollPane, BorderLayout.CENTER);

        // Botón cerrar
        bottom = new JPanel();
        bottom.setBackground(new Color(255, 248, 220));
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBackground(new Color(240, 128, 128));
        btnCerrar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        btnCerrar.addActionListener(e -> dispose());
        bottom.add(btnCerrar);
        panel.add(bottom, BorderLayout.SOUTH);
    }
}
