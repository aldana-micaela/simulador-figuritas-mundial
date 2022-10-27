package generador;

import java.util.Random;

public class GeneradorPrefijado implements Generador {
	
	
	private Random random;
	
	public GeneradorPrefijado() {
		this.random= new Random();
	}
	
	

	@Override
	public int nextInt(int rango) {
		return random.nextInt();
	}

	@Override
	public boolean nextBoolean() {
		return random.nextBoolean();
	}
}
	