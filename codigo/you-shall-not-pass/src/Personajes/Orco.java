package Personajes;

import java.awt.Color;

import javax.swing.JLabel;

public class Orco extends Enemigo {

	public Orco(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		vive=true;
		color=Color.BLACK;
		grafico=new JLabel();
		grafico.setBackground(color);
	}

}
