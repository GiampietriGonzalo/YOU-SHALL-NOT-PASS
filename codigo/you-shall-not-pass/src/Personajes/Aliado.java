package Personajes;

import Interacciones.*;

public abstract class Aliado extends Personaje {
	
	protected int precioAliado;
	protected EstadoAliado estado;
	
	public Aliado(int damage,int vida){
		super(damage,vida);
		miVisitor=new VisitorAliado(this);
	}
	
	public void accept(Visitor v){
		v.visit(this);
	}
	
	public int getPrecioAliado(){
		return precioAliado;
	}
	
	public void recibirDamage(int d){
		vida-=d;
		if(vida<=0) morir();
	}
	
	public EstadoAliado getEstado() {return estado;}
	
}
