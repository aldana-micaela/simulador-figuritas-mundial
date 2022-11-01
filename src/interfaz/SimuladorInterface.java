package interfaz;

import java.awt.Color;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import javax.swing.SwingWorker;
import javax.swing.UIManager;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import codigoNegocio.Instancia;
import codigoNegocio.Simulador;
import codigoNegocio.Usuario;
import escenarios.Escenario;

import generador.GeneradorRandom;
import observador.Observador;
import observador.ObservadorPorInterfaz;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SimuladorInterface extends SwingWorker<Integer, Integer> {

	private JFrame frame;
	private JPanel panel;
	
	private int cantFiguritas;
	private int cantFiguritasXPaquete;
	private Escenario escenario;

	private Simulador simulador;
	private JLabel txtObservador;
	private Instancia instancia;

	private JProgressBar progressBar;
	private Observador observador;
	private JButton btnVerGrafico;
	private DefaultCategoryDataset datos;
	private JFreeChart grafico;
	
	private static Menu menu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					menu = new Menu();
					
					SimuladorInterface window = new SimuladorInterface(menu.getCantFiguritas(), menu.getCantFiguritasXPaquete(), menu.getEscenario());
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
	public SimuladorInterface(int cantFiguritas, int cantFiguritasXPaquete, Escenario escenario) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.cantFiguritas=cantFiguritas;
		this.cantFiguritasXPaquete=cantFiguritasXPaquete;
		this.escenario=escenario;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		crearFrame();
		crearPanel();
		crearTextoDeEstadisticas();
		crearBarraProgreso();
		inicializarEscenario();
		crearBotonGrafico();
		eventoBotonGrafico();
		execute();
//		crearBtnSimular();

	}

	private void crearBotonGrafico() {
		 btnVerGrafico = new JButton("Ver Grafico");
		
		btnVerGrafico.setBounds(445, 321, 144, 58);
		panel.add(btnVerGrafico);
		
	}

	private void crearFrame() {
		frame = new JFrame("Simulador");
		frame.setBounds(450, 150, 639, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

	private void inicializarEscenario() {
		instancia = new Instancia(cantFiguritas, cantFiguritasXPaquete, escenario);
		simulador = new Simulador(instancia, new GeneradorRandom());
		progressBar.setMinimum(0);
		progressBar.setMaximum(simulador.getUsuarios().size() * simulador.getCantFiguritas());

		observador = new ObservadorPorInterfaz(simulador, txtObservador, progressBar);
		
		simulador.registrarObservador(observador);

	} 
	
	private void eventoBotonGrafico() {
btnVerGrafico.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				frame = new JFrame();
				frame.setBounds(100, 100, 450, 300);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			    datos= new DefaultCategoryDataset();
			    for(Usuario u: simulador.getUsuarios())
			    datos.addValue(u.getPaquetes(), u.getNumeroUsuario()+"", "Usuario"+u.getNumeroUsuario());
			    
			    grafico= ChartFactory.createBarChart(
			    		"Paquetes vendidos en total",
			    		"Figuritas",
			    		"Paquetes vendidos",
			    		datos, 
			    		PlotOrientation.VERTICAL, 
			    		false, 
			    		false,
			    		false);
			    
			    ChartPanel panel = new ChartPanel(grafico);
			    frame.getContentPane().add(panel);
			    frame.pack();
			    frame.setVisible(true);
			}
		});
	}

//	public void crearBtnSimular() {
//
//		JButton btnNewButton = new JButton("New button");
//		btnNewButton.setBounds(172, 343, 243, 40);
//		panel.add(btnNewButton);
//
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//
//				execute();
//
//			}
//		});
//	}

	public void crearTextoDeEstadisticas() {
		txtObservador = new JLabel();
		txtObservador.setBounds(15, 247, 600, 40);
		panel.add(txtObservador);

	}

	public void crearBarraProgreso() {
		progressBar = new JProgressBar();
		progressBar = new JProgressBar();
		progressBar.setBounds(15, 153, 600, 40);
		panel.add(progressBar);
		
		

	}

	@Override
	protected Integer doInBackground() throws Exception {

		simulador.start();

		return null;
	}
}
