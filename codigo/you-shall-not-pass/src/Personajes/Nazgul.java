package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Nazgul extends Enemigo {

	public Nazgul() {
		velocidad=32;
		puntos=20;
		monedas=7;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Malo.png"));
		grafico=new JLabel(sprite);
	}

}

