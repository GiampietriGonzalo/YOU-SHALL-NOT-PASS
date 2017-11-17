package Entidad;

import java.applet.*;
import javax.swing.*;
import Logica.Juego;
import Personajes.Enemigo;

public class Bomba extends ObjetoPrecioso{
	
	protected AudioClip bomba = Applet.newAudioClip(this.getClass().getResource("/Musica_Sonidos/bomba.wav"));
	
	public Bomba(Juego j){
		super(j);
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/bomba.png"));
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
	}
	
	public void efecto() {
		bomba.play();
		for(Enemigo a:j.getEnemigos()){
			a.recibirDamage(40,null);
		}
		this.morir();
		j.getManipulador().eliminarObjeto(this,this.x, this.y);
		this.grafico.setOpaque(false);
	}
}

