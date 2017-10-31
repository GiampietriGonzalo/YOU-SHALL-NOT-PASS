package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Troll extends Enemigo {
	
	public Troll() {
		super(60,70);
		velocidad=32;
		puntos=20;
		monedas=7;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Saruman.png"));
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
	}
}
