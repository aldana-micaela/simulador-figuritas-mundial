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
		 
			  while (!todosCompletos()) {

					Thread.sleep(100);
					getEscenario().simular( generador, getUsuarios());
					notificarObservadores();
					iteracion++;
		 		
			
		  }
		} catch (InterruptedException e) {
			//e.printStackTrace();
			System.out.println("Proceso interrumpido");
		}

	}
		

	private void notificarObservadores() {
		for (Observador o : observadores)
			o.notificar();
		    
		   
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
