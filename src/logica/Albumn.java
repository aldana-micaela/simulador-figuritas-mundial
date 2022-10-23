package logica;

public class Albumn {
	
	private boolean[] figuritas; 
	private int[] repetidas;
	private int cantFiguritas;
	
	
	public Albumn(int cantFiguritas) {;
		this.figuritas = new boolean[cantFiguritas];
		this.repetidas = new int[cantFiguritas];
		this.cantFiguritas = cantFiguritas;
	}
	
	
	public void agregarFiguritas(int numerofigurita) {
		if(figuritas[numerofigurita]==true) {
			repetidas[numerofigurita]=repetidas[numerofigurita]+1;
		}else {
			figuritas[numerofigurita]=true;

		}
	}
	
	

}
