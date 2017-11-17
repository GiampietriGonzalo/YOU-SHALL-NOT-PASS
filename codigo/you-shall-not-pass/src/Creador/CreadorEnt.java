package Creador;

import javax.swing.JOptionPane;

import Logica.Juego;
import Personajes.Ent;

public class CreadorEnt extends CreadorAliado {

	public CreadorEnt(Juego j) {
		super(j);
	}

	public void crear(int x, int y) {
		if(y<5){
			Ent e = new Ent(juego.getMapa());
		if (e.getPrecioAliado() <= juego.getAritmetica().getMonedas())
			juego.getManipulador().colocarAliado(new Ent(juego.getMapa()), x, y);
		else
			JOptionPane.showMessageDialog(null, "NO TENES MONEDAS!", "Monedas insuficientes", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}



