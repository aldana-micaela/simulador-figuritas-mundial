Fpackage escenarios;

import java.util.ArrayList;

import codigoNegocio.Usuario;
import generador.Generador;

public class Escenario3 implements Escenario {

	private int cantUsuarios;

	public Escenario3 (int cantUsuario) {
		this.cantUsuarios = cantUsuario;

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
	public void simular(Generador g, ArrayList<Usuario> lista) {
		for (Usuario u : lista)
			if (!u.estaCompleto())
				generarPaquete(u, g);

		intercambiarRepetidas(lista);

	}

	private void intercambiarRepetidas(ArrayList<Usuario> lista) {
		for (Usuario user1 : lista) {

			for (Usuario user2 : lista)

				if (user1.getNumeroUsuario() != user2.getNumeroUsuario()) {

					for (int i = 0; i < user1.getCantFiguritas(); i++) {

						if (user1.getFiguritasRepetidas()[i] > 0 && user2.getAlbumFiguritas()[i] == false) {

							for (int k = 0; k < user1.getCantFiguritas(); k++) {

								if (user2.getFiguritasRepetidas()[k] > 0 && user1.getAlbumFiguritas()[k] == false) {

									user2.agregarFigurita(i);
									user2.decrementarFiguritasRepetidas(i);
									user2.incrementarIntercambiadas();

									user1.agregarFigurita(k);
									user1.decrementarFiguritasRepetidas(k);
									user1.incrementarIntercambiadas();

								}

							}
						}
					}
				}

		}

	}

	@Override
	public int getCantUsuarios() {
		return cantUsuarios;
	}

}
