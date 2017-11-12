package Logica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Personajes.Aliado;

public class Torre extends Aliado {
	
	
	public Torre(Mapa m,ImageIcon imagen,int x, int y) {
		super(m,500,100);
		this.x=x;
		this.y=y;
		rango=0;
		sprite=imagen;
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
	}

	public int getVidaOriginal() {
		return 200;
	}
	
	public void eliminar(){
		mapa.eliminarObjeto(this, 9, y);
	}
	
}
