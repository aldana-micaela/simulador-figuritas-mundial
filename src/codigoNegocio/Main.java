package codigoNegocio;

import generador.GeneradorRandom;
import simulador.Simulador1;

public class Main {

	public static void main(String[] args) {
		
		Instancia inst= new Instancia (638, 5, new Simulador1());
		Usuario user = new Usuario(inst);
		Solucion s= new Solucion (inst, new GeneradorRandom());
		
		s.simular(user);
	}

}
