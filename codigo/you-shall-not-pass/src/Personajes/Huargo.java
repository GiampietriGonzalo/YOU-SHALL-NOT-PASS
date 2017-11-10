package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Mapa;

public class Huargo extends Enemigo {
	
	public Huargo(Mapa m){
		super(m,20,30);
		velocidad=10;
		puntos=20;
		monedas=7;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Huargo.gif"));
		grafico=new JLabel(sprite);
		sprite.setImageObserver(grafico);
		grafico.setBackground(null);
	}


	public int getVidaOriginal() {
		return 30;
	}
}
