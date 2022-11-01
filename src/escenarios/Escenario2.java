package escenarios;

import java.util.ArrayList;

import codigoNegocio.Usuario;
import generador.Generador;

public class Escenario2 implements Escenario {

	private int cantUsuarios;
	ArrayList<Usuario> lista;
	private int donadas;

	public Escenario2(int cantUsuario) {
		this.cantUsuarios = cantUsuario;
		this.donadas = 0;

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
	public void simular(Usuario u, Generador g, ArrayList<Usuario> lista) {
		this.lista = lista;
		generarPaquete(u, g);

	}

	public void donarRepetidas(Usuario user) {

		for (Usuario u : lista) {

			if (user.getNumeroUsuario() != u.getNumeroUsuario()) {

				for (int i = 0; i < u.getCantFiguritas(); i++) {

					if (user.getFiguritasRepetidas()[i] > 0 && u.getAlbumFiguritas()[i] == false) {
						u.getAlbumFiguritas()[i] = true;
						u.incrementarFiguritasAcertadas();
						user.decrementarFiguritasRepetidas(i);
						donadas++;

					}
				}
			}

		}

	}

	@Override
	public int getCantUsuarios() {

		return cantUsuarios;
	}
	
	

	public int getNoDonadas() {
		int i=0;
		
		for(Usuario u: lista) {
			for(int j=0; j<u.getCantFiguritas(); j++) {
				
				i = i + u.getFiguritasRepetidas()[j];
			}
		}
		return i;
	}
	public int getDonadas() {

		return donadas;
	}

}
