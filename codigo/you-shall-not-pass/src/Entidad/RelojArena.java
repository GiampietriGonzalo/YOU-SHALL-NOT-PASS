package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Juego;
import Personajes.Enemigo;

public class RelojArena extends ObjetoPrecioso{
		
		public RelojArena(Juego j){
			super(j);
			sprite=new ImageIcon(this.getClass().getResource("/Imagenes/reloj.png"));
			grafico=new JLabel(sprite);
			grafico.setBackground(null);

		}

		public void efecto() {
			for(Enemigo a:miJuego.getEnemigos()){
				a.relentizar();
			}
			this.morir();
			miJuego.eliminarObjeto(this,this.x, this.y);
			this.grafico.setOpaque(false);
		}
}
