package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Logica.Juego;

public class Nazgul extends Enemigo {

	public Nazgul(Juego j) {
		super(j);
		vive=true;
		velocidad=32;
		puntos=20;
		monedas=7;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Malo.png"));
		grafico=new JLabel(sprite);
	}

}

