package escenarios;


import java.util.ArrayList;

import codigoNegocio.Usuario;
import generador.Generador;

public class Escenario1 implements Escenario {
	
	private int cantUsuarios;

	public Escenario1 () {
		this.cantUsuarios = 1;
		
	}

	@Override
	public void generarPaquete(Usuario u, Generador g) {

		int i = 0;
		while (i < u.getCantFiguritasXPaquete()) {

			u.agregarFigurita(g.nextInt(u.getCantFiguritas()));

			i++;
		}
		u.incrementarPaquete();
	}


	@Override
	public int getCantUsuarios() {
		return cantUsuarios;
	}

	@Override
	public void simular(Generador g, ArrayList<Usuario> lista) {
		for(Usuario u: lista)
			if(!u.estaCompleto())
				generarPaquete(u, g);
		
	}


}
