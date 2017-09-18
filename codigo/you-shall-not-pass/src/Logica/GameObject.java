package Logica;

import javax.swing.ImageIcon;

public abstract class GameObject extends Thread {
	protected int x;
	protected int y;
	protected ImageIcon sprite;
	
	public ImageIcon getImg(){
		return sprite;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	//setImg me parecio al pedo, mandalo al constructor ATR
	
	public void setX(int X){
		x=X;
	}
	
	public void setY(int Y){
		y=Y;
	}
}
