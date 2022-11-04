package codigoNegocio;

import java.util.ArrayList;

import escenarios.Escenario;
import generador.Generador;
import observador.Observador;

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
//				try {
//					Thread.sleep(50);
			getEscenario().simular(generador, getUsuarios());
			// notificarObservadores();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
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

//	@Override
//	public void run() {
//		simular();
//	}

}
