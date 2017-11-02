package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Juego;
import Personajes.Aliado;

public class Curacion extends ObjetoPrecioso{
	
	public Curacion(Juego j){
		super(j);
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/pocion.png"));
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
	}
	
	
	public void efecto(){
		for(Aliado a:miJuego.getAliados()){
			a.setVida(a.getVidaOriginal());
		}
		this.morir();
		miJuego.eliminarObjeto(this,this.x, this.y);
		this.grafico.setOpaque(false);
		
	}
}
