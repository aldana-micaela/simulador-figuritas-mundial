package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import escenarios.Escenario1;
import simuladores.Instancia;
import simuladores.Usuario;

public class UsuarioTest {
	
	
	Usuario usuario;
	Instancia instancia;
	
	
	@Test 
	public void estaCompletoTest() {
		
		instancia = new Instancia(10, 5, new Escenario1());
		usuario = new Usuario(instancia,1);
		
		usuario.agregarFigurita(0);
		usuario.agregarFigurita(1);
		usuario.agregarFigurita(2);
		usuario.agregarFigurita(3);
		usuario.agregarFigurita(4);
		usuario.agregarFigurita(5);
		usuario.agregarFigurita(6);
		usuario.agregarFigurita(7);
		usuario.agregarFigurita(8);
		usuario.agregarFigurita(9);
		
		
		assertTrue(usuario.estaCompleto());
		
	}
	
	@Test 
	public void NOestaCompletoTest() {
		
		instancia = new Instancia(10, 5, new Escenario1());
		usuario = new Usuario(instancia,1);
		
		usuario.agregarFigurita(0);
		usuario.agregarFigurita(1);
		usuario.agregarFigurita(2);
		usuario.agregarFigurita(3);
		usuario.agregarFigurita(4);
		usuario.agregarFigurita(5);
		usuario.agregarFigurita(6);
		usuario.agregarFigurita(7);
		usuario.agregarFigurita(8);
		
		assertFalse(usuario.estaCompleto());
		
	}
	
	@Test 
	public void agregarFiguritaTest() {
		
		instancia = new Instancia(10, 5, new Escenario1());
		usuario = new Usuario(instancia,1);
		
		usuario.agregarFigurita(5);
		
		assertTrue(usuario.getAlbumFiguritas()[5]);
		assertEquals(1, usuario.getFiguritasAcertadas());
		
	}
	
	@Test 
	public void figuritasRepetidasTest() {
		
		instancia = new Instancia(10, 5, new Escenario1());
		usuario = new Usuario(instancia, 1);
		
		usuario.agregarFigurita(5);
		usuario.agregarFigurita(5);
		usuario.agregarFigurita(5);
		
		assertTrue(usuario.getAlbumFiguritas()[5]);
		assertEquals(1, usuario.getFiguritasAcertadas());
		assertEquals(2, usuario.getCantFiguritasRepetidas());
		
	}
	
	
	

}
