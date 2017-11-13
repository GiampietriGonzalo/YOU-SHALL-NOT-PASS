package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Logica.Mapa;

public class Enano extends Aliado{
	
	public Enano(Mapa m) {
		super(m,3000000,7000000);
		precioAliado=16;
		rango=0;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Enano.gif"));
		grafico=new JLabel(sprite);
	}

	public int getVidaOriginal() {
		return 700;
	}
	
	public void eliminar(){
		mapa.eliminarObjeto(this, x, y);
	}
}
