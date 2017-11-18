package Logica;

import java.applet.Applet;
import java.applet.AudioClip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Personajes.Aliado;

/**
 * Clase que representa la base aliada a defender.
 * */
public class Torre extends Aliado {

	private AudioClip caer = Applet.newAudioClip(this.getClass().getResource("/Musica_Sonidos/caida_torre.WAV")); 

	
	public Torre(Mapa m,ImageIcon imagen,int x, int y) {
		super(m,5,50);
		this.x=x;
		this.y=y;
		rango=0;
		sprite=imagen;
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
	}

	
	
	public int getVidaOriginal() {
		return 50;
	}
	
	public int getDamageOriginal() {
		return 5;
	}
	
	public int getRangoOriginal() {
		return 0;
	}
	
	public void setSprite (String s){
		String e="";
		if (this.getVida()<=this.getVidaOriginal())
			e = "/Imagenes/"+this.getClass().getSimpleName()+"Rota1.gif";
		if (this.getVida()<this.getVidaOriginal()/2)
			e = "/Imagenes/"+this.getClass().getSimpleName()+"Rota2.gif";
		if (this.getVida()<this.getVidaOriginal()/4)
			e = "/Imagenes/"+this.getClass().getSimpleName()+"Rota3.gif";
		if(e!="")
			sprite = new ImageIcon(this.getClass().getResource(e));
		grafico.setIcon(sprite);
		grafico.setOpaque(false);
		grafico.repaint();
		sprite.setImageObserver(grafico);
		this.getGrafico();
		grafico.setBackground(null);
	}
	
	/*
	 * Elimina la torre al ser destruida.
	 * **/
	public void eliminar(){
		setSprite("/Imagenes/explosion.gif");
		caer.play();
		mapa.eliminarObjeto(this, 9, y);
	}
	
}
