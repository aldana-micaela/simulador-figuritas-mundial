package simuladores;

import java.util.ArrayList;

import escenarios.Escenario;
import generador.Generador;
import generador.GeneradorRandom;
import observador.Observador;

public class Solucion extends Thread {

	private ArrayList<Simulador> lista;

	private int cantSoluciones;
	private int cantFiguritas;
	private int cantFiguritasXPaquete;
	private Generador generador;
	private Escenario escenario;
	private ArrayList<Observador> observadores;

	public Solucion(int cantFiguritas, int cantFiguritasXPaquete, Escenario e, int cant) {
		this.lista = new ArrayList<Simulador>();
		this.generador = new GeneradorRandom();
		this.cantSoluciones = cant;
		this.cantFiguritas = cantFiguritas;
		this.cantFiguritasXPaquete = cantFiguritasXPaquete;
		this.escenario = e;
		this.observadores = new ArrayList<Observador>();

		agregarSimuladores();
	}

	public void ejecutar() {

		for (int i = 0; i < lista.size(); i++) {

			try {
				Thread.sleep(100);
				lista.get(i).simular();

				System.out.println(lista.get(i).paquetesGenerados());

				settearObservador(i);
				notificarObservadores();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	private void agregarSimuladores() {
		for (int i = 1; i <= cantSoluciones; i++) {
			lista.add(nuevoSimulador(i));
		}
	}

	public ArrayList<Simulador> getLista() {

		return lista;

	}

	private void notificarObservadores() {
		for (Observador o : observadores)
			o.notificar();

	}

	public void registrarObservador(Observador o) {
		observadores.add(o);
	}

	private void settearObservador(int set) {
		for (int i = 0; i < observadores.size(); i++) {
			observadores.get(i).settear(set);
		}
	}

	private Simulador nuevoSimulador(int i) {
		return new Simulador(new Instancia(cantFiguritas, cantFiguritasXPaquete, escenario), generador, i);
	}

	@Override
	public void run() {
		ejecutar();
	}

}
