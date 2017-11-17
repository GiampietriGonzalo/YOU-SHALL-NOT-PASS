package Entidad;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Juego;
import Personajes.Aliado;
import Personajes.AliadoProtegido;


public class Anillo extends MagiaTemporal {

	public Anillo(Juego j) {
		super(j);
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/Anillo.png"));
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
	}

	public void efecto() {
		
		Random r=new Random(System.currentTimeMillis());
		int i=r.nextInt(j.getAliados().size());
		Aliado l=j.getAliados().get(i);
		if(l.getX()!=9)
			l.setEstado(new AliadoProtegido(l));
		
			
		this.morir();
		j.getManipulador().eliminarObjeto(this,this.x, this.y);
		this.grafico.setOpaque(false);
	}

}