package observador;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

import simuladores.Simulador;
import simuladores.Usuario;

public class ObservadorPorInterfaz implements Observador {

	private Simulador simulador;
	private JLabel label;
	private JProgressBar barra;

	ArrayList<Simulador> listaSimulaciones;

	public ObservadorPorInterfaz(ArrayList<Simulador> s, JLabel label, JProgressBar barra) {
		this.label = label;
		this.barra = barra;
		this.listaSimulaciones = s;

	}

	@Override
	public void notificar() {

		barra.setMinimum(0);
		barra.setMaximum(listaSimulaciones.size() * (simulador.getCantFiguritas() * simulador.getUsuarios().size()));

		label.setText("Simulacion: " + simulador.getNumeroSimulacion() + " - Paquetes: " + paquetesGenerados()
				+ " - Paquetes totales: " + totalPaquetesGenerados() + " - Promedio: "
				+ totalPaquetesGenerados() / listaSimulaciones.size());

		barra.setValue(total());

	}

	public void settear(int i) {
		this.simulador = listaSimulaciones.get(i);
	}

	private int total() {
		int tot = 0;
		for (Simulador s : listaSimulaciones) {
			for (Usuario u : s.getUsuarios()) {
				tot = tot + u.getFiguritasAcertadas();
			}

		}
		return tot;
	}

	private int totalPaquetesGenerados() {
		int tot = 0;
		for (Simulador s : listaSimulaciones) {
			tot = tot + s.paquetesGenerados();
		}

		return tot;
	}

	private int paquetesGenerados() {
		int i = 0;
		for (Usuario u : simulador.getUsuarios())
			i = i + u.getPaquetes();
		return i;
	}

}
