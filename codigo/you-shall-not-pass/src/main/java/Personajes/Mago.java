package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Mapa;

public class Mago extends Aliado {
	
	public Mago(Mapa m) {
		super(m,3,18);
		precioAliado=20;
		rango=3;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Mago.gif"));
		grafico=new JLabel(sprite);
	}


	public int getVidaOriginal() {
		return 18;
	}
	
	public int getDamageOriginal() {
		return 3;
	}
	
	public int getRangoOriginal() {
		return 3;
	}
	
	
	public void eliminar(){
		mapa.eliminarObjeto(this, x, y);
	}
}
