package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enano extends Aliado{
	public Enano() {
		super(25,70);
		precioAliado=16;
		rango=1;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Gimli.png"));
		grafico=new JLabel(sprite);
	}
}
