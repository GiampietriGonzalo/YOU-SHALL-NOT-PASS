package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Mapa;

public class Hobbit extends Aliado {
	
	public Hobbit(Mapa m) {
		super(m,15,40);
		precioAliado=10;
		rango=1;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Sam.png"));
		grafico=new JLabel(sprite);
	}

	public int getVidaOriginal() {
		return 40;
	}
	
	public void eliminar(){
		mapa.eliminarObjeto(this, x, y);
	}
}
