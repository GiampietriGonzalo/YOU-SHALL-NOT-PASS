package Creador;

import javax.swing.JOptionPane;

import Logica.Juego;
import Personajes.Enano;
import Personajes.Potenciado;

public class CreadorEnanoPotenciado extends CreadorAliado {

	public CreadorEnanoPotenciado(Juego j) {
		super(j);
	}


	public void crear(int x, int y) {
		Enano e = new Enano(juego.getMapa());
		e.setEstado(new Potenciado(e));
		if (e.getPrecioAliado() <= juego.getAritmetica().getMonedas())
			juego.getManipulador().colocarAliado(e, x, y);
		else
			JOptionPane.showMessageDialog(null, "NO TENES MONEDAS!", "Monedas insuficientes", JOptionPane.INFORMATION_MESSAGE);
	}
}