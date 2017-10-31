package GUI;

import javax.swing.JOptionPane;

import Logica.Juego;

public class Contador extends Thread {

	private Juego elJuego;
	protected volatile boolean terminar = false;

	
	Contador(Juego j) {
		elJuego = j;
	}

	public void run() {
		while(!terminar){
			elJuego.actualizar();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
