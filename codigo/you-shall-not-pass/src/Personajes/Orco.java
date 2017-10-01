package Personajes;

import java.awt.Color;

import javax.swing.JLabel;

import Logica.Juego;

public class Orco extends Enemigo {

	public Orco(Juego j) {
		super(j);
		vive=true;
		velocidad=32;
		puntos=20;
		monedas=7;
		color=Color.BLACK;
		grafico=new JLabel();
		grafico.setBackground(color);
	}

}
