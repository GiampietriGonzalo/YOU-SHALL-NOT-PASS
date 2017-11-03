package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ent extends Aliado {

	public Ent() {
		super(60, 60);
		precioAliado=20;
		rango=0;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Ent.png"));
		grafico=new JLabel(sprite);
	}

	@Override
	public int getVidaOriginal() {
		// TODO Auto-generated method stub
		return 60;
	}
	
	public JLabel getGrafico() {
		grafico.setBounds(posX,posY,64,128);
		return grafico;
	}
}
