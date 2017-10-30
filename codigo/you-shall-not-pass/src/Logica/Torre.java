package Logica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Personajes.Aliado;

public class Torre extends Aliado {
	
	public Torre(ImageIcon imagen) {
		rango=1;
		vida=200;
		damage=10;
		sprite=imagen;
		grafico=new JLabel(sprite);
	}

}
