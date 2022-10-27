package codigoNegocio;

import escenarios.Escenario1;
import generador.GeneradorRandom;

public class Main {

	public static void main(String[] args) {
		
		Instancia inst= new Instancia (638, 5, new Escenario1());
		Simulador s= new Simulador (inst, new GeneradorRandom());
		
		s.simular();
	}

}
