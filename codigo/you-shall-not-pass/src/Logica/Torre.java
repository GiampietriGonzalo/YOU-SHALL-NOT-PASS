package Logica;

import java.applet.Applet;
import java.applet.AudioClip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Personajes.Aliado;

public class Torre extends Aliado {

	//private AudioClip caer = Applet.newAudioClip(this.getClass().getResource("/Musica_Sonidos/caida_torre.WAV")); 

	
	public Torre(Mapa m,ImageIcon imagen,int x, int y) {
		super(m,20,10);
		this.x=x;
		this.y=y;
		rango=0;
		sprite=imagen;
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
	}

	
	
	public int getVidaOriginal() {
		return 200;
	}
	
	public int getDamageOriginal() {
		return 20;
	}
	
	public int getRangoOriginal() {
		return 0;
	}
	
	
	public void eliminar(){
		//caer.play();
		mapa.eliminarObjeto(this, 9, y);
	}
	
}
