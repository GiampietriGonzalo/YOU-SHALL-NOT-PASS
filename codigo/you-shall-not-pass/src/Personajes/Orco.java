package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Orco extends Enemigo {
	
 
	
	public Orco() {
		super(300);
		rango=4;
		velocidad=32;
		puntos=20;	
		monedas=7;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Orco.png"));
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
		
	}
}
