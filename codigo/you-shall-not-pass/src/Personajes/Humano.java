package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Juego;
public class Humano extends Aliado {
	
	public Humano(Juego j) {
		super(j);
		precioAliado=10;
		rango=1;
		vida=50;
		damage=12;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Aragorn1.png"));
		grafico=new JLabel(sprite);
	}
}
