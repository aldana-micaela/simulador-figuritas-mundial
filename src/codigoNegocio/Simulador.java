package codigoNegocio;

import escenarios.Escenario;
import generador.Generador;

public class Simulador {

	Instancia instancia;
	Generador generador;

	public Simulador(Instancia i, Generador g) {

		this.instancia = i;
		this.generador = g;

	}

	public void simular() {

		
		getSimulador().simular(instancia.getUsers(), generador);
	}

	public Escenario getSimulador() {
		return instancia.getSimulador();
	}

}
