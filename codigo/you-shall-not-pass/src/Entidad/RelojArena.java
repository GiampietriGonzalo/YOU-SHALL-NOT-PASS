package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RelojArena extends Magia{
		
		public RelojArena(){
			sprite=new ImageIcon(this.getClass().getResource("/Imagenes/reloj.png"));
			grafico=new JLabel(sprite);
			grafico.setBackground(null);

		}
}
