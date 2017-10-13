package Logica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class GameObject extends Thread {
	protected Juego juego;
	protected int x;
	protected int y;
	protected ImageIcon sprite;
	protected boolean vive;
	protected JLabel grafico;
	protected int posX;
	protected int posY;
	
	public GameObject(Juego j){
		juego=j;
		vive=true;
	}
	public ImageIcon getImg(){
		return sprite;
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
}
