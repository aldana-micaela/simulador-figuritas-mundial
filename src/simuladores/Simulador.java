package simuladores;

import java.util.ArrayList;


import escenarios.Escenario;
import generador.Generador;


public class Simulador {

	private Instancia instancia;
	private Generador generador;
	private int iteracion;

	public Simulador(Instancia i, Generador g, int numero) {
		this.instancia = i;
		this.generador = g;
		iteracion = numero;

	}

	public void simular() {

		while (!todosCompletos()) {
			getEscenario().simular(generador, getUsuarios());

		}

	}

	public Escenario getEscenario() {
		return instancia.getEscenario();
	}

	public ArrayList<Usuario> getUsuarios() {
		return instancia.getUsers();
	}

	public boolean todosCompletos() {

		boolean estanCompletos = true;
		for (Usuario e : instancia.getUsers()) {

			if (e.estaCompleto())
				estanCompletos = estanCompletos && true;
			else
				estanCompletos = false;

		}
		return estanCompletos;

	}

	public int getCantFiguritas() {
		return instancia.getCantFiguritas();
	}

	public int getNumeroSimulacion() {
		return iteracion;
	}

	public Instancia getInstancia() {
		return instancia;
	}

	public int paquetesGenerados() {
		int i = 0;
		for (Usuario u : getUsuarios())
			i = i + u.getPaquetes();
		return i;
	}

}
