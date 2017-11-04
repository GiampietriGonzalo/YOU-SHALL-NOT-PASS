package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Nazgul extends Enemigo {

	public Nazgul() {
		super(20,60);
		rango=0;
		velocidad=16;
		puntos=20;
		monedas=7;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Nazgul.png"));
		grafico=new JLabel(sprite);
	}

	public int getVidaOriginal() {
		return 60;
	}

}

