package observador;

import javax.swing.JLabel;

import codigoNegocio.Simulador;

public class ObservadorPorInterfaz implements Observador{
	
	private Simulador simulador;
	
	private String observador;
	
	public ObservadorPorInterfaz(Simulador s) {
		this.simulador= s;
	}

	@Override
	public void notificar() {
		System.out.print("Paquete: " + simulador.getIteracion());
		System.out.print(" figuritasAcertadas: " + simulador.getUsuario().getFiguritasAcertadas() + "/" + simulador.getCantFiguritas());
		System.out.println();
		
		observador = ("Paquete: " + simulador.getIteracion() + " Figuritas acertadas: "
				+ simulador.getUsuario().getFiguritasAcertadas() + "/" + simulador.getCantFiguritas());

	}
	
	public String getObservador() {
		return observador;
	}

}
