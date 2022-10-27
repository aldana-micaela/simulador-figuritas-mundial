package codigoNegocio;

import java.util.ArrayList;

import escenarios.Escenario;

public class Instancia {
	
	private int cantFiguritas;
	private int cantFiguritasXPaquete; 
	private Escenario simulador;
	private int cantUsuarios;
	
	private ArrayList<Usuario> users;
	
	
	public Instancia (int cantFiguritas, int figuritasXPaquete, Escenario simulacion) {
		this.cantFiguritas=cantFiguritas;
		this.cantFiguritasXPaquete=figuritasXPaquete;
		this.simulador = simulacion;
		this.cantUsuarios= simulador.getCantUsuarios();
		
		users = new ArrayList<Usuario>(cantUsuarios);
		
		for(int i =0; i<cantUsuarios; i++)
			users.add(new Usuario(this));
		
	}

	public int getCantFiguritas() {
		return cantFiguritas;
	}

	public int getCantFiguritasXPaquete() {
		return cantFiguritasXPaquete;
	}

	public Escenario getSimulador() {
		return simulador;
	}
	
	public Usuario getUsers() {
		return users.get(0);
	}

	
	

}
