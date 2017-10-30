package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Humano extends Aliado {
	
	public Humano() {
		precioAliado=10;
		rango=1;
		vida=50;
		damage=12;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Aragorn1.png"));
		grafico=new JLabel(sprite);
	}
}
