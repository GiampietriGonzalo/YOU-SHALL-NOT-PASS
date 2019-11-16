package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Mapa;

public class OrcoUrukHai extends Enemigo {
	
	public OrcoUrukHai(Mapa m) {
		super(m,3,15);
		velocidad=9;
		puntos=14;
		monedas=7;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/OrcoUrukHai.gif"));
		grafico=new JLabel(sprite);
		sprite.setImageObserver(grafico);
		grafico.setBackground(null);
	}

	public int getVidaOriginal() {
		return 15;
	}
}
