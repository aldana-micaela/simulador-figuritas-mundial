package codigoNegocio;

import java.util.ArrayList;

import escenarios.Escenario;

public class Instancia {
	
	private int cantFiguritas;
	private int cantFiguritasXPaquete; 
	private Escenario escenario;
	private int cantUsuarios;
	
	private ArrayList<Usuario> users;
	
	
	public Instancia (int cantFiguritas, int figuritasXPaquete, Escenario e) {
		this.cantFiguritas=cantFiguritas;
		this.cantFiguritasXPaquete=figuritasXPaquete;
		this.escenario = e;
		this.cantUsuarios= escenario.getCantUsuarios();
		
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

	public Escenario getEscenario() {
		return escenario;
	}
	
	public ArrayList <Usuario> getUsers() {
		return users;
	}
	


	
	

}
