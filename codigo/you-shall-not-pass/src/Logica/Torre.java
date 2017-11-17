package Logica;

import java.applet.Applet;
import java.applet.AudioClip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Personajes.Aliado;

public class Torre extends Aliado {

	protected AudioClip caer = Applet.newAudioClip(this.getClass().getResource("/Musica_Sonidos/caida_torre.WAV")); 

	
	public Torre(Mapa m,ImageIcon imagen,int x, int y) {
		super(m,5,500);
		this.x=x;
		this.y=y;
		rango=0;
		sprite=imagen;
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
	}

	
	
	public int getVidaOriginal() {
		return 200;
	}
	
	public int getDamageOriginal() {
		return 20;
	}
	
	public int getRangoOriginal() {
		return 0;
	}
	
	public void setSprite (String s){
		if (this.getVida()<=500)
			s = "/Imagenes/"+this.getClass().getSimpleName()+"Rota1.gif";
		if (this.getVida()<250)
			s = "/Imagenes/"+this.getClass().getSimpleName()+"Rota2.gif";
		if (this.getVida()<100)
			s = "/Imagenes/"+this.getClass().getSimpleName()+"Rota3.gif";
		sprite = new ImageIcon(this.getClass().getResource(s));
		grafico.setIcon(sprite);
		grafico.setOpaque(false);
		grafico.repaint();
		sprite.setImageObserver(grafico);
		this.getGrafico();
		grafico.setBackground(null);
	}
	
	public void eliminar(){
		setSprite("/Imagenes/explosion.gif");
		caer.play();
		mapa.eliminarObjeto(this, 9, y);
	}
	
}
