package Entidad;

import java.applet.Applet;
import java.applet.AudioClip;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Juego;
import Personajes.Enemigo;

public class Bomba extends ObjetoPrecioso{
	
	AudioClip bomba = Applet.newAudioClip(this.getClass().getResource("/Musica_Sonidos/bomba.wav"));
	
	public Bomba(Juego j){
		super(j);
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/bomba.png"));
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
	}
	
	public void efecto() {
		bomba.play();
		for(Enemigo a:miJuego.getEnemigos()){
			a.recibirDamage(40,null);
		}
		this.morir();
		miJuego.eliminarObjeto(this,this.x, this.y);
		this.grafico.setOpaque(false);
	}

}