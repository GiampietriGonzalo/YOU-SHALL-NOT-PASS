package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Troll extends Enemigo {
	
	public Troll() {
		super(60,70);
		velocidad=32;
		puntos=20;
		monedas=7;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/troll.png"));
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
	}

	@Override
	public int getVidaOriginal() {
		return 70;
	}
}
