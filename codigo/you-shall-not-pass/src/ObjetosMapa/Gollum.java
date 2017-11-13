package ObjetosMapa;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Gollum extends ObjetoMapa{
	
	private int vida;
	
	public Gollum() {
		super();
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Gollum.png"));
		grafico=new JLabel(sprite);
	}
	
	public void recibirDamage(int d) {
		vida-=d;
		if(vida<=0) this.morir();
	}
	
	

	public void efecto() {/*redefinir*/}
}
