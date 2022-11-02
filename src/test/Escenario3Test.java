package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import codigoNegocio.Instancia;
import codigoNegocio.Usuario;
import escenarios.Escenario3;
import generador.GeneradorPrefijado;

public class Escenario3Test {
	
	private Escenario3 escenario;
	private GeneradorPrefijado generador;
	private Instancia instancia;
	private ArrayList<Usuario> usuarios;

	private void inicializarEscenario3(int cantUsuarios) {
		int cantFiguritasXPaquete=5;
		
		escenario = new Escenario3(cantUsuarios);
		instancia = new Instancia(10, cantFiguritasXPaquete, escenario, 10);
		generador = new GeneradorPrefijado(cantFiguritasXPaquete);
		usuarios = new ArrayList<Usuario>();
		
		for(int i =0; i<cantUsuarios; i++)
		usuarios.add(new Usuario(instancia, i));

	}

	@Test
	public void escenario3Test() {
		inicializarEscenario3(2);

		int[][] paquetesEsperados = {
										{0, 1, 2, 3, 4}, //paquete usuario1
										
										{0, 1, 2, 3, 4}  //paquete usuario2
										
									};

		generador.setMatrizDePaquetes(paquetesEsperados);
		escenario.simular(generador, usuarios);

		assertEquals(5, usuarios.get(0).getFiguritasAcertadas());
		assertEquals(5, usuarios.get(1).getFiguritasAcertadas());

	}
	@Test
	public void escenario3RepetidosTest() {
		inicializarEscenario3(2);
		
		int[][] paquetesEsperados = {
										{ 0, 0, 0, 3, 4}, //paquete usuario1
										
										{ 0, 1, 2, 3, 3}  //paquete usuario2
										
									};

		generador.setMatrizDePaquetes(paquetesEsperados);
		escenario.simular(generador, usuarios);
		
		assertEquals(3, usuarios.get(0).getFiguritasAcertadas());
		assertEquals(4, usuarios.get(1).getFiguritasAcertadas());
	}
	
	@Test
	public void escenario3IntercambiadasTest() {
		inicializarEscenario3(2);
		
		int[][] paquetesEsperados = {
										{ 0, 0, 2, 3, 4}, //paquete usuario1
										
										{ 1, 1, 2, 3, 4}  //paquete usuario2
										
									};
		
		generador.setMatrizDePaquetes(paquetesEsperados);
		escenario.simular(generador, usuarios);
		
		assertEquals(5, usuarios.get(0).getFiguritasAcertadas());
		assertEquals(1, usuarios.get(0).getIntercambiadas());
		assertEquals(1, usuarios.get(1).getIntercambiadas());
		assertEquals(5, usuarios.get(1).getFiguritasAcertadas());
	}
	
	
	
	
	@Test
	public void escenario3Intercambiadas2Test() {
		inicializarEscenario3(2);
		
		int[][] paquetesEsperados = {
										{ 0, 0, 0, 0, 0}, //paquete usuario1
										
										{ 1, 1, 1, 3, 4}  //paquete usuario2
										
									};
		
		generador.setMatrizDePaquetes(paquetesEsperados);
		escenario.simular(generador, usuarios);
		
		assertEquals(2, usuarios.get(0).getFiguritasAcertadas());
		assertEquals(1, usuarios.get(0).getIntercambiadas());
		assertEquals(1, usuarios.get(1).getIntercambiadas());
		assertEquals(4, usuarios.get(1).getFiguritasAcertadas());
	}
	
	@Test
	public void escenario3CompletoYIntercambiadasTest() {
		inicializarEscenario3(2);
		
		int[][] paquetesEsperados = {	{0, 0, 2, 3, 4},  //paquete usuario1
				
										{1, 1, 2, 3, 4},  //paquete usuario2
										
										{5, 6, 7, 8, 9},  //paquete usuario1
										
										{5, 6, 7, 8, 9}   //paquete usuario2
									};
		
		generador.setMatrizDePaquetes(paquetesEsperados);
		escenario.simular(generador, usuarios);
		escenario.simular(generador, usuarios);
		
		assertEquals(1, usuarios.get(0).getIntercambiadas());
		assertEquals(1, usuarios.get(1).getIntercambiadas());
		assertTrue(usuarios.get(0).estaCompleto());
		assertTrue(usuarios.get(1).estaCompleto());
		
	}
	
	@Test
	public void escenario3NOCompletoTest() {
		inicializarEscenario3(2);
		
		int[][] paquetesEsperados = {	{1, 1, 2, 3, 4},  //paquete usuario1
				
										{1, 2, 2, 3, 4},  //paquete usuario2
										
										{5, 6, 7, 8, 8},  //paquete usuario1
										
										{5, 5, 7, 8, 9}   //paquete usuario2
								};
		
		generador.setMatrizDePaquetes(paquetesEsperados);
		escenario.simular(generador, usuarios);
		escenario.simular(generador, usuarios);
		

		assertFalse(usuarios.get(0).estaCompleto());
		assertFalse(usuarios.get(1).estaCompleto());
		
	}
	
	@Test
	public void escenario3NoDonadasTest() {
		inicializarEscenario3(2);
		
		int[][] paquetesEsperados = { 	{0, 0, 0, 7, 5},  //paquete usuario1
				
										{5, 6, 7, 8, 0}   //paquete usuario2
									};
		
		generador.setMatrizDePaquetes(paquetesEsperados);
		escenario.simular(generador, usuarios);
		
		assertEquals(0, usuarios.get(0).getIntercambiadas());
		assertEquals(3, usuarios.get(0).getFiguritasAcertadas());
		assertEquals(5, usuarios.get(1).getFiguritasAcertadas());
		
	}

}
