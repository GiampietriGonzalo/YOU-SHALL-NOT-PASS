package Creador;

import javax.swing.JOptionPane;

import Logica.Juego;
import Personajes.Hobbit;

/**
 * Concret factory para Hobbits.
 * */


public class CreadorHobbit extends CreadorAliado {

	public CreadorHobbit(Juego j) {
		super(j);
	}


	public void crear(int x, int y) {
		Hobbit e = new Hobbit(juego.getMapa());
		if (e.getPrecioAliado() <= juego.getAritmetica().getMonedas())
			juego.getManipulador().colocarAliado(new Hobbit(juego.getMapa()), x, y);
		else
			JOptionPane.showMessageDialog(null, "NO TENES MONEDAS!", "Monedas insuficientes", JOptionPane.INFORMATION_MESSAGE);
	}

}
