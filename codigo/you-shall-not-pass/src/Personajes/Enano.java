package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enano extends Aliado{
	public Enano() {
		precioAliado=16;
		rango=1;
		vida=70;
		damage=25;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Gimli.png"));
		grafico=new JLabel(sprite);
	}
}
