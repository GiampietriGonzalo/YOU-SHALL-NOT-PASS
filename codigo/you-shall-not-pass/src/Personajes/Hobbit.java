package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Hobbit extends Aliado {
	
	public Hobbit() {
		precioAliado=10;
		rango=1;
		vida=40;
		damage=15;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Sam.png"));
		grafico=new JLabel(sprite);
	}
	
}
