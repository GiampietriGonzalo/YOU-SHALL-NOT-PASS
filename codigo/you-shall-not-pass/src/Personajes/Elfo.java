package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Elfo extends Aliado {
	
	public Elfo() {
		super(18,70);
		precioAliado=12;
		rango=3;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Legolas.png"));
		grafico=new JLabel(sprite);
	}


	public int getVidaOriginal() {
		return 70;
	}
}
