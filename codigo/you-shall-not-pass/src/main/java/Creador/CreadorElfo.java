package Creador;

import javax.swing.JOptionPane;

import Logica.Juego;
import Personajes.Elfo;

/**
 * Concret factory para Elfos.
 * */

public class CreadorElfo extends CreadorAliado {

	public CreadorElfo(Juego j) {
		super(j);
	}
	
	public void crear(int x, int y) {
		Elfo e = new Elfo(juego.getMapa());
		if (e.getPrecioAliado() <= juego.getAritmetica().getMonedas())
			juego.getManipulador().colocarAliado(new Elfo(juego.getMapa()), x, y);
		else
			JOptionPane.showMessageDialog(null, "NO TENES MONEDAS!", "Monedas insuficientes", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
