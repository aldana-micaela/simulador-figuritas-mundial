package escenarios;

import codigoNegocio.Usuario;
import generador.Generador;

public interface Escenario {
	
	
	public void simular(Usuario u, Generador g);
	public void generarPaquete(Usuario u, Generador g);
	public void agregarFigurita(Usuario u, int i);
	public int getCantUsuarios();
	
	

}
