package ObjetosMapa;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Gandalf extends ObjetoMapa{

	
	public Gandalf() {
		super();
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/GandalfElGris.png"));
		grafico=new JLabel(sprite);
	}

	
}