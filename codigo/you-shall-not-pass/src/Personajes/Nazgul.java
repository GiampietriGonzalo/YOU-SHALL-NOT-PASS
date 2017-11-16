package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Mapa;

public class Nazgul extends Enemigo {

	public Nazgul(Mapa m) {
		super(m,20,60);
		rango=0;
		velocidad=16;
		puntos=20;
		monedas=7;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Nazgul.gif"));
		grafico=new JLabel(sprite);
		sprite.setImageObserver(grafico);
	}
	
	public int getVidaOriginal() {
		return 60;
	}

}

