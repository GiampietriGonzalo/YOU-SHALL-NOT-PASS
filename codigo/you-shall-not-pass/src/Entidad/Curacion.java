package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Curacion extends ObjetoPrecioso{
	
	public Curacion(){
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/pocion.png"));
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
	}

}
