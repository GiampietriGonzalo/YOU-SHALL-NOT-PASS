package ObjetosMapa;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Personajes.Enemigo;

public class Ent2 extends ObjetoConVida{
	
	public Ent2() {
		super();
		vida = 12;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/ent2.gif"));
		grafico=new JLabel(sprite);
		sprite.setImageObserver(grafico);
	}
	
	public void recibirDamage(int d, Enemigo e) {
		vida-=d;
		if(vida<=0) {
			this.setSprite("/Imagenes/sangre.gif");
			e.setSprite("/Imagenes/"+e.getClass().getSimpleName()+".gif");
			this.morir();
		}
	}
}
