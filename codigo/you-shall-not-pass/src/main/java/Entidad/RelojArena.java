package Entidad;

import java.applet.Applet;
import java.applet.AudioClip;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Juego;
import Personajes.Enemigo;

public class RelojArena extends MagiaTemporal{

	 	protected AudioClip reloj = Applet.newAudioClip(this.getClass().getResource("/Musica_Sonidos/reloj.wav")); 	

		public RelojArena(Juego j){
			super(j);
			sprite=new ImageIcon(this.getClass().getResource("/Imagenes/reloj.png"));
			grafico=new JLabel(sprite);
			grafico.setBackground(null);

		}
		
		/**
		 * Especifica el efecto de �ste Premio concreto.
		 * Efecto: ralentiza a todos los enemigos del mapa.
		 * */
		public void efecto() {
			reloj.play();

			for(Enemigo a:j.getEnemigos())
				a.ralentizar();
			
			this.morir();
			j.getManipulador().eliminarObjeto(this,this.x, this.y);
			this.grafico.setOpaque(false);
		}
}
