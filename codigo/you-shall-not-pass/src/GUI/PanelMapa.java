package GUI;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelMapa extends JPanel{
	
	 public void paint(Graphics g) {
		 	ImageIcon fondo;
		 	fondo=new ImageIcon(this.getClass().getResource("/Imagenes/Pasto.jpg"));
	        g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(),this);
	        setOpaque(false);
	        super.paint(g);
	        this.setBackground(null);
	    }
	
}
