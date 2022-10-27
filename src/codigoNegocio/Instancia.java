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
		
		for(int i =0; i<cantUsuarios; i++)
			users.add(new Usuario(this));
		
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
	
	public Usuario getUsers() {
		return users.get(0);
	}

	
	

}
