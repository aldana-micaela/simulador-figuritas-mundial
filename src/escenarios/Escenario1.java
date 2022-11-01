package escenarios;


import java.util.ArrayList;

import codigoNegocio.Usuario;
import generador.Generador;

public class Escenario1 implements Escenario {
	
	private int cantUsuarios;
	private int donadas;

	public Escenario1 (int cantUsuario) {
		this.cantUsuarios = cantUsuario;
		this.donadas=0;
		
	}

	@Override
	public void generarPaquete(Usuario u, Generador g) {

		int i = 0;
		while (i < u.getCantFiguritasXPaquete()) {

			u.agregarFigurita(g.nextInt(u.getCantFiguritas()));

			i++;
		}
	}


	@Override
	public int getCantUsuarios() {
		return cantUsuarios;
	}

	@Override
	public void simular(Usuario u, Generador g, ArrayList<Usuario> lista) {
		generarPaquete(u, g);
		
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
