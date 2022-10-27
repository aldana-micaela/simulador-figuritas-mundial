package codigoNegocio;

import generador.Generador;
import simulador.Simulador;

public class Solucion {

	Instancia instancia;
	Generador generador;

	public Solucion(Instancia i, Generador g) {

		this.instancia = i;
		this.generador = g;

	}

	public void simular(Usuario u) {

		getSimulador().simular(u, generador);
	}

	public Simulador getSimulador() {
		return instancia.getSimulador();
	}

}
