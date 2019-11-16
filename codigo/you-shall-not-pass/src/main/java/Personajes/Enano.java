package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Logica.Mapa;

public class Enano extends Aliado{
	
	public Enano(Mapa m) {
		super(m,4,20);
		precioAliado=16;
		rango=0;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Enano.gif"));
		grafico=new JLabel(sprite);
	}

	public int getVidaOriginal() {
		return 30;
	}
	
	public int getDamageOriginal() {
		return 30;
	}
	
	public void eliminar(){
		mapa.eliminarObjeto(this, x, y);
	}

	public int getRangoOriginal() {
		return 0;
	}
}
