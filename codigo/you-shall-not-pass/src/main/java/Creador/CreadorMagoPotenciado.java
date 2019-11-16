package Creador;

import javax.swing.JOptionPane;

import Logica.Juego;
import Personajes.Mago;
import Personajes.Potenciado;

/**
 * Concret factory para Magos potenciados.
 * */

public class CreadorMagoPotenciado extends CreadorAliado {

	public CreadorMagoPotenciado(Juego j) {
		super(j);
	}

	public void crear(int x, int y) {
		Mago e = new Mago(juego.getMapa());
		e.setEstado(new Potenciado(e));
		if (e.getPrecioAliado()+20 <= juego.getAritmetica().getMonedas()){
			juego.getManipulador().colocarAliado(e, x, y);
			juego.getAritmetica().sumarMonedas(-20);
		}
		else
			JOptionPane.showMessageDialog(null, "NO TENES MONEDAS!", "Monedas insuficientes", JOptionPane.INFORMATION_MESSAGE);
	}
}