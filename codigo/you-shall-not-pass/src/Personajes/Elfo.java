package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Juego;

public class Elfo extends Aliado {
	
	public Elfo(Juego j) {
		super(j);
		precioAliado=12;
		rango=3;
		vida=70;
		damage=18;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Legolas.png"));
		grafico=new JLabel(sprite);
	}
}
