package Creador;

import javax.swing.JOptionPane;

import Logica.Juego;
import Personajes.Mago;

/**
 * Concret factory para Magos.
 * */

public class CreadorMago extends CreadorAliado {

	public CreadorMago(Juego j) {
		super(j);
	}

	public void crear(int x, int y) {
		Mago e = new Mago(juego.getMapa());
		if (e.getPrecioAliado() <= juego.getAritmetica().getMonedas())
			juego.getManipulador().colocarAliado(new Mago(juego.getMapa()), x, y);
		else
			JOptionPane.showMessageDialog(null, "NO TENES MONEDAS!", "Monedas insuficientes", JOptionPane.INFORMATION_MESSAGE);
	}

}
