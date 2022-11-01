package observador;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

import codigoNegocio.Simulador;
import codigoNegocio.Usuario;

public class ObservadorPorInterfaz implements Observador {

	private Simulador simulador;
	private JLabel label;
	private JProgressBar barra;
	int figuritasAcertadas=0;

	public ObservadorPorInterfaz(Simulador s, JLabel label, JProgressBar barra) {
		this.simulador = s;
		this.label = label;
		this.barra = barra;
		
	}

	@Override
	public void notificar(Usuario u) {

		System.out.print(" Usuario: " + u.getNumeroUsuario());
		System.out.print(" Paquete: " + simulador.getIteracion());
		System.out.print(" figuritasAcertadas: " + u.getFiguritasAcertadas()+ "/" + simulador.getCantFiguritas());
		System.out.print(" donadas/intercambiadas: " + simulador.getEscenario().getDonadas());
		System.out.print(" NO donadas/intercambiadas: " + simulador.getEscenario().getNoDonadas());
		System.out.println();

//		label.setText(" Usuario: " + u.getNumeroUsuario() + " Paquete: " + simulador.getIteracion() + " Figuritas acertadas: "
//				+ u.getFiguritasAcertadas() + "/" + simulador.getCantFiguritas());
		label.setText(" Usuario: " + u.getNumeroUsuario() + " Paquete: " + u.getPaquetes() + " Figuritas acertadas: "
				+ u.getFiguritasAcertadas() + "/" + simulador.getCantFiguritas());

		
		barra.setValue(total());

	}
	
	private int total() {
		int tot=0;
		for(Usuario u: simulador.getUsuarios()) {
			tot= tot+u.getFiguritasAcertadas();
		}
		return tot;
	}
	
	

}
