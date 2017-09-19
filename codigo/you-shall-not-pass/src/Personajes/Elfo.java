package Personajes;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Elfo extends Aliado {
	
	public Elfo(int x, int y){
		super(x,y);
		precioAliado=10;
		rango=3;
		vida=70;
		daño=18;
		sprite=new ImageIcon("C:/Users/Tom�s/Pictures/ProyectoTDP/humano.png");
		color=Color.GREEN;
		grafico=new JLabel();
		grafico.setBackground(color);
	}
}
