package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Mapa;

public class OrcoUrukHai extends Enemigo {
	
	public OrcoUrukHai(Mapa m) {
		super(m,30,40);
		velocidad=32;
		puntos=20;
		monedas=7;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/UrukHai.gif"));
		grafico=new JLabel(sprite);
		sprite.setImageObserver(grafico);
		grafico.setBackground(null);
	}

	@Override
	public int getVidaOriginal() {
		return 40;
	}
}
