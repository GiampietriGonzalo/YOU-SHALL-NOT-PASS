package ObjetosMapa;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Agua extends ObjetoMapa{

	public Agua() {
		super();
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/water.png"));
		grafico=new JLabel(sprite);
	}

	
	
}