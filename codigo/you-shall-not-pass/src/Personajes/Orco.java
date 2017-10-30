package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Orco extends Enemigo {
	
	private int damage=30;
	
	public Orco() {
		super();
		rango=0;
		velocidad=32;
		puntos=20;	
		monedas=7;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Orco.png"));
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
		
	}
}
