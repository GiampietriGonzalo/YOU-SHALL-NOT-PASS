package Entidad;

import java.applet.Applet;
import java.applet.AudioClip;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Juego;
import Personajes.Aliado;

public class Curacion extends ObjetoPrecioso{
	
	protected AudioClip pocion = Applet.newAudioClip(this.getClass().getResource("/Musica_Sonidos/pocion.wav"));
	
	public Curacion(Juego j){
		super(j);
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/pocion.png"));
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
	}
	
	
	public void efecto(){
		pocion.play();
		for(Aliado a:j.getAliados())
			a.setVida(a.getVidaOriginal());
		
		this.morir();
		j.getManipulador().eliminarObjeto(this,this.x, this.y);
		this.grafico.setOpaque(false);
		
	}
}
