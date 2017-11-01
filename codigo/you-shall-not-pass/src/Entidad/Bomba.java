package Entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Juego;

public class Bomba extends ObjetoPrecioso{
	
	
	public Bomba(Juego j){
		super(j);
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/bomba.png"));
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
	}

	@Override
	public void efecto() {
		// TODO Auto-generated method stub
		
	}

}
