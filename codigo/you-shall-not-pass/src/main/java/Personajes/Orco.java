package Personajes;

import javax.swing.*;

import Logica.Mapa;

public class Orco extends Enemigo {
	
	public Orco(Mapa m) {
		super(m,2,10);
		rango=0;
		velocidad=8;
		puntos=10;	
		monedas=5;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Orco.gif"));
		grafico=new JLabel(sprite);
		sprite.setImageObserver(grafico);
		grafico.setBackground(null);
		
	}

	
	
	public int getVidaOriginal() {
		return 10;
	}
	
}
