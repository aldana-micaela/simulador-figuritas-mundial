package interfaz;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import javax.swing.SwingWorker;
import javax.swing.UIManager;

import codigoNegocio.Instancia;
import codigoNegocio.Simulador;
import codigoNegocio.Solucion;
import codigoNegocio.Usuario;
import escenarios.Escenario;
import generador.Generador;
import generador.GeneradorRandom;
import observador.Observador;
import observador.ObservadorGrafico;
import observador.ObservadorPorInterfaz;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class SimuladorInterface extends SwingWorker<Integer, Integer> {

	private JFrame frame;
	private JPanel panel;

	private int cantFiguritas;
	private int cantFiguritasXPaquete;
	private Escenario escenario;
	private int cantSimulacion;

	private Solucion soluciones;

	private JLabel txtObservador;

	private JProgressBar progressBar;
	private JButton btnVerGrafico;
	private JButton btnInterrumpir;

	private static Menu menu;
	private JLabel instanciaSeleccionadaUsuario;
	private JTextField valorCantUsuarios;
	private JLabel instanciaCantFigus;
	private JLabel instanciaCantFigusXPaquete;
	private JTextField valorCantFigus;
	private JTextField valorCantFigusXPaq;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					menu = new Menu();

					SimuladorInterface window = new SimuladorInterface(menu.getCantFiguritas(),
							menu.getCantFiguritasXPaquete(), menu.getEscenario(), menu.getCantSimulaciones());
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
	public SimuladorInterface(int cantFiguritas, int cantFiguritasXPaquete, Escenario escenario, int cantSimulaciones) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.cantFiguritas = cantFiguritas;
		this.cantFiguritasXPaquete = cantFiguritasXPaquete;
		this.escenario = escenario;
		this.cantSimulacion = cantSimulaciones;

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		crearFrame();
		crearPanel();
		crearTextoDeEstadisticas();
		crearTextoInstanciaSeleccionada();
		crearBarraProgreso();
		inicializarEscenario();
		crearBotonGrafico();
		eventoBotonGrafico();

		crearBtnInterrumpirProceso();

	}

	private void crearBotonGrafico() {
		btnVerGrafico = new JButton("Ver Grafico");
		btnVerGrafico.setFont(new Font("Consolas", Font.BOLD, 15));

		btnVerGrafico.setBounds(347, 179, 191, 54);
		panel.add(btnVerGrafico);

	}

	private void crearFrame() {
		frame = new JFrame("Simulador");
		frame.setBounds(450, 150, 639, 288);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	private void crearPanel() {
		panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBounds(10, 10, 604, 497);
		panel.setLayout(null);
		frame.getContentPane().add(panel);

	}

	private void inicializarEscenario() {

		soluciones = new Solucion(cantFiguritas, cantFiguritasXPaquete, escenario, cantSimulacion);
		Observador ob = new ObservadorPorInterfaz(soluciones.getLista(), txtObservador, progressBar);
		soluciones.registrarObservador(ob);

		soluciones.start();

	}

	private void eventoBotonGrafico() {
		btnVerGrafico.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				new ObservadorGrafico(soluciones.getLista()).notificar();

			}
		});
	}

	private void crearTextoInstanciaSeleccionada() {
		instanciaSeleccionadaUsuario = new JLabel("Usuarios:");
		instanciaSeleccionadaUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		instanciaSeleccionadaUsuario.setBounds(15, 20, 207, 37);
		panel.add(instanciaSeleccionadaUsuario);

		instanciaCantFigus = new JLabel("Cantidad figuritas del album:");
		instanciaCantFigus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		instanciaCantFigus.setBounds(122, 20, 207, 37);
		panel.add(instanciaCantFigus);

		instanciaCantFigusXPaquete = new JLabel("Cantidad figuritas x paquete:");
		instanciaCantFigusXPaquete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		instanciaCantFigusXPaquete.setBounds(373, 20, 207, 37);
		panel.add(instanciaCantFigusXPaquete);

		valorCantUsuarios = new JTextField(String.valueOf(escenario.getCantUsuarios()));
		valorCantUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 12));
		valorCantUsuarios.setEditable(false);
		valorCantUsuarios.setBounds(78, 20, 34, 29);
		panel.add(valorCantUsuarios);
		valorCantUsuarios.setColumns(10);

		valorCantFigus = new JTextField(String.valueOf(cantFiguritas));
		valorCantFigus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		valorCantFigus.setEditable(false);
		valorCantFigus.setBounds(323, 20, 34, 29);
		panel.add(valorCantFigus);
		valorCantFigus.setColumns(10);

		valorCantFigusXPaq = new JTextField(String.valueOf(cantFiguritasXPaquete));
		valorCantFigusXPaq.setFont(new Font("Tahoma", Font.PLAIN, 12));
		valorCantFigusXPaq.setEditable(false);
		valorCantFigusXPaq.setBounds(581, 20, 34, 29);
		panel.add(valorCantFigusXPaq);
		valorCantFigusXPaq.setColumns(10);

	}

	public void crearBtnInterrumpirProceso() {

		btnInterrumpir = new JButton("Interrumpir proceso");
		btnInterrumpir.setFont(new Font("Consolas", Font.BOLD, 15));
		btnInterrumpir.setBounds(78, 179, 215, 54);
		panel.add(btnInterrumpir);

		btnInterrumpir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	public void crearTextoDeEstadisticas() {
		txtObservador = new JLabel();
		txtObservador.setFont(new Font("Courier New", Font.PLAIN, 13));
		txtObservador.setBounds(15, 129, 600, 40);
		panel.add(txtObservador);

	}

	public void crearBarraProgreso() {
		progressBar = new JProgressBar();
		progressBar = new JProgressBar();
		progressBar.setBounds(15, 79, 600, 40);
		panel.add(progressBar);

	}

	@Override
	protected Integer doInBackground() throws Exception {

		execute();

		return null;
	}
}
