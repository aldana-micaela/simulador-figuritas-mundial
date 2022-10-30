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
		int i = 0;
		while (i < u.getCantFiguritasXPaquete()) {

			agregarFigurita(u, g.nextInt(u.getCantFiguritas()));

			i++;
		}
		
	}

	@Override
	public void agregarFigurita(Usuario u, int i) {
	
			u.agregarFigurita(i);
			u.incrementarFiguritasAcertadas();
		
		
	}

	@Override
	public int getCantUsuarios() {
		return cantUsuarios;
	}

	@Override
	public void simular(Usuario u, Generador g) {
		// TODO Auto-generated method stub
		
	}
	


	public void intercambiarFiguritas(Usuario u1, Usuario u2) {
		int f1= u1.damefiguritaRepetida();
		if(0<f1 && !u2.estaFigurita(f1)) {
		  u2.agregarFigurita(f1);
		}
		
	}
	
}
