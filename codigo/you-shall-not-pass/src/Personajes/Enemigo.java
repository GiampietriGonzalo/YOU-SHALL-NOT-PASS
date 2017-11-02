package Personajes;


import Interacciones.*;

public abstract class Enemigo extends Personaje {
	
	protected int velocidad;
	protected int monedas;
	protected int puntos;
	protected EstadoEnemigo estado;
	
	public Enemigo(int damage,int vida){
		super(damage,vida);
		miVisitor=new VisitorEnemigo(this);
	}
	
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
	
	public void recibirDamage(int d){
		//System.out.println("Soy enemigo me pegaron con daño "+d);
		vida-=d;
		if(vida<=0){ 
			morir();
		}
	}
	
	public EstadoEnemigo getEstado() {return estado;}

	public void setVelocidad(int i) {
		velocidad=i;
	}
	
}
