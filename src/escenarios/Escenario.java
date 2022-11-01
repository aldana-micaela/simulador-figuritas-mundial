package escenarios;


import java.util.ArrayList;

import codigoNegocio.Usuario;
import generador.Generador;

public interface Escenario {
	
	
	public void simular(Usuario u, Generador g, ArrayList<Usuario> lista);
	public void generarPaquete(Usuario u, Generador g);
	public int getCantUsuarios();
	public int getDonadas();
	public int getNoDonadas();
	
	

}
