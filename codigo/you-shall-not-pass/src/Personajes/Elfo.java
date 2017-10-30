package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Elfo extends Aliado {
	private int damage=18;
	public Elfo() {
		super();
		precioAliado=12;
		rango=3;
		vida=70;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Legolas.png"));
		grafico=new JLabel(sprite);
	}
}
