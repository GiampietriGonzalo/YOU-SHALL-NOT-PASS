package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Mapa;

public class Troll extends Enemigo {
	
	public Troll(Mapa m) {
		super(m,3,25);
		velocidad=7;
		puntos=24;
		monedas=12;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Troll.gif"));
		grafico=new JLabel(sprite);
		sprite.setImageObserver(grafico);
		grafico.setBackground(null);
	}
	
	public int getVidaOriginal() {
		return 20;
	}
}
