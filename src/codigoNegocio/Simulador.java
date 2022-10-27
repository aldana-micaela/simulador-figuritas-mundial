package codigoNegocio;

import java.util.ArrayList;

import escenarios.Escenario;
import generador.Generador;
import observador.Observador;

public class Simulador {

	Instancia instancia;
	Generador generador;
	int iteracion;
	
	private ArrayList<Observador> observadores;

	public Simulador(Instancia i, Generador g) {

		this.instancia = i;
		this.generador = g;
		iteracion=0;
		
		observadores = new ArrayList<Observador>();

	}

	public void simular() {
		
		while (!getUsuario().estaCompleto()) {

		getEscenario().simular(instancia.getUsers(), generador);
		notificarObservadores();
		iteracion++;
		}
		
	}
	
	private void notificarObservadores() {
		for(Observador o: observadores)
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

}
