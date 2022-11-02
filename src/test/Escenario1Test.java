package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import codigoNegocio.Instancia;
import codigoNegocio.Usuario;
import escenarios.Escenario1;
import generador.GeneradorPrefijado;

public class Escenario1Test {

	private Escenario1 escenario1;
	private GeneradorPrefijado generador;
	private Instancia instancia;
	private ArrayList<Usuario> usuarios;

	private void inicializarEscenario1() {
		int cantFiguritasXPaquete=5;
		
		escenario1 = new Escenario1();
		instancia = new Instancia(10, cantFiguritasXPaquete, escenario1, 10);
		generador = new GeneradorPrefijado(cantFiguritasXPaquete);

		usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario(instancia, 1));

	}

	@Test
	public void escenario1Test() {
		inicializarEscenario1();

		int[][] paquetesEsperados = { { 0, 1, 2, 3, 4 } };

		generador.setMatrizDePaquetes(paquetesEsperados);
		escenario1.simular(generador, usuarios);

		assertEquals(5, usuarios.get(0).getFiguritasAcertadas());

	}
	@Test
	public void escenario1RepetidosTest() {
		inicializarEscenario1();
		
		int[][] paquetesEsperados = { { 0, 0, 0, 3, 4 } };
		
		generador.setMatrizDePaquetes(paquetesEsperados);
		escenario1.simular(generador, usuarios);
		
		assertEquals(3, usuarios.get(0).getFiguritasAcertadas());
		assertEquals(2, usuarios.get(0).getCantFiguritasRepetidas());
		
	}
	
	@Test
	public void escenario1CompletoTest() {
		inicializarEscenario1();
		
		int[][] paquetesEsperados = { { 0, 1, 2, 3, 4 }, {5, 6, 7, 8, 9} };
		
		generador.setMatrizDePaquetes(paquetesEsperados);
		escenario1.simular(generador, usuarios);
		escenario1.simular(generador, usuarios);
		
		assertTrue(usuarios.get(0).estaCompleto());
		assertEquals(10, usuarios.get(0).getFiguritasAcertadas());
		
	}
	@Test
	public void escenario1NoCompletoTest() {
		inicializarEscenario1();
		
		int[][] paquetesEsperados = { { 0, 0, 0, 3, 4 }, {5, 6, 7, 8 ,9} };
		
		generador.setMatrizDePaquetes(paquetesEsperados);
		escenario1.simular(generador, usuarios);
		escenario1.simular(generador, usuarios);
		
		assertFalse(usuarios.get(0).estaCompleto());
		assertEquals(8, usuarios.get(0).getFiguritasAcertadas());
		
	}

}
