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

		@Override
		public void efecto() {
			for(Enemigo a:miJuego.getEnemigos()){
				a.setVelocidad(a.getVelocidad()/2);
			}
			System.out.println("Recibieron damage");
			this.morir();
			miJuego.eliminarObjeto(this,this.x, this.y);
			this.grafico.setOpaque(false);
		}
}
