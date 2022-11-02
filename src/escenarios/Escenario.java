package escenarios;


import java.util.ArrayList;

import codigoNegocio.Usuario;
import generador.Generador;

public interface Escenario {
	
	
	public void simular(Generador g, ArrayList<Usuario> lista);
	public void generarPaquete(Usuario u, Generador g);
	public int getCantUsuarios();

	
	

}
