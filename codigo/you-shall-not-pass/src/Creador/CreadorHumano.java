package Creador;

import javax.swing.JOptionPane;

import Logica.Juego;
import Personajes.Humano;

/**
 * Concret factory para Humanos.
 * */

public class CreadorHumano extends CreadorAliado{

	public CreadorHumano(Juego j) {
		super(j);
	}

	public void crear(int x, int y) {
		Humano e = new Humano(juego.getMapa());
		if (e.getPrecioAliado() <= juego.getAritmetica().getMonedas())
			juego.getManipulador().colocarAliado(new Humano(juego.getMapa()), x, y);
		else
			JOptionPane.showMessageDialog(null, "NO TENES MONEDAS!", "Monedas insuficientes", JOptionPane.INFORMATION_MESSAGE);
	}
}