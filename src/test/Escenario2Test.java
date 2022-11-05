package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import escenarios.Escenario2;
import generador.GeneradorPrefijado;
import simuladores.Instancia;
import simuladores.Usuario;

public class Escenario2Test {
	
	
	private Escenario2 escenario2;
	private GeneradorPrefijado generador;
	private Instancia instancia;
	private ArrayList<Usuario> usuarios;

	private void inicializarEscenario2(int cantUsuarios) {
		int cantFiguritasXPaquete=5;
		
		escenario2 = new Escenario2(cantUsuarios);
		instancia = new Instancia(10, cantFiguritasXPaquete, escenario2);
		generador = new GeneradorPrefijado(cantFiguritasXPaquete);
		usuarios = new ArrayList<Usuario>();
		
		for(int i =0; i<cantUsuarios; i++)
		usuarios.add(new Usuario(instancia, i));

	}

	@Test
	public void escenario2Test() {
		inicializarEscenario2(2);

		int[][] paquetesEsperados = {
										{0, 1, 2, 3, 4}, //paquete usuario1
										
										{0, 1, 2, 3, 4}  //paquete usuario2
										
									};

		generador.setMatrizDePaquetes(paquetesEsperados);
		escenario2.simular(generador, usuarios);

		assertEquals(5, usuarios.get(0).getFiguritasAcertadas());
		assertEquals(5, usuarios.get(1).getFiguritasAcertadas());

	}
	@Test
	public void escenario2RepetidosTest() {
		inicializarEscenario2(2);
		
		int[][] paquetesEsperados = {
										{ 0, 0, 0, 3, 4}, //paquete usuario1
										
										{ 0, 1, 2, 3, 3}  //paquete usuario2
										
									};

		generador.setMatrizDePaquetes(paquetesEsperados);
		escenario2.simular(generador, usuarios);
		
		assertEquals(3, usuarios.get(0).getFiguritasAcertadas());
		assertEquals(4, usuarios.get(1).getFiguritasAcertadas());
	}
	
	@Test
	public void escenario2DonadasTest() {
		inicializarEscenario2(2);
		
		int[][] paquetesEsperados = {
										{ 0, 0, 0, 3, 4}, //paquete usuario1
										
										{ 5, 1, 2, 3, 4}  //paquete usuario2
										
								};
		
		generador.setMatrizDePaquetes(paquetesEsperados);
		escenario2.simular(generador, usuarios);
		
		assertEquals(3, usuarios.get(0).getFiguritasAcertadas());
		assertEquals(1, usuarios.get(0).getDonadas());
		assertEquals(1, usuarios.get(0).getCantFiguritasRepetidas());
		assertEquals(6, usuarios.get(1).getFiguritasAcertadas());
	}
	
	@Test
	public void escenario2DonadasViceversaTest() {
		inicializarEscenario2(2);
		
		int[][] paquetesEsperados = {
										{ 5, 1, 2, 3, 4}, //paquete usuario1
										
										{ 0, 0, 9, 9, 4}  //paquete usuario2
									};
								
		generador.setMatrizDePaquetes(paquetesEsperados);
		escenario2.simular(generador, usuarios);
		
		assertEquals(7, usuarios.get(0).getFiguritasAcertadas());
		assertEquals(0, usuarios.get(0).getDonadas());
		assertEquals(2, usuarios.get(1).getDonadas());
		assertEquals(3, usuarios.get(1).getFiguritasAcertadas());
	}
	
	@Test
	public void escenario2CompletoTest() {
		inicializarEscenario2(2);
		
		int[][] paquetesEsperados = {	{0, 0, 2, 3, 4},  //paquete usuario1
				
										{1, 1, 2, 3, 4},  //paquete usuario2
										
										{5, 6, 7, 8, 9},  //paquete usuario1
										
										{5, 6, 7, 8, 9}   //paquete usuario2
									};
		
		generador.setMatrizDePaquetes(paquetesEsperados);
		escenario2.simular(generador, usuarios);
		escenario2.simular(generador, usuarios);
		
		assertEquals(1, usuarios.get(0).getDonadas());
		assertEquals(1, usuarios.get(1).getDonadas());
		assertTrue(usuarios.get(0).estaCompleto());
		assertTrue(usuarios.get(1).estaCompleto());
		
	}
	@Test
	public void escenario2NOCompletoTest() {
		inicializarEscenario2(2);
		
		int[][] paquetesEsperados = {	{0, 1, 2, 3, 4},  //paquete usuario1
				
										{1, 2, 2, 3, 4},  //paquete usuario2
										
										{5, 6, 7, 8, 8},  //paquete usuario1
										
										{5, 6, 7, 8, 9}   //paquete usuario2
								};
		
		generador.setMatrizDePaquetes(paquetesEsperados);
		escenario2.simular(generador, usuarios);
		escenario2.simular(generador, usuarios);
		

		assertFalse(usuarios.get(0).estaCompleto());
		assertFalse(usuarios.get(1).estaCompleto());
		
	}
	
	@Test
	public void escenario2NoDonadasTest() {
		inicializarEscenario2(2);
		
		int[][] paquetesEsperados = { 	{0, 0, 0, 7, 5},  //paquete usuario1
				
										{5, 6, 7, 8, 0}   //paquete usuario2
									};
		
		generador.setMatrizDePaquetes(paquetesEsperados);
		escenario2.simular(generador, usuarios);
		
		assertEquals(0, usuarios.get(0).getDonadas());
		
	}

}
