package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bomba extends Magia{
	
	public Bomba(){
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/bomba.png"));
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
	}

}
