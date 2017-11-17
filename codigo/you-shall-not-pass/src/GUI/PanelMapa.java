package GUI;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelMapa extends JPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void paint(Graphics g) {
		ImageIcon imagenFondo= new ImageIcon(this.getClass().getResource("/Imagenes/Pasto.jpg"));
		g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(),this);
 
        setOpaque(false);
        super.paint(g);
    }
}
