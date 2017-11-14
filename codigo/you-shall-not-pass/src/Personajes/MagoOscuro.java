package Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Mapa;

public class MagoOscuro extends Enemigo {

	public MagoOscuro(Mapa m) {
		super(m,20,70);
		vive=true;
		rango=3;
		velocidad=32;
		puntos=20;
		monedas=7;
		sprite=new ImageIcon(this.getClass().getResource("/Imagenes/MagoOscuro.gif"));
		grafico=new JLabel(sprite);
		grafico.setBackground(null);
	}

	public int getVidaOriginal() {
		return 70;
	}

	
}
