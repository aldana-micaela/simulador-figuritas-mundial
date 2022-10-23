package interfaz;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JProgressBar;

public class Simulador {

	private JFrame frame;
	private JPanel panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Simulador window = new Simulador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Simulador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 873, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		crearPanel();
	}
	
	private void crearPanel() {
		panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(138, 0, 0));
		panel.setBounds(10, 10, 604, 497);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Cantidad de usuarios:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 32, 147, 22);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(167, 31, 28, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblCantidadDeFiguritas = new JLabel("Cantidad de figuritas por paquete:");
		lblCantidadDeFiguritas.setForeground(Color.WHITE);
		lblCantidadDeFiguritas.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblCantidadDeFiguritas.setBounds(220, 32, 225, 22);
		panel.add(lblCantidadDeFiguritas);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(455, 31, 28, 20);
		panel.add(textField_1);
		
		JLabel lblCantidadDeSimulaciones = new JLabel("Cantidad de simulaciones a realizar:");
		lblCantidadDeSimulaciones.setForeground(Color.WHITE);
		lblCantidadDeSimulaciones.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		lblCantidadDeSimulaciones.setBounds(493, 32, 247, 22);
		panel.add(lblCantidadDeSimulaciones);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(750, 31, 28, 20);
		panel.add(textField_2);
		
		JButton btnNewButton = new JButton("Simular");
		btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		btnNewButton.setBounds(352, 342, 160, 36);
		panel.add(btnNewButton);
	}
}
