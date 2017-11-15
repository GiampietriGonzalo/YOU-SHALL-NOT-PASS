package Entidad;

import java.applet.Applet;
import java.applet.AudioClip;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Juego;
import Personajes.Enemigo;

public class RelojArena extends ObjetoPrecioso{
		
	AudioClip reloj = Applet.newAudioClip(this.getClass().getResource("/Musica_Sonidos/reloj.wav"));
	
		public RelojArena(Juego j){
			super(j);
			sprite=new ImageIcon(this.getClass().getResource("/Imagenes/reloj.png"));
			grafico=new JLabel(sprite);
			grafico.setBackground(null);

		}

		public void efecto() {
			reloj.play();
			for(Enemigo a:miJuego.getEnemigos()){
				a.relentizar();
			}
			this.morir();
			miJuego.eliminarObjeto(this,this.x, this.y);
			this.grafico.setOpaque(false);
		}
}
