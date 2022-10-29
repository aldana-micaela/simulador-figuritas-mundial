package escenarios;

import codigoNegocio.Usuario;
import generador.Generador;

public class Escenario2 implements Escenario {

	private int cantUsuarios;

	public Escenario2 (int cantUsuario) {
		this.cantUsuarios = cantUsuario;
		
	}
	
	
	@Override
	public void generarPaquete(Usuario u, Generador g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarFigurita(Usuario u, int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCantUsuarios() {
		return cantUsuarios;
	}

	@Override
	public void simular(Usuario u, Generador g) {
		// TODO Auto-generated method stub
		
	}


	
}
