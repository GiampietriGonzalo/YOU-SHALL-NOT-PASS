package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Huargo extends Enemigo {
	
	public Huargo(){
		super(20,30);
		velocidad=10;
		puntos=20;
		monedas=7;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Huargo.png"));
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
	}

	@Override
	public int getVidaOriginal() {
		// TODO Auto-generated method stub
		return 30;
	}
}
