package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Mapa;

public class Humano extends Aliado {
	
	public Humano(Mapa m) {
		
		super(m,2,15);
		precioAliado=15;
		rango=0;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Humano.gif"));
		grafico=new JLabel(sprite);
		sprite.setImageObserver(grafico);
		
	}

	public int getVidaOriginal() {
		return 15;
	}
	
	public int getDamageOriginal() {
		return 2;
	}
	
	public int getRangoOriginal() {
		return 0;
	}
	
	
	public void eliminar(){
		mapa.eliminarObjeto(this, x, y);
	}
}
