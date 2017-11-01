package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Hobbit extends Aliado {
	
	public Hobbit() {
		super(15,40);
		precioAliado=10;
		rango=1;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Sam.png"));
		grafico=new JLabel(sprite);
	}

	@Override
	public int getVidaOriginal() {
		// TODO Auto-generated method stub
		return 40;
	}
	
}
