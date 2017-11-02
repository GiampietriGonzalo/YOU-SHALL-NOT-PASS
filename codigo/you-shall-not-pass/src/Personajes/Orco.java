package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Orco extends Enemigo {
	
	public Orco() {
		super(20,30);
		rango=0;
		velocidad=8;
		puntos=20;	
		monedas=7;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Orco.png"));
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
		
	}

	@Override
	public int getVidaOriginal() {
		// TODO Auto-generated method stub
		return 30;
	}
}
