package Personajes;

import javax.swing.*;
import javax.swing.JLabel;

import Logica.Mapa;

public class Orco extends Enemigo {
	
	public Orco(Mapa m) {
		super(m,20,30);
		rango=0;
		velocidad=8;
		puntos=20;	
		monedas=7;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Orco.gif"));
		grafico=new JLabel(sprite);
		sprite.setImageObserver(grafico);
		grafico.setBackground(null);
		
	}

	public int getVidaOriginal() {
		return 30;
	}
}
