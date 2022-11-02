package observador;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

import codigoNegocio.Simulador;
import codigoNegocio.Usuario;

public class ObservadorPorInterfaz implements Observador {

	private Simulador simulador;
	private JLabel label;
	private JProgressBar barra;
	int figuritasAcertadas=0;

	public ObservadorPorInterfaz(Simulador s, JLabel label, JProgressBar barra) {
		this.simulador = s;
		this.label = label;
		this.barra = barra;
		
	}

	@Override
	public void notificar() {

		barra.setMinimum(0);
		barra.setMaximum(simulador.getUsuarios().size() * simulador.getCantFiguritas());


		label.setText(" Paquetes: " + paquetesGenerados() + " Figuritas acertadas: "
				+ total()+ "/" + simulador.getCantFiguritas() * simulador.getUsuarios().size() + " (figuritas totales)");
		
		barra.setValue(total());

	}
	
	private int total() {
		int tot=0;
		for(Usuario u: simulador.getUsuarios()) {
			tot= tot+u.getFiguritasAcertadas();
		}
		return tot;
	}
	
	private int paquetesGenerados() {
		int i=0;
		for (Usuario u: simulador.getUsuarios())
			i = i + u.getPaquetes();
		return i;
	}
	
	

}
