package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Juego;

public class MagoOscuro extends Enemigo {

	public MagoOscuro(Juego j) {
		super(j);
		vive=true;
		velocidad=32;
		puntos=20;
		monedas=7;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Saruman.png"));
		grafico=new JLabel(sprite);
	}
	
}
