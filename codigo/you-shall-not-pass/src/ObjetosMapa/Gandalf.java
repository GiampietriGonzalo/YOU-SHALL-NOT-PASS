package ObjetosMapa;

import java.applet.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Gandalf extends ObjetoTemporal{
	
	AudioClip gandalf = Applet.newAudioClip(this.getClass().getResource("/Musica_Sonidos/NotPass.wav"));
	
	public Gandalf() {
		super();
		gandalf.play();
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/GandalfElGris.png"));
		grafico=new JLabel(sprite);
	}
}