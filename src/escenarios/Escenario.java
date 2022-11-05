package escenarios;

import java.util.ArrayList;

import generador.Generador;
import simuladores.Usuario;

public interface Escenario {

	public void simular(Generador g, ArrayList<Usuario> lista);

	public void generarPaquete(Usuario u, Generador g);

	public int getCantUsuarios();

}
