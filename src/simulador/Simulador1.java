package simulador;

import codigoNegocio.Usuario;
import generador.Generador;

public class Simulador1 implements Simulador {

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
		int iteracion = 0;

		while (!u.estaCompleto()) {

			generarPaquete(u, g);

			System.out.print("Paquete: " + iteracion);
			System.out.print(" figuritasAcertadas: " + u.getFiguritasAcertadas() + "/" + u.getCantFiguritas());
			System.out.println();

			iteracion++;
		}

	}

	@Override
	public int getCantUsuarios() {
		return 1;
	}

}
