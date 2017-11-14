package ObjetosMapa;

import java.applet.Applet;
import java.applet.AudioClip;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Piedra extends ObjetoTemporal{

	AudioClip piedra = Applet.newAudioClip(this.getClass().getResource("/Musica_Sonidos/piedra.wav"));
	
	public Piedra() {
		super();
		piedra.play();
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/piedra.png"));
		grafico=new JLabel(sprite);
	}

	
	
}
