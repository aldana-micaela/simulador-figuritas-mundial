package interfaz;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import codigoNegocio.Instancia;
import codigoNegocio.Simulador;
import escenarios.Escenario1;
import generador.GeneradorRandom;
import observador.Observador;
import observador.ObservadorPorInterfaz;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class SimuladorInterface {

	private JFrame frame;
	private JPanel panel;
	
	
	private Simulador simulador;
	private JLabel txtObservador;
	private Instancia instancia;
	private ObservadorPorInterfaz observador;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimuladorInterface window = new SimuladorInterface();
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
	public SimuladorInterface() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		crearFrame();
		crearPanel();
		inicializarEscenario1();
		
	}

	private void crearFrame() {
		frame = new JFrame();
		frame.setBounds(450, 150, 639, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Simulador");
		frame.setVisible(true);
	}

	private void crearPanel() {
		panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(10, 10, 604, 497);
		panel.setLayout(null);
		frame.getContentPane().add(panel);

	}

	private void inicializarEscenario1() {
		instancia = new Instancia(6380, 5, new Escenario1());
		simulador = new Simulador(instancia, new GeneradorRandom());
		observador = new ObservadorPorInterfaz(simulador);
		simulador.registrarObservador(observador);
		simulador.simular();		
		
		estadisticas();
		txtObservador.setText(observador.getObservador());

	}


	public void estadisticas() {
		txtObservador= new JLabel();
		txtObservador.setText(observador.getObservador());
		txtObservador.setBounds(100, 205, 600, 40);
		panel.add(txtObservador);

	}
	
//	public void crearbotonSimular() {
//		JButton btnNewButton = new JButton("Simular");
//		btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
//		btnNewButton.setBounds(352, 342, 160, 36);
//		panel.add(btnNewButton);
//	}
}
