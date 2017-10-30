package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Mago extends Aliado {
	private int damage=30;
	public Mago() {
		super();
		precioAliado=50;
		rango=2;
		vida=50;
		
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/GandalfElBlanco.png"));
		grafico=new JLabel(sprite);
	}
	
}
