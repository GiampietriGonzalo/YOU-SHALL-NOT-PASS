package Logica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Personajes.Aliado;

public class Torre extends Aliado {
	
	public Torre(ImageIcon imagen) {
		super(0,200);
		rango=0;
		vida=200;
		sprite=imagen;
		grafico=new JLabel(sprite);
	}
	
}
