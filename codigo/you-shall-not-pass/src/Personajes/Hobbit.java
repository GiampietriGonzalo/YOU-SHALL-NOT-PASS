package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Juego;

public class Hobbit extends Aliado {
	
	public Hobbit(Juego j) {
		super(j);
		precioAliado=10;
		rango=1;
		vida=40;
		damage=15;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Sam.png"));
		grafico=new JLabel(sprite);
	}
	
}
