package codigoNegocio;

public class Usuario {

	private int numeroUsuario;
	private boolean[] albumFiguritas;
	private int[] figuritasRepetidas;


	private int figuritasAcertadas;
	private Instancia instancia;

	public Usuario(Instancia instancia, int i) {
		this.instancia = instancia;
		this.albumFiguritas = new boolean[instancia.getCantFiguritas()];
		this.figuritasRepetidas = new int[instancia.getCantFiguritas()];
		this.numeroUsuario=i;

	}


	public boolean estaCompleto() {


		return getFiguritasAcertadas()== getCantFiguritas();
	}
	
	
	public void agregarFigurita(int i) {
		
		if(getAlbumFiguritas()[i]==false) {
			getAlbumFiguritas()[i]=true;
			incrementarFiguritasAcertadas();
		}
		else {
			figuritasRepetidas[i]++;
		}
	}
	
	public void incrementarFiguritasAcertadas() {
		figuritasAcertadas++;
	}
	public void decrementarFiguritasRepetidas(int i ) {
		if(figuritasRepetidas[i]>0)
			figuritasRepetidas[i]--;
	}

	public boolean[] getAlbumFiguritas() {
		return albumFiguritas;
	}
	public boolean getAlbumFigurita(int i) {
		return albumFiguritas[i];
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
	
	


}
