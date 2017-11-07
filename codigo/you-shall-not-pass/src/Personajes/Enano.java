package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enano extends Aliado{
	
	public Enano() {
		super(300,700);
		precioAliado=16;
		rango=0;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Enano.gif"));
		grafico=new JLabel(sprite);
	}

	public int getVidaOriginal() {
		return 700;
	}
}
