package simulador;

import codigoNegocio.Usuario;
import generador.Generador;

public interface Simulador {
	
	
	public void simular(Usuario u, Generador g);
	public void generarPaquete(Usuario u, Generador g);
	public void agregarFigurita(Usuario u, int i);
	public int getCantUsuarios();
	
	

}
