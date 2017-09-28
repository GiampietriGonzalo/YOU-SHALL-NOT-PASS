package Personajes;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Juego;

public class Elfo extends Aliado {
	
	public Elfo(Juego j) {
		super(j);
		precioAliado=10;
		rango=3;
		vida=70;
		damage=18;
		sprite=new ImageIcon("C:/Users/Tom�s/Pictures/ProyectoTDP/humano.png");
		color=Color.GREEN;
		grafico=new JLabel();
		grafico.setBackground(color);
	}
}
