package Logica;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class GameObject extends Thread {
	protected int x;
	protected int y;
	protected ImageIcon sprite;
	protected boolean vive;
	protected Color color;
	protected JLabel grafico;
	
	public GameObject(int x, int y){
		this.x=x;
		this.y=y;
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
	
	public boolean estaVivo(){
		return vive;
	}
	
	public void morir(){
		vive=false;
	}
	public JLabel getGrafico() {
		grafico.setBounds(x,y,64,64);
		return grafico;
	}
}
