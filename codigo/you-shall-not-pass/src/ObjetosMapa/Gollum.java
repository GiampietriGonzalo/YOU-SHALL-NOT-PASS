package ObjetosMapa;

import java.applet.Applet;
import java.applet.AudioClip;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Gollum extends ObjetoConVida{
	
	AudioClip gollum = Applet.newAudioClip(this.getClass().getResource("/Musica_Sonidos/GollumGollum.wav"));
	
	public Gollum() {
		super();
		gollum.play();
		vida = 200;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Gollum.gif"));
		grafico=new JLabel(sprite);
		sprite.setImageObserver(grafico);
	}
	
	public void recibirDamage(int d) {
		vida-=d;
		if(vida<=0) this.morir();
	}
	
	

	public void efecto() {/*redefinir*/}
}
