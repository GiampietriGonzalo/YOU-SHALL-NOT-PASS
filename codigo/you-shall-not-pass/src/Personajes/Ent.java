package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Mapa;

public class Ent extends Aliado {
	
	
	public Ent(Mapa m) {
		super(m,30, 60);
		precioAliado=20;
		rango=0;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Ent.png"));
		grafico=new JLabel(sprite);
	}


	public int getVidaOriginal() {
		return 60;
	}
	
	public JLabel getGrafico() {
		grafico.setBounds(posX,posY,64,128);
		return grafico;
	}

	
	public void eliminar(){
		mapa.eliminarObjeto(this, x, y+1);
		mapa.eliminarObjeto(this, x, y);
	}
	
}
