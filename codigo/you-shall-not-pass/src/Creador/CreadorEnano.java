package Creador;

import javax.swing.JOptionPane;

import Logica.Juego;
import Personajes.Enano;

public class CreadorEnano extends CreadorAliado {

	public CreadorEnano(Juego j) {
		super(j);
	}


	public void crear(int x, int y) {
		Enano e = new Enano(juego.getMapa());
		if (e.getPrecioAliado() <= juego.getAritmetica().getMonedas())
			juego.getManipulador().colocarAliado(new Enano(juego.getMapa()), x, y);
		else
			JOptionPane.showMessageDialog(null, "NO TENES MONEDAS!", "Monedas insuficientes", JOptionPane.INFORMATION_MESSAGE);
	}

}
