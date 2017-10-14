package GUI;

import Logica.Juego;

public class Contador extends Thread {

	private Juego elJuego;
	
	Contador(Juego j) {
		elJuego = j;
	}

	public void run() {
		while(true){
			elJuego.actualizar();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				
		}
	}
}
