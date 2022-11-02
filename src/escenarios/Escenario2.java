package escenarios;

import java.util.ArrayList;

import codigoNegocio.Usuario;
import generador.Generador;

public class Escenario2 implements Escenario {

	private int cantUsuarios;

	public Escenario2(int cantUsuario) {
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

		donarRepetidas(lista);

	}

	public void donarRepetidas(ArrayList<Usuario> lista) {

		for (Usuario user : lista) {

			for (Usuario u : lista) {

				if (user.getNumeroUsuario() != u.getNumeroUsuario()) {

					for (int i = 0; i < u.getCantFiguritas(); i++) {

						if (user.getFiguritasRepetidas()[i] > 0 && u.getAlbumFiguritas()[i] == false) {
							u.agregarFigurita(i);
							user.decrementarFiguritasRepetidas(i);
							user.incrementarDonadas();

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
