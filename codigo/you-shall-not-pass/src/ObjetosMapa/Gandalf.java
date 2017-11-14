package ObjetosMapa;

import java.applet.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Gandalf extends ObjetoMapa{

	AudioClip clip = Applet.newAudioClip(this.getClass().getResource("/Musica/NotPass.wav"));
	
	public Gandalf() {
		super();
		System.out.println("Gandalf");
		clip.play();
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/GandalfElGris.png"));
		grafico=new JLabel(sprite);
	}

	
}