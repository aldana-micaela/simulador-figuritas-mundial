package escenarios;

import java.util.ArrayList;

import codigoNegocio.Usuario;
import generador.Generador;

public class Escenario3 implements Escenario {

	private int cantUsuarios;
	private int intercambiadas;
	ArrayList<Usuario> lista;

	public Escenario3(int cantUsuario) {
		this.cantUsuarios = cantUsuario;
		this.intercambiadas = 0;

	}

	@Override
	public void generarPaquete(Usuario u, Generador g) {
		int i = 0;
		while (i < u.getCantFiguritasXPaquete()) {

			u.agregarFigurita(g.nextInt(u.getCantFiguritas()));
			donarRepetidas(u);

			i++;
		}

	}

	@Override
	public int getCantUsuarios() {
		return cantUsuarios;
	}

	@Override
	public void simular(Usuario u, Generador g, ArrayList<Usuario> lista) {
		this.lista = lista;
		generarPaquete(u, g);

	}

	private void donarRepetidas(Usuario user) {
		int f=0;
		for (Usuario u : lista) {

			if (user.getNumeroUsuario() != u.getNumeroUsuario()) {

				for (int i = 0; i < u.getCantFiguritas(); i++) {
					f=intercambioDefiguritas(user,u);
					if (user.getFiguritasRepetidas()[i] > 0 && u.getAlbumFiguritas()[i] && f>0) {
						
							u.getAlbumFiguritas()[i] = true;
							u.incrementarFiguritasAcertadas();
							user.decrementarFiguritasRepetidas(i);
							intercambiadas++;
							
							user.getAlbumFiguritas()[f] =true;
							user.incrementarFiguritasAcertadas();
							u.decrementarFiguritasRepetidas(f);
							intercambiadas++;
						
						
					}
				}
			}

		}

	}

	private int intercambioDefiguritas(Usuario user, Usuario u) {
		for (int i = 0; i < u.getCantFiguritas(); i++) {
			if(u.getFiguritasRepetidas()[i] > 0 && user.getAlbumFiguritas()[i]) {
				return i;
			}
		}
		return -1;
	}

	public int getDonadas() {

		return intercambiadas;
	}

	@Override
	public int getNoDonadas() {
		int i = 0;

		for (Usuario u : lista) {
			for (int j = 0; j < u.getCantFiguritas(); j++) {

				i = i + u.getFiguritasRepetidas()[j];
			}
		}
		return i;
	}

}
