package Logica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Personajes.Aliado;

public class Torre extends Aliado {
	
	public Torre(ImageIcon imagen) {
		super(50,20);
		rango=0;
		sprite=imagen;
		grafico=new JLabel(sprite);
	}

	@Override
	public int getVidaOriginal() {
		// TODO Auto-generated method stub
		return 200;
	}
	
}
