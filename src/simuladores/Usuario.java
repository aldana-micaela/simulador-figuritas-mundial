package simuladores;

public class Usuario {

	private int numeroUsuario;
	private boolean[] albumFiguritas;
	private int[] figuritasRepetidas;
	private int figuritasAcertadas;
	private int paquetes;
	private int donadas;
	private int intercambiadas;
	private Instancia instancia;

	public Usuario(Instancia instancia, int i) {
		this.instancia = instancia;
		this.albumFiguritas = new boolean[instancia.getCantFiguritas()];
		this.figuritasRepetidas = new int[instancia.getCantFiguritas()];
		this.numeroUsuario = i;
		this.paquetes = 0;
		this.donadas = 0;
		this.intercambiadas = 0;

	}

	public boolean estaCompleto() {
		return getFiguritasAcertadas() == getCantFiguritas();
	}

	public void agregarFigurita(int i) {

		if (getAlbumFiguritas()[i] == false) {
			getAlbumFiguritas()[i] = true;
			figuritasAcertadas++;
		} else {
			figuritasRepetidas[i]++;
		}
	}

	public void decrementarFiguritasRepetidas(int i) {
		if (figuritasRepetidas[i] > 0)
			figuritasRepetidas[i]--;
	}

	public boolean[] getAlbumFiguritas() {
		return albumFiguritas;
	}

	public int getCantFiguritas() {
		return instancia.getCantFiguritas();
	}

	public int getNumeroUsuario() {
		return numeroUsuario;
	}

	public int getCantFiguritasXPaquete() {
		return instancia.getCantFiguritasXPaquete();
	}

	public int getFiguritasAcertadas() {
		return figuritasAcertadas;
	}

	public int[] getFiguritasRepetidas() {
		return figuritasRepetidas;
	}

	public int getPaquetes() {

		return this.paquetes;
	}

	public int getDonadas() {

		return this.donadas;
	}

	public int getIntercambiadas() {

		return this.intercambiadas;
	}

	public void incrementarDonadas() {
		this.donadas++;
	}

	public void incrementarIntercambiadas() {
		this.intercambiadas++;

	}

	public void incrementarPaquete() {
		this.paquetes++;

	}

	public int getCantFiguritasRepetidas() {
		int i = 0;

		for (int j = 0; j < albumFiguritas.length; j++) 
				i = i + figuritasRepetidas[j];
		

		return i;

	}

}
