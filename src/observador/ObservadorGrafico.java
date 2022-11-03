package observador;

import javax.swing.JFrame;
import codigoNegocio.Simulador;
import codigoNegocio.Usuario;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ObservadorGrafico implements Observador{
	
	private Simulador simulador;
	private JFrame frame;
	private DefaultCategoryDataset datos;
	private JFreeChart grafico;
	
	public ObservadorGrafico(Simulador s) {
		
		this.simulador=s;
	}

	@Override
	public void notificar() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		datos = new DefaultCategoryDataset();
		for (Usuario u : simulador.getUsuarios()) {
		    for(int i=0; i<simulador.getCantSimulaciones(); i++)
			datos.addValue(u.getPaquetes(), "Paquetes: " + simulador.getIteracion() + "", "Simulación" + i);
		}
		grafico = ChartFactory.createBarChart("Paquetes vendidos en total", "Figuritas", "Paquetes vendidos",
				datos, PlotOrientation.VERTICAL, true, false, false);

		ChartPanel panel = new ChartPanel(grafico);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		
	}

	
}
