package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Mago extends Aliado {
	
	public Mago() {
		super(40,80);
		precioAliado=50;
		rango=2;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Gandalf.gif"));
		grafico=new JLabel(sprite);
	}


	public int getVidaOriginal() {
		return 80;
	}
	
}
