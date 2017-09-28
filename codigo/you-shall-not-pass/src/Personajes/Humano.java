package Personajes;
import java.awt.Color;

import javax.swing.JLabel;

import Logica.Juego;
public class Humano extends Aliado {
	
	public Humano(int x, int y,Juego j) {
		super(x,y,j);
		precioAliado=10;
		rango=1;
		vida=50;
		damage=12;
		//sprite=new ImageIcon("C:/Users/Tom�s/Pictures/ProyectoTDP/humano.png");
		vive=true;
		color=Color.cyan;
		grafico=new JLabel();
		grafico.setBackground(color);
	}
}
