package observador;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

import codigoNegocio.Simulador;
import codigoNegocio.Usuario;

public class ObservadorPorInterfaz implements Observador {

	private Simulador simulador;
	private JLabel label;
	private JProgressBar barra;

	ArrayList<Simulador> lista;

	public ObservadorPorInterfaz(ArrayList<Simulador> s, JLabel label, JProgressBar barra) {
		this.label = label;
		this.barra = barra;
		this.lista = s;

	}

	@Override
	public void notificar() {

		barra.setMinimum(0);
		barra.setMaximum(lista.size() * (simulador.getCantFiguritas() * simulador.getUsuarios().size()));

		label.setText("Simulacion: " + simulador.getNumeroSimulacion() + " Paquetes: " + paquetesGenerados()
				+ " Paquetes totales: " + totalPaquetesGenerados() + " Promedio: "
				+ totalPaquetesGenerados() / lista.size());


		barra.setValue(total());

	}

	public void settear(int i) {
		this.simulador = lista.get(i);
	}

	private int acertadas(Simulador s) {
		int tot = 0;
		for (Usuario u : s.getUsuarios()) {
			tot = tot + u.getFiguritasAcertadas();
		}
		return tot;
	}

	private int total() {
		int tot = 0;
		for (Simulador s : lista) {
			for (Usuario u : s.getUsuarios()) {
				tot = tot + u.getFiguritasAcertadas();
			}

		}
		return tot;
	}

	private int totalPaquetesGenerados() {
		int tot = 0;
		for (Simulador s : lista) {
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
