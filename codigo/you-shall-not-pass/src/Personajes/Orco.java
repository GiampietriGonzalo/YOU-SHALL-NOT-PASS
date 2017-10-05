package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Juego;

public class Orco extends Enemigo {

	public Orco(Juego j) {
		super(j);
		vive=true;
		velocidad=32;
		puntos=20;
		monedas=7;
		//No es un orco pero por ahora sirve
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Malo.png"));
		grafico=new JLabel(sprite);
	}

}
