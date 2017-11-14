package ObjetosMapa;

import java.applet.Applet;
import java.applet.AudioClip;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Agua extends ObjetoTemporal{

	AudioClip agua = Applet.newAudioClip(this.getClass().getResource("/Musica_Sonidos/agua.wav"));
	
	public Agua() {
		super();
		agua.play();
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/water.png"));
		grafico=new JLabel(sprite);
	}

	
	
}