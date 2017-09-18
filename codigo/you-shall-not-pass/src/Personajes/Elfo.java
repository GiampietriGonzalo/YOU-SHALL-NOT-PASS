package Personajes;

import java.awt.Color;

import javax.swing.ImageIcon;

public class Elfo extends Aliado {
	
	public Elfo(){
		precioAliado=10;
		rango=3;
		vida=70;
		daño=18;
		sprite=new ImageIcon("C:/Users/Tomás/Pictures/ProyectoTDP/humano.png");
		color=Color.GREEN;
	}
}
