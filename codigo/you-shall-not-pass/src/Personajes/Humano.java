package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Humano extends Aliado {
	
	protected int damage=30;
	
	public Humano() {
		
		super();
		precioAliado=10;
		rango=0;
		vida=50;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Aragorn1.png"));
		grafico=new JLabel(sprite);
		
	}
}
