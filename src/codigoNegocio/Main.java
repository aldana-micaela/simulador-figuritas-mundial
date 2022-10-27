package codigoNegocio;

import escenarios.Escenario1;
import generador.GeneradorRandom;
import observador.Observador;
import observador.ObservadorPorInterfaz;

public class Main {

	public static void main(String[] args) {
		
		Instancia inst= new Instancia (638, 5, new Escenario1());
		Simulador s= new Simulador (inst, new GeneradorRandom());
		Observador o= new ObservadorPorInterfaz(s);
		s.registrarObservador(o);
		
		s.simular();
	}

}
