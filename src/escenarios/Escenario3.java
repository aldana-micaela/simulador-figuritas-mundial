package escenarios;


import java.util.ArrayList;

import codigoNegocio.Usuario;
import generador.Generador;

public class Escenario3 implements Escenario {
	
	private int cantUsuarios;
	private int donadas;

	public Escenario3 (int cantUsuario) {
		this.cantUsuarios = cantUsuario;
		this.donadas=0;
		
	}


	@Override
	public void generarPaquete(Usuario u, Generador g) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public int getCantUsuarios() {
		return cantUsuarios;
	}


	@Override
	public void simular(Usuario u, Generador g, ArrayList<Usuario> lista) {
		// TODO Auto-generated method stub
		
	}
	
	public int getDonadas() {
		
		return donadas;
	}


	@Override
	public int getNoDonadas() {
		// TODO Auto-generated method stub
		return 0;
	}

}
