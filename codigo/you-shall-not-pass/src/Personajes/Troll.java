package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Troll extends Enemigo {
	
	public Troll() {
		super(60,70);
		velocidad=32;
		puntos=20;
		monedas=7;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Troll.gif"));
		grafico=new JLabel(sprite);
		sprite.setImageObserver(grafico);
		grafico.setBackground(null);
	}

	public int getVidaOriginal() {
		return 70;
	}
}
