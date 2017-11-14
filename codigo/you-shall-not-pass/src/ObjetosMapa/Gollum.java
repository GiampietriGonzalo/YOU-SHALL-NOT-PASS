package ObjetosMapa;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Gollum extends ObjetoMapa{
	
	private int vida;
	
	public Gollum() {
		super();
		System.out.println("Gollum");
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
