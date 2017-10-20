package Personajes;

import Interacciones.*;
import Logica.Juego;

public abstract class Enemigo extends Personaje {
	
	public Enemigo(Juego j) {
		super(j);
	}
	
	protected int velocidad;
	protected int monedas;
	protected int puntos;
	protected VisitorEnemigo miVisitor;
	
	public void accept(Visitor v){
		v.visit(this);
	}
	
	public int getVelocidad(){
		return velocidad;
	}
	
	public int getMonedas(){
		return monedas;
	}
	
	public int getPuntos(){
		return puntos;
	}
	
	public void mover(){
		if(x<4) {
			if(juego.getMapa().getObject(x+1,y)==null) {
				juego.getMapa().eliminarObjeto(this,x, y);
				posX+=velocidad;
				x=posX/64;
				juego.getMapa().agregarObjeto(this, x, y);
				this.grafico.setBounds(posX,posY, 64, 64);
				if(x==8) morir();
			}
		}
		else disparar();
	}
	
	protected void disparar(){
		Disparo d=new DisparoEnemigo(juego,this,x,y);
		d.setPosGrafic((x+1)*64,y*64);
		juego.agregarObjeto(d, this.getX()+1, this.getY());
		d.start();
	}
}
