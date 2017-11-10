package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Mapa;

public class Humano extends Aliado {
	
	public Humano(Mapa m) {
		
		super(m,30,50);
		precioAliado=15;
		rango=0;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Humano2.gif"));
		grafico=new JLabel(sprite);
		sprite.setImageObserver(grafico);
		
	}


	public int getVidaOriginal() {
		return 50;
	}
	
	public void eliminar(){
		mapa.eliminarObjeto(this, x, y);
	}
}
