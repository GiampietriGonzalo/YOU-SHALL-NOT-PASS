package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enano extends Aliado{
	public Enano() {
		super(300,700);
		precioAliado=16;
		rango=0;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Gimli.png"));
		grafico=new JLabel(sprite);
	}

	@Override
	public int getVidaOriginal() {
		// TODO Auto-generated method stub
		return 700;
	}
}
