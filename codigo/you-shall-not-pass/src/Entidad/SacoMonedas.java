package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Juego;

public class SacoMonedas extends ObjetoPrecioso {

	public SacoMonedas(Juego j) {
		super(j);
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Saco.png"));
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
	}

	
	public void efecto() {
		j.getAritmetica().sumarMonedas(100);
		this.morir();
		j.getManipulador().eliminarObjeto(this,this.x, this.y);
		this.grafico.setOpaque(false);
	}
	
}
