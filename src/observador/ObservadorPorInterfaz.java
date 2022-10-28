package observador;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

import codigoNegocio.Simulador;

public class ObservadorPorInterfaz implements Observador {

	private Simulador simulador;

	private JLabel label;
	private JProgressBar barra;

	public ObservadorPorInterfaz(Simulador s, JLabel label, JProgressBar barra) {
		this.simulador = s;
		this.label = label;
		this.barra = barra;
	}

	@Override
	public void notificar() {
		System.out.print("Paquete: " + simulador.getIteracion());
		System.out.print(" figuritasAcertadas: " + simulador.getUsuario().getFiguritasAcertadas() + "/" + simulador.getCantFiguritas());
		System.out.println();

		barra.setMaximum(simulador.getCantFiguritas());
		barra.setMinimum(0);

		label.setText("Paquete: " + simulador.getIteracion() + " Figuritas acertadas: "
				+ simulador.getUsuario().getFiguritasAcertadas() + "/" + simulador.getCantFiguritas());


		barra.setValue(simulador.getUsuario().getFiguritasAcertadas());

	}

}
