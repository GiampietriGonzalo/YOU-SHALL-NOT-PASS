package ObjetosMapa;

import java.applet.Applet;
import java.applet.AudioClip;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Personajes.Enemigo;

public class Gollum extends ObjetoConVida{
	
	protected AudioClip gollum = Applet.newAudioClip(this.getClass().getResource("/Musica_Sonidos/GollumGollum.wav"));
	
	public Gollum() {
		super();
		gollum.play();
		vida = 200;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Gollum.gif"));
		grafico=new JLabel(sprite);
		sprite.setImageObserver(grafico);
	}
	
	public void recibirDamage(int d, Enemigo e) {
		e.setSprite("/Imagenes/pelea.gif");
		vida-=d;
		if(vida<=0){
			e.setSprite("/Imagenes/"+e.getClass().getSimpleName()+".gif");
			this.setSprite("/Imagenes/sangre.gif");
			this.morir();
		}
	}
}
