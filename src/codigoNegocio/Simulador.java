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

		
		try {
			for (Usuario u : getUsuarios()) {
				
			  while (!u.estaCompleto()) {
					Thread.sleep(100);
					getEscenario().simular(u, generador, getUsuarios());
					notificarObservadores(u);
					u.incrementarPaquete();
					iteracion++;
		 		}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		

	private void notificarObservadores(Usuario u) {
		for (Observador o : observadores)
			o.notificar(u);
		    
		   
	}

	public void registrarObservador(Observador o) {
		observadores.add(o);
	}

	public Escenario getEscenario() {
		return instancia.getEscenario();
	}

	public ArrayList<Usuario> getUsuarios() {
		return instancia.getUsers();
	}

//	public boolean todosCompletos() {
//
//		boolean estanCompletos = true;
//		for (Usuario e : instancia.getUsers()) {
//
//			if (e.estaCompleto())
//				estanCompletos = estanCompletos && true;
//			else
//				estanCompletos = false;
//
//		}
//		return estanCompletos;
//
//	}

	public int getCantFiguritas() {
		return instancia.getCantFiguritas();
	}

	public int getIteracion() {
		return iteracion;
	}

	public Instancia getInstancia() {
		return instancia;
	}

	@Override
	public void run() {

		simular();
	}

}
