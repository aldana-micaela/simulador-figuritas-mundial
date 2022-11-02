package codigoNegocio;

import java.util.ArrayList;

import escenarios.Escenario;

public class Instancia {
	
	private int cantFiguritas;
	private int cantFiguritasXPaquete; 
	private Escenario escenario;
	private int cantUsuarios;
	private int cantSimulacion;

	
	private ArrayList<Usuario> users;
	
	
	public Instancia (int cantFiguritas, int figuritasXPaquete, Escenario e, int cantSimulaciones) {
		this.cantFiguritas=cantFiguritas;
		this.cantFiguritasXPaquete=figuritasXPaquete;
		this.escenario = e;
		this.cantUsuarios= escenario.getCantUsuarios();
		this.cantSimulacion= cantSimulaciones;

		
		users = new ArrayList<Usuario>(cantUsuarios);
		
		for(int i =1; i<=cantUsuarios; i++)
			users.add(new Usuario(this, i));
		
	}

	public int getCantFiguritas() {
		return cantFiguritas;
	}

	public int getCantFiguritasXPaquete() {
		return cantFiguritasXPaquete;
	}
	public int getCantSimulacion() {
		return cantSimulacion;
	}

	public Escenario getEscenario() {
		return escenario;
	}
	
	public ArrayList <Usuario> getUsers() {
		return users;
	}
	


	
	

}
