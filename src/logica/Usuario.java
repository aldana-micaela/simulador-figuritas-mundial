package logica;

public class Usuario {

	private Albumn albumn;
	private int cantCompras;
	public Usuario(int cantDeFigus) {
		this.albumn = new Albumn(cantDeFigus);
		this.cantCompras = 0;
	}
	
	public void comprarPaqueteFiguritas() {
		cantCompras++;
	}
}
