package observador;

import java.util.ArrayList;

import javax.swing.JFrame;
import codigoNegocio.Simulador;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ObservadorGrafico implements Observador {

	private ArrayList<Simulador> simulador;
	private JFrame frame;
	private DefaultCategoryDataset datos;
	private JFreeChart grafico;

	public ObservadorGrafico(ArrayList<Simulador> s) {

		this.simulador = s;
	}

	@Override
	public void notificar() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		datos = new DefaultCategoryDataset();
		for (Simulador u : simulador) {
			datos.addValue(u.paquetesGenerados(), "Paquetes: " + u.paquetesGenerados(),
					"Simulador: " + u.getNumeroSimulacion());
		}
		grafico = ChartFactory.createBarChart("Paquetes vendidos en total", "Figuritas", "Paquetes vendidos", datos,
				PlotOrientation.VERTICAL, true, false, false);

		ChartPanel panel = new ChartPanel(grafico);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);

	}

	@Override
	public void settear(int set) {
		// TODO Auto-generated method stub
		
	}


}
