package Personajes;

import java.awt.Color;

import javax.swing.JLabel;

import Logica.Juego;

public class Orco extends Enemigo {

	public Orco(Juego j) {
		super(j);
		// TODO Auto-generated constructor stub
		vive=true;
		color=Color.BLACK;
		grafico=new JLabel();
		grafico.setBackground(color);
	}

}
