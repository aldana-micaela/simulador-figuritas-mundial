package test;

import static org.junit.Assert.*;

import org.junit.Test;

import escenarios.Escenario;
import escenarios.Escenario2;
import generador.GeneradorPrefijado;
import simuladores.Instancia;
import simuladores.Simulador;

public class SimuladorTest {
	
	Instancia instancia;
	GeneradorPrefijado generador;
	Simulador simulador;
	Escenario escenario2;
	
	
	private void inicializarSimulador(int cantUsuarios) {
		int cantFiguritasXPaquete=5;
		
		escenario2 = new Escenario2(cantUsuarios);
		instancia = new Instancia(10, cantFiguritasXPaquete, escenario2);
		generador = new GeneradorPrefijado(cantFiguritasXPaquete);
		simulador = new Simulador(instancia, generador, 1);
	}
	
	
	@Test 
	public void todosCompletosTest() {
		inicializarSimulador(5);
		
		int[][] paquetesEsperados = {	{0, 1, 2, 3, 4},  //paquete usuario1
				
										{0, 1, 2, 3, 4},  //paquete usuario2
										
										{0, 1, 2, 3, 4},  //paquete usuario3
										
										{0, 1, 2, 3, 4},  //paquete usuario4
										
										{0, 1, 2, 3, 4},  //paquete usuario5
										

										
										{5, 6, 7, 8, 9},   //paquete usuario1
										
										{5, 6, 7, 8, 9},   //paquete usuario2
										
										{5, 6, 7, 8, 9},   //paquete usuario3
										
										{5, 6, 7, 8, 9},   //paquete usuario4
										
										{5, 6, 7, 8, 9}    //paquete usuario5
										
										
									};

		generador.setMatrizDePaquetes(paquetesEsperados);
		simulador.simular();

		assertTrue(simulador.todosCompletos());
		
	}
	
	@Test (expected = Exception.class)
	public void todosNOCompletosTest() {
		inicializarSimulador(5);
		
		int[][] paquetesEsperados = {	{1, 1, 2, 3, 4},  //paquete usuario1
				
										{0, 1, 2, 3, 4},  //paquete usuario2
										
										{0, 1, 2, 3, 4},  //paquete usuario3
										
										{0, 1, 2, 3, 4},  //paquete usuario4
										
										{0, 1, 2, 3, 4},  //paquete usuario5
										
										
										{5, 6, 7, 8, 9},   //paquete usuario1
										
										{5, 6, 7, 8, 9},   //paquete usuario2
										
										{5, 6, 7, 8, 9},   //paquete usuario3
										
										{5, 6, 7, 8, 9},   //paquete usuario4
										
										{5, 6, 7, 8, 9}    //paquete usuario5
										
										
										
									};
		
		generador.setMatrizDePaquetes(paquetesEsperados);
		simulador.simular();
		
		
	}
	@Test
	public void paquetesGeneradosTest() {
		inicializarSimulador(5);
		
		int[][] paquetesEsperados = {
										{0, 1, 2, 3, 4},  //paquete usuario1
				
										{0, 1, 2, 3, 4},  //paquete usuario2
										
										{0, 1, 2, 3, 4},  //paquete usuario3
										
										{0, 1, 2, 3, 4},  //paquete usuario4
										
										{0, 1, 2, 3, 4},  //paquete usuario5
										
										
										{0, 1, 2, 3, 4},  //paquete usuario1
										
										{0, 1, 2, 3, 4},  //paquete usuario2
										
										{0, 1, 2, 3, 4},  //paquete usuario3
										
										{0, 1, 2, 3, 4},  //paquete usuario4
										
										{0, 1, 2, 3, 4},  //paquete usuario5
										
										
										{5, 6, 7, 8, 9},   //paquete usuario1
										
										{5, 6, 7, 8, 9},   //paquete usuario2
										
										{5, 6, 7, 8, 9},   //paquete usuario3
										
										{5, 6, 7, 8, 9},   //paquete usuario4
										
										{5, 6, 7, 8, 9}    //paquete usuario5
				
									};
		
		generador.setMatrizDePaquetes(paquetesEsperados);
		simulador.simular();
		
		assertEquals(15, simulador.paquetesGenerados());
		
	}

}
