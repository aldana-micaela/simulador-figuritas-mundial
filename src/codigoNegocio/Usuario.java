package codigoNegocio;

public class Usuario {

	private boolean[] albumFiguritas;
	private int[] figuritasRepetidas;
	private int figuritasAcertadas;
	private Instancia instancia;

	public Usuario(Instancia instancia) {
		this.instancia = instancia;
		this.albumFiguritas = new boolean[instancia.getCantFiguritas()];

	}


	public boolean estaCompleto() {
		boolean estaCompleto = true;

		for (int i = 0; i < albumFiguritas.length; i++) {

			if (albumFiguritas[i]) {
				estaCompleto = estaCompleto && true;
			} else {
				estaCompleto = false;
			}
		}
		return estaCompleto;

//		return figuritasAcertadas==cantFiguritas;
	}
	
	
	public void agregarFigurita(int i) {
		if(getFiguritas()[i]=true) {
			agregarFiguritaRepetida(i);
		}
		getFiguritas()[i]=true;
	}
	
	public void incrementarFiguritasAcertadas() {
		figuritasAcertadas++;
	}

	public boolean[] getFiguritas() {
		return albumFiguritas;
	}
	public boolean getFigurita(int i) {
		return albumFiguritas[i];
	}

	public int getCantFiguritas() {
		return instancia.getCantFiguritas();
	}

	public int getCantFiguritasXPaquete() {
		return instancia.getCantFiguritasXPaquete();
	}

	public int getFiguritasAcertadas() {
		return figuritasAcertadas;
	}
	
	private void agregarFiguritaRepetida(int i) {
		figuritasRepetidas[i]+=1;
	}


	public int damefiguritaRepetida() {
	int figurita = 0;
	for(int f: figuritasRepetidas) {
		if(0< f) {
			figurita=f;
		}
	}
		return figurita ;
	}


	public boolean estaFigurita(int f1) {
		return getFiguritas()[f1]=true;
	}


}
