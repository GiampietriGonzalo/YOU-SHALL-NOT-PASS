package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Mapa;

public class Mago extends Aliado {
	
	public Mago(Mapa m) {
		super(m,40,80);
		precioAliado=50;
		rango=3;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Mago.gif"));
		grafico=new JLabel(sprite);
	}


	public int getVidaOriginal() {
		return 80;
	}
	
	public int getDamageOriginal() {
		return 40;
	}
	
	public int getRangoOriginal() {
		return 3;
	}
	
	
	public void eliminar(){
		mapa.eliminarObjeto(this, x, y);
	}
}
