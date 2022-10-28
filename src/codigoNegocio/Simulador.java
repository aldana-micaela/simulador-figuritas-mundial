package codigoNegocio;

import java.util.ArrayList;

import escenarios.Escenario;
import generador.Generador;
import observador.Observador;

public class Simulador extends Thread {

	private Instancia instancia;
	private Generador generador;
	private int iteracion;

	private ArrayList<Observador> observadores;

	public Simulador(Instancia i, Generador g) {
		this.instancia = i;
		this.generador = g;
		iteracion = 1;

		observadores = new ArrayList<Observador>();

	}

	public void simular() {

		while (!getUsuario().estaCompleto()) {
			try {

				Thread.sleep(50);
				getEscenario().simular(instancia.getUsers(), generador);
				notificarObservadores();
				iteracion++;

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	private void notificarObservadores() {
		for (Observador o : observadores)
			o.notificar();
	}

	public void registrarObservador(Observador o) {
		observadores.add(o);
	}

	private Escenario getEscenario() {
		return instancia.getEscenario();
	}

	public Usuario getUsuario() {
		return instancia.getUsers();
	}

	public int getCantFiguritas() {
		return instancia.getCantFiguritas();
	}

	public int getIteracion() {
		return iteracion;
	}

	@Override
	public void run() {

		simular();

	}

}
