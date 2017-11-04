package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Humano extends Aliado {
	
	public Humano() {
		
		super(30,50);
		precioAliado=15;
		rango=0;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Aragorn1.png"));
		grafico=new JLabel(sprite);
		
	}


	public int getVidaOriginal() {
		return 50;
	}
}
