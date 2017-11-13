package ObjetosMapa;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Piedra extends ObjetoMapa{

	public Piedra() {
		super();
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/piedra.png"));
		grafico=new JLabel(sprite);
	}

	
	
}
