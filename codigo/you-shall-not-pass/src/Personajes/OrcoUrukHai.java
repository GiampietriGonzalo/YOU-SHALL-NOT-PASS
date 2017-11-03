package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class OrcoUrukHai extends Enemigo {
	
	public OrcoUrukHai() {
		super(30,40);
		velocidad=32;
		puntos=20;
		monedas=7;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/UrukHai.png"));
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
	}

	@Override
	public int getVidaOriginal() {
		return 40;
	}
}
