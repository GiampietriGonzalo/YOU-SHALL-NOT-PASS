package Logica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Interacciones.Visitor;

public abstract class GameObject extends Thread {
	protected int x;
	protected int y;
	protected ImageIcon sprite;
	protected boolean vive;
	protected JLabel grafico;
	protected int posX;
	protected int posY;
	protected int puntos;
	protected int tiempo;
	protected Visitor miVisitor;
	
	public GameObject(){
		tiempo=20;
		vive=true;
	}
	
	public ImageIcon getImg(){
		return sprite;
	}
	
	public int getPuntos(){
		return puntos;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int X){
		x=X;
	}
	
	public void setY(int Y){
		y=Y;
	}
	
	public void setPosGrafic(int x, int y){
		posX=x;
		posY=y;
	}
	
	public boolean estaVivo(){
		return vive;
	}
	
	public void morir(){
		vive=false;
	}
	
	public JLabel getGrafico() {
		grafico.setBounds(posX,posY,64,64);
		return grafico;
	}
	
	public void setSprite (String s){
		sprite = new ImageIcon(this.getClass().getResource(s));
		grafico.setOpaque(false);
		grafico.setIcon(sprite);
		grafico.repaint();
		sprite.setImageObserver(grafico);
		this.getGrafico();
		grafico.setBackground(null);
	}

	public abstract void accept(Visitor v);
	
	public abstract void actualizar();
	
	public abstract void efecto();
	
	public int vender() {
		return 0;
	}
	
	
}
