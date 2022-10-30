package escenarios;

import codigoNegocio.Usuario;

import generador.Generador;

public class Escenario1 implements Escenario {

	@Override
	public void generarPaquete(Usuario u, Generador g) {

		int i = 0;
		while (i < u.getCantFiguritasXPaquete()) {

			agregarFigurita(u, g.nextInt(u.getCantFiguritas()));

			i++;
		}
	}

	@Override
	public void agregarFigurita(Usuario u, int random) {

		if (u.getFigurita(random) == false) {
			u.agregarFigurita(random);
			u.incrementarFiguritasAcertadas();
		}
	}

	@Override
	public void simular(Usuario u, Generador g) {
		generarPaquete(u, g);

	}

	@Override
	public int getCantUsuarios() {
		return 1;
	}

}
