package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Mapa;

public class Elfo extends Aliado {
	
	public Elfo(Mapa m) {
		super(m,18,70);
		precioAliado=12;
		rango=3;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Elfo.gif"));
		grafico=new JLabel(sprite);
	}


	public int getVidaOriginal() {
		return 70;
	}
	
	public void eliminar(){
		mapa.eliminarObjeto(this, x, y);
	}
}
