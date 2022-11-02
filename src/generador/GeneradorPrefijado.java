package generador;


public class GeneradorPrefijado implements Generador {
	
	private int cantidadColumnas;
	private int[][] matrizDePaquetes;
	private int columna;
	private int fila;
	
	public GeneradorPrefijado(int cantidadFiguritasXPaquete) {
		this.cantidadColumnas= cantidadFiguritasXPaquete;
	}
	
	
	public void setMatrizDePaquetes(int [][] matriz) {
		
		columna =0;
		this.matrizDePaquetes=matriz;
		
		
	}
	

	@Override
	public int nextInt(int rango) {
		
		if(columna== cantidadColumnas) {
			fila++;
			columna=0;
		}
		
		return matrizDePaquetes[fila][columna++];
	}

	@Override
	public boolean nextBoolean() {
		return false;
	}
}
	