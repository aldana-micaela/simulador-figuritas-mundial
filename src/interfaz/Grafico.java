package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import codigoNegocio.Simulador;
import codigoNegocio.Usuario;

import java.awt.BorderLayout;
import java.awt.Color;

public class Grafico {

	private JFrame frame;
	private Simulador simulador;
	private JFreeChart grafico;
	private DefaultCategoryDataset datos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grafico window = new Grafico();
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
	public Grafico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	    datos= new DefaultCategoryDataset();
	    for(Usuario u: simulador.getUsuarios())
	    datos.addValue(u.getPaquetes(), u.getNumeroUsuario()+"", "Paquetes");
	    
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
	
}
