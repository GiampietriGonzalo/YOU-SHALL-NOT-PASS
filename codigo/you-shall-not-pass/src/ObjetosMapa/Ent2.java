package ObjetosMapa;

import java.applet.Applet;
import java.applet.AudioClip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Personajes.Enemigo;

public class Ent2 extends ObjetoConVida{
	
	//AudioClip gollum = Applet.newAudioClip(this.getClass().getResource("/Musica_Sonidos/GollumGollum.wav"));
	
	public Ent2() {
		super();
		//gollum.play();
		vida = 300;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/ent2.gif"));
		grafico=new JLabel(sprite);
		sprite.setImageObserver(grafico);
	}
	
	public void recibirDamage(int d, Enemigo e) {
		e.setSprite("/Imagenes/pelea.gif");
		vida-=d;
		if(vida<=0) {
			this.setSprite("/Imagenes/sangre.gif");
			e.setSprite("/Imagenes/"+e.getClass().getSimpleName()+".gif");
			this.morir();
		}
	}
}
