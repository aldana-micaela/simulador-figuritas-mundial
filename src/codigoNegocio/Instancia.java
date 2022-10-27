package codigoNegocio;

import java.util.ArrayList;

import simulador.Simulador;

public class Instancia {
	
	private int cantFiguritas;
	private int cantFiguritasXPaquete; 
	private Simulador simulador;
	private int cantUsuarios;
	
	private ArrayList<Usuario> users;
	
	
	public Instancia (int cantFiguritas, int figuritasXPaquete, Simulador simulacion) {
		this.cantFiguritas=cantFiguritas;
		this.cantFiguritasXPaquete=figuritasXPaquete;
		this.simulador = simulacion;
		this.cantUsuarios= simulador.getCantUsuarios();
	}

	public int getCantFiguritas() {
		return cantFiguritas;
	}

	public int getCantFiguritasXPaquete() {
		return cantFiguritasXPaquete;
	}

	public Simulador getSimulador() {
		return simulador;
	}

	
	

}
