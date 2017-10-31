package GUI;

import javax.swing.JOptionPane;

import Logica.Juego;

public class Contador extends Thread {

	private Juego elJuego;
	protected volatile boolean terminar = false;
	String [] LO;
	
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
			terminar=elJuego.termino();
		}
		int reinicio=JOptionPane.showConfirmDialog(null,"Perdiste! Queres reiniciar el juego?","Game Over",JOptionPane.YES_NO_OPTION);
		if(reinicio==0) {
			GUI_Bienvenida.main(LO);
		}
		else System.exit(0);
		
	}
}
