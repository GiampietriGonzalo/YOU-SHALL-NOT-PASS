package Personajes;

import java.awt.Color;

import javax.swing.ImageIcon;

public class Elfo extends Aliado {
	
	public Elfo(){
		precioAliado=10;
		rango=3;
		vida=70;
		da�o=18;
		sprite=new ImageIcon("C:/Users/Tom�s/Pictures/ProyectoTDP/humano.png");
		color=Color.GREEN;
	}
}
