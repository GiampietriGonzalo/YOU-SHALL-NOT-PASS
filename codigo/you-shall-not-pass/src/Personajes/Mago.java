package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Juego;

public class Mago extends Aliado {
	
	public Mago(Juego j) {
		super(j);
		precioAliado=50;
		rango=2;
		vida=50;
		damage=30;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/GandalfElBlanco.png"));
		grafico=new JLabel(sprite);
	}
	
}
