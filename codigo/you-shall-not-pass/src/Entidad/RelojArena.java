package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Juego;

public class RelojArena extends ObjetoPrecioso{
		
		public RelojArena(Juego j){
			super(j);
			sprite=new ImageIcon(this.getClass().getResource("/Imagenes/reloj.png"));
			grafico=new JLabel(sprite);
			grafico.setBackground(null);

		}

		@Override
		public void efecto() {
			// TODO Auto-generated method stub
			
		}
}
