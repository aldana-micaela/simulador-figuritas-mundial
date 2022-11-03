package generador;

import java.util.Random;

public class GeneradorRandom implements Generador {

	private Random random;

	public GeneradorRandom() {
		this.random = new Random();
	}

	@Override
	public int nextInt(int rango) {
		return random.nextInt(rango);
	}

	@Override
	public boolean nextBoolean() {
		return random.nextBoolean();
	}

}
